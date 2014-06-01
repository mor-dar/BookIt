package com.example.bookit;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;
import org.opencv.android.Utils;
import org.opencv.core.CvException;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.ShutterCallback;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity
{

	private static final String TAG = "BookIt";

	Preview mPreview;
	ResultView mResultView;
	private Context mContext = this;

	//private ProgressDialog dialog;
	
	// the results of the c++ function.
	private String foundBooksString;
	List<Book>  foundBooks = new ArrayList<Book>();

	// The image information
	int imageHeight;
	int imageWidth;
	private final static String INPUT_IMG_FILENAME = "/BookIt/img1.jpg";
	private final static String INPUT_IMG_PATH = Environment
			.getExternalStorageDirectory().toString() + INPUT_IMG_FILENAME;

	// flag to check if camera is ready for capture
	private boolean mCameraReadyFlag = true;

	private BaseLoaderCallback mLoaderCallback = new BaseLoaderCallback(this)
	{
		@Override
		public void onManagerConnected(int status)
		{
			switch (status)
			{
			case LoaderCallbackInterface.SUCCESS:
			{
				Log.i(TAG, "OpenCV loaded successfully");
				// mOpenCvCameraView.enableView();
			}
				break;
			default:
			{
				super.onManagerConnected(status);
			}
				break;
			}
		}
	};

	// Called when the activity is first created.
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		
		super.onCreate(savedInstanceState);
		configureScreen();
		configurePreviews();
		loadOpenCV();
	}

	private void loadOpenCV()
	{
		OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_2_4_8, this,
				mLoaderCallback);
	}

	private void configurePreviews()
	{
		mResultView = new ResultView(this);
		mPreview = new Preview(this);
		setContentView(mPreview);
		addContentView(mResultView, new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT));
	}

	private void configureScreen()
	{
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
	}

	// onKeyDown is used to monitor button pressed and facilitate the switching
	// of views
	@Override
	public boolean onKeyDown(int keycode, KeyEvent event)
	{
		// check if the camera button is pressed
		if (keycode == KeyEvent.KEYCODE_CAMERA)
		{
			// if result
			if (mResultView.IsShowingResult)
			{
				mResultView.IsShowingResult = false;
			} else if (mCameraReadyFlag == true)// switch to camera view
			{
				mCameraReadyFlag = false;
				mPreview.camera.takePicture(shutterCallback, rawCallback,
						jpegCallback);
			}
			return true;
		}
		return super.onKeyDown(keycode, event);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) /**
	 * When the user touches the
	 * screen, run sift
	 **/
	{
		if (event.getAction() == MotionEvent.ACTION_DOWN)
		{ // finger touches
			// the screen
			// if result
			if (mResultView.IsShowingResult) 
			{
				
				boolean bookClicked = false;
				// If more than one book was found, use the user's selection to find the correct url.
				if (foundBooks.size() > 1){
					
					// Save the point that the user touched on the result image.
					// Start by getting the screen resolution.
					Display display = getWindowManager().getDefaultDisplay();
					Point size = new Point();
					display.getSize(size);
					int width = size.x;
					int height = size.y;
					
					// Get the location the user touched using the image/screen ratio.
					float touchedX = event.getX() * ( (float) imageWidth / (float) width );
					float touchedY = event.getY() * ( (float) imageHeight / (float) height );
					
					// If a book is selected, open url.  Do not return to the preview until a user clicks on a non-book area.
					
					
					// for each book, check if the user selected that book.					
					for (int i = 0; i < foundBooks.size(); i ++){
						if (bookTouched(touchedX,touchedY,foundBooks.get(i))){
							bookClicked = true;
							// Load the website associated with the found book.
							Intent browserIntent = new Intent(Intent.ACTION_VIEW,
									Uri.parse(foundBooks.get(i).getLink()));
							startActivity(browserIntent);
						}	
					}
				}

				// If the touch event was not on a book, switch back to preview.
				if (!bookClicked){
					mResultView.IsShowingResult = false;
					setContentView(mPreview);
					// Clear the array list. 
					foundBooks.clear();  
				}
				
			} else if (mCameraReadyFlag == true)// If the camera is ready, take a picture.
			{
				mCameraReadyFlag = false;
				mPreview.camera.takePicture(shutterCallback, rawCallback,
						jpegCallback);
			}
		} 
		return true;
	}

	/**
	 * This method looks to see if the x and y coordinates the user touched 
	 * are in the book given.
	 * @param touchedX
	 * @param touchedY
	 * @param book
	 * @return
	 */
	private boolean bookTouched(float touchedX, float touchedY, Book book) {
		// If the sum of the areas of all the triangles is less than or equal to the area of the book than it is inside the book.
		ArrayList<Float> xCorners = book.getXcorners();
		ArrayList<Float> yCorners = book.getYcorners();
		
		// Get the rectangular centroid.
		float centX = (xCorners.get(0) + xCorners.get(1) + xCorners.get(2) + xCorners.get(3))/4;
		float centY = (yCorners.get(0) + yCorners.get(1) + yCorners.get(2) + yCorners.get(3))/4;
		
		// Get the area of the book cover (by splitting it into 4 triangles).
		float rectArea = triangleArea(xCorners.get(0),yCorners.get(0),xCorners.get(1),yCorners.get(1),centX,centY);
		rectArea += triangleArea(xCorners.get(1),yCorners.get(1),xCorners.get(2),yCorners.get(2),centX,centY);
		rectArea += triangleArea(xCorners.get(2),yCorners.get(2),xCorners.get(3),yCorners.get(3),centX,centY);
		rectArea += triangleArea(xCorners.get(3),yCorners.get(3),xCorners.get(0),yCorners.get(0),centX,centY);
		
		// Similarly calculate the area of the triangels created using the point.
		float pointArea = triangleArea(xCorners.get(0),yCorners.get(0),xCorners.get(1),yCorners.get(1),touchedX,touchedY);
		pointArea += triangleArea(xCorners.get(1),yCorners.get(1),xCorners.get(2),yCorners.get(2),touchedX,touchedY);
		pointArea += triangleArea(xCorners.get(2),yCorners.get(2),xCorners.get(3),yCorners.get(3),touchedX,touchedY);
		pointArea += triangleArea(xCorners.get(3),yCorners.get(3),xCorners.get(0),yCorners.get(0),touchedX,touchedY);
		

		Log.d(TAG, "link: " + book.getLink());
		Log.d(TAG, "touchedX: " + touchedX + " touchedy: "+touchedY);
		Log.d(TAG, "xcorners: " + xCorners.get(0)+" "+ xCorners.get(1)+ " "+ xCorners.get(2)+ " "+xCorners.get(3));
		Log.d(TAG, "ycorners: " + yCorners.get(0)+" "+ yCorners.get(1)+ " "+ yCorners.get(2)+ " "+yCorners.get(3));
		Log.d(TAG, "rectArea: " + rectArea);
		Log.d(TAG, "pointArea: " + pointArea); 
		if (Math.abs(rectArea - pointArea) < 1){
			return true;
		}
		
		return false;
	}
	
	/**
	 * This method calculates the area of the triange defined by the x,y 
	 * coordinates given.
	 * 
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param x3
	 * @param y3
	 * @return
	 */
	private float triangleArea(float x1, float y1, float x2, float y2, float x3, float y3){
		float area;
		
		area = (float) ((0.5) * ( (x1 * (y2 - y3)) + (x2 * (y3 - y1)) + (x3 * (y1 - y2)) ));
		
		return Math.abs(area);
	}

	// Called when shutter is opened
	ShutterCallback shutterCallback = new ShutterCallback()
	{
		public void onShutter()
		{
		}
	};

	// Handles data for raw picture
	PictureCallback rawCallback = new PictureCallback()
	{
		@Override
		public void onPictureTaken(byte[] arg0, android.hardware.Camera arg1)
		{
		}
	};

	public boolean compressByteImageHighQuality(Context mContext, byte[] imageData)
	{
		return compressByteImage(mContext, imageData, 100);
	}

	public boolean compressByteImage(Context mContext, byte[] imageData, int quality)
	{
		File sdCard = Environment.getExternalStorageDirectory();
		FileOutputStream fileOutputStream = null;

		try
		{
			BitmapFactory.Options options = new BitmapFactory.Options();
			options.inSampleSize = 4; // DOWNSAMPLE THE IMAGE SO IT WRITES
										// FASTER
			Bitmap myImage = BitmapFactory.decodeByteArray(imageData, 0, imageData.length, options);
			
			// save image resolution.
			imageHeight = myImage.getHeight();
			imageWidth = myImage.getWidth();
			
			fileOutputStream = new FileOutputStream(sdCard.toString() + INPUT_IMG_FILENAME);

			Log.e(TAG, sdCard.toString() + INPUT_IMG_FILENAME);
			BufferedOutputStream bos = new BufferedOutputStream(fileOutputStream);

			// compress image to jpeg
			myImage.compress(CompressFormat.JPEG, quality, bos);

			bos.flush();
			bos.close();
			fileOutputStream.close();

		} catch (FileNotFoundException e)
		{
			Log.e(TAG, "FileNotFoundException");
			e.printStackTrace();
		} catch (IOException e)
		{
			Log.e(TAG, "IOException");
			e.printStackTrace();
		}
		return true;
	}

	// Handles data for jpeg picture
	PictureCallback jpegCallback = new PictureCallback()
	{
		@Override
		public void onPictureTaken(byte[] imageData,
				android.hardware.Camera camera)
		{
			if (imageData != null)
			{
				Intent mIntent = new Intent();
				compressByteImageHighQuality(mContext, imageData);
				setResult(0, mIntent);

				// RUN SIFT ON THE SAVED PICTURE
				Similarity task = new Similarity(mContext);
				task.execute();
			}
		}
	};

	// *******************************************************************************
	// Get the similarity of the image
	// *******************************************************************************

	public class Similarity extends AsyncTask<String, Integer, Void>
	{
		public Mat img;
		private Context context;
		private String message;
		private String title;
		private ProgressDialog pdialog;

		public Similarity(Context context)
		{
			this.context = context;
			this.title = "Calculating";
			this.message = "Please Wait...";
		}

		/** Before running the sifts, load the image **/
		protected void onPreExecute()
		{
			// Stop running the camera
			mPreview.camera.stopPreview();

			// Load processing dialog
			this.pdialog = ProgressDialog.show(context, title, message);

			// Read the image
			img = Highgui.imread(INPUT_IMG_PATH, Highgui.CV_LOAD_IMAGE_COLOR);

			if (img.empty())
			{
				Log.e(TAG, "Did not read image!");
			} 
		}

		@Override
		protected void onPostExecute(Void result)
		{
			// Dismiss the dialog
			this.pdialog.dismiss();
			
			// If something was returned from the c++
			if (foundBooksString != null && !foundBooksString.isEmpty())
			{
				
				// Parse the string returned (note: we use '|' as a delimiter for information).
				String delimiter = "\\|";
				String[] temp;
				temp = foundBooksString.split(delimiter);
				
				// For each book found, save the url and corners in the image.
				String link = "";
				ArrayList<Float>  cornersX; 
				ArrayList<Float>  cornersY;
				Book tempBook;				
				for (int i = 0; i < temp.length; i = i + 9){
					// the first element is the link. 
					link = temp[i];
					
					cornersX = new ArrayList<Float>();
					cornersY = new ArrayList<Float>();
					
					// Save the x corners.
					cornersX.add(Float.parseFloat(temp[i+1]));
					cornersX.add(Float.parseFloat(temp[i+3]));
					cornersX.add(Float.parseFloat(temp[i+5]));
					cornersX.add(Float.parseFloat(temp[i+7]));
					
					// Save the y corners.
					cornersY.add(Float.parseFloat(temp[i+2]));
					cornersY.add(Float.parseFloat(temp[i+4]));
					cornersY.add(Float.parseFloat(temp[i+6]));
					cornersY.add(Float.parseFloat(temp[i+8]));
					
					// Add the book.
					tempBook = new Book(link,cornersX,cornersY);
					foundBooks.add(tempBook);
				}
				
				// If only one book is found, send directly to the website, 
				// otherwise, wait for user input (onTouch).
				if (foundBooks.size() == 1){
					// Load the website associated with the found book.
					Intent browserIntent = new Intent(Intent.ACTION_VIEW,
							Uri.parse(link));
					startActivity(browserIntent); 
				}
				
				// Switch to the result view 
				setContentView(mResultView);
			}
		}

		@Override
		protected Void doInBackground(String... params)
		{

			// Copy the image to build the output on.
			Mat results = new Mat(img.height(), img.width(), CvType.CV_8U,
					new Scalar(4));

			Log.d(TAG, "Start Runnnig C++ Code");
			// Run the sifts - NOTE: BECAUSE C USES POINTERS IT FILLS THE
			// RESULTS MATRIX WITH THE CORRECT VALUES WITHOUT RETURNING IT!
			foundBooksString = NonfreeJNILib.runSift(img.getNativeObjAddr(),
					results.getNativeObjAddr());
			Log.d(TAG, "Done Runnnig C++ Code");


			// Set the result image
			mResultView.resultImage = null;
			try
			{
				mResultView.resultImage = Bitmap.createBitmap(results.cols(),
						results.rows(), Bitmap.Config.ARGB_8888);
				Utils.matToBitmap(results, mResultView.resultImage);
				mResultView.IsShowingResult = true;
			} catch (CvException e)
			{
				Log.e("Exception", e.getMessage());
			}

			// release camera when previous image is processed
			mCameraReadyFlag = true;
			return null;
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	Button runBtn;
	TextView txtView;

}
