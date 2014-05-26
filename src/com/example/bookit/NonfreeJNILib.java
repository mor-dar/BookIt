package com.example.bookit;

import org.opencv.core.Mat;


public class NonfreeJNILib  {
	
    static 
    {
    	try
    	{ 
    		// Load necessary libraries.
    		System.loadLibrary("opencv_java");
    		System.loadLibrary("nonfree");
    		System.loadLibrary("nonfree_jni");
    	}
    	catch( UnsatisfiedLinkError e )
		{
           System.err.println("Native code library failed to load.\n" + e);		
		}
    }


	public static native String runSift(long inputAddr, long outputAddr);
	
	public static native boolean BuildDatabase();

	
}