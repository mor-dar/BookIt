package com.example.bookit;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.opencv.android.Utils;
import org.opencv.core.CvException;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.highgui.Highgui;

import com.example.bookit.MainActivity.Similarity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.PowerManager;
import android.util.Log;
import android.view.Window;
import android.widget.Toast;

public class Splash extends Activity {
private long ms=0;
private long splashTime=2000;
private boolean splashActive = true;
private boolean paused=false;

private Context splashContext = this; 
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    //Hides the titlebar
    this.requestWindowFeature(Window.FEATURE_NO_TITLE);

    setContentView(R.layout.splash);
        
    
    
 

    Thread mythread = new Thread() {
        public void run() {
        	
            try {
            	 
                while (splashActive && ms < splashTime) {
                    if(!paused)
                        ms=ms+100;
                    sleep(100);
                   
                }
                
            } catch(Exception e) {}
            finally {
            	
                Intent intent = new Intent(Splash.this, MainActivity.class);
                startActivity(intent);
                Splash.this.finish();
            }
        }
    };
    mythread.start();

    
    // If the database doesn't exist build it.
    // Create the program folder if it doesn't exist.
    String bookItDir = Environment.getExternalStorageDirectory().toString()+"/BookIt";
    new File(bookItDir).mkdirs();
    
    // Check if the database is built, if not, create it.
    String databasePath = Environment.getExternalStorageDirectory().toString()+"/BookIt/database.xml";

	File db = new File(databasePath); 
	if (!db.exists() && !db.isDirectory()){
		
		// As the database does not exist - we assume that the book folder doesn't exist either.
		// Get the book folder so we can build the database?
		// ************* SHOULD WE JUST DOWNLOAD THE XML FROM A DATABASE INSTEAD?? *****************
		// (the book cover folder is smaller...
		
		GetBooks getBooks = new GetBooks(splashContext);
		getBooks.execute("http://www.mor-dar.com/ImageProcessing/database.xml");
		
		//BuildDatabase buildTask = new BuildDatabase(splashContext);
		//buildTask.execute();
	}
}


//******************************************************************************* 
// Download The Book Images
//*******************************************************************************
	private class GetBooks extends AsyncTask<String, Integer, String> 
	{
		private Context context;

		private ProgressDialog pdialog;
		
		private PowerManager.WakeLock mWakeLock;
		
		public GetBooks(Context context){
			this.context = context;
			this.pdialog = new ProgressDialog(context);
			this.pdialog.setMessage("Please wait, this may take a few minutes.");
			this.pdialog.setTitle("Updating Book List");
			this.pdialog.setIndeterminate(true);
			this.pdialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		}
		
		/** Before building the database, let the user know what's happening**/
	    protected void onPreExecute() {
	    	
	    	// take CPU lock to prevent CPU from going off if the user 
	        // presses the power button during download
	        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
	        mWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, getClass().getName());
	        mWakeLock.acquire();
	    	
	    	
	    	paused = true;
	    	// Load processing dialog
	    	this.pdialog.show();	    	
	    }
	    
	    @Override
	    protected void onProgressUpdate(Integer... progress) {
	        super.onProgressUpdate(progress);
	        // if we get here, length is known, now set indeterminate to false
	        this.pdialog.setIndeterminate(false);
	        this.pdialog.setMax(100);
	        this.pdialog.setProgress(progress[0]);
	    }
	    
	    @Override
	    protected void onPostExecute(String result) {
	    	mWakeLock.release();
	    	// Dismiss the dialog
	    	this.pdialog.dismiss();
	    	paused = false;

	    	
	    	if (result != null)
	            Toast.makeText(context,"Download error: "+result, Toast.LENGTH_LONG).show();
	        else
	            Toast.makeText(context,"File downloaded", Toast.LENGTH_SHORT).show();
	    	
	    }
		
		@Override
		protected String doInBackground(String... sUrl) { 
			// Download the books.
			
			InputStream input = null;
		    OutputStream output = null;
		    HttpURLConnection connection = null;
		    try {
		        URL url = new URL(sUrl[0]);
		        connection = (HttpURLConnection) url.openConnection();
		        connection.connect();

		        // expect HTTP 200 OK, so we don't mistakenly save error report
		        // instead of the file
		        if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
		            return "Server returned HTTP " + connection.getResponseCode()
		                    + " " + connection.getResponseMessage();
		        }
		        // this will be useful to display download percentage
		        // might be -1: server did not report the length
		        int fileLength = connection.getContentLength();

		        // 	download the file
		        input = connection.getInputStream();
		        output = new FileOutputStream("/sdcard/BookIt/database.xml");

		        byte data[] = new byte[4096];
		        long total = 0;
		        int count;
		        while ((count = input.read(data)) != -1) {
		        	// allow canceling with back button
		        	if (isCancelled()) {
		        		input.close();
		        		return null;
		        	}
		        	total += count;
		        	// publishing the progress....
		        	if (fileLength > 0) // only if total length is known
		        		publishProgress((int) (total * 100 / fileLength));
		        	output.write(data, 0, count);
		        }
		    } catch (Exception e) {
		    	return e.toString();
		    } finally {
		    	try {
		    		if (output != null)
		    			output.close();
		    		if (input != null)
		    			input.close();
		    	} catch (IOException ignored) {
		    	}

		    	if (connection != null)
		    		connection.disconnect();
		    }

		    return null; 
		}
	}



//******************************************************************************* 
// Build the database
//*******************************************************************************
	public class BuildDatabase  extends AsyncTask<String, Integer , Void>
	{
		private Context context;
		private String message;
		private String title;
		private ProgressDialog pdialog;
		
		public BuildDatabase(Context context){
			this.context = context;
			this.title = "Building The Database";
			this.message = "Please Wait...";
		}
		
		/** Before building the database, let the user know what's happening**/
	    protected void onPreExecute() {
	    	// Load processing dialog
	    	this.pdialog = ProgressDialog.show(context, title, message);	
	    	paused = true;
	    }
	    
	    @Override
	    protected void onPostExecute(Void result) {
	    	// Dismiss the dialog
	    	this.pdialog.dismiss();
	    	paused = false;
	    }
		
		@Override
		protected Void doInBackground(String... params) { 
			// Build the database
			NonfreeJNILib.BuildDatabase();
			
			return null; 
		}
	}
}