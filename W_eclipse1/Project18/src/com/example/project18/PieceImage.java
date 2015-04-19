package com.example.project18;

import android.graphics.Bitmap;

public class PieceImage {
	private Bitmap image;
	private int imageId;
	public PieceImage(Bitmap image,int imageId){
		super();
		this.image = image;
		this.imageId = this.imageId;
	}
	public Bitmap getBitmap(){
		return image;
	}
	public void setBitmap(Bitmap image){
		this.image = image;
	}
	
	public int getImageId(){
		return imageId;
	}
	public void setImageId(int imageId){
		this.imageId = imageId;
	}
}
