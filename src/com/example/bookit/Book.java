package com.example.bookit;

import java.util.ArrayList;

public class Book {

	private String link;
	private ArrayList<Float> cornersX;
	private ArrayList<Float> cornersY;
	
	public Book (String link,ArrayList<Float> cornersX,ArrayList<Float> cornersY){
		this.link = link;
		this.cornersX = cornersX;
		this.cornersY = cornersY;
	}
	
	public String getLink(){
		return this.link;
	}
	
	public ArrayList<Float> getXcorners(){
		return this.cornersX;
	}
	
	public ArrayList<Float> getYcorners(){
		return this.cornersY;
	}
}
