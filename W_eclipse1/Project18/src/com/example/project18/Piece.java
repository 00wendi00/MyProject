package com.example.project18;

import android.graphics.Point;

public class Piece {      //  ������� ~�� ����װ   image,beginX,beginY,indexX,indexY~~
	private PieceImage image;
	private int beginX,beginY,indexX,indexY;
	public Piece(int indexX,int  indexY){
		this.indexX = indexX;
		this.indexY = indexY;
	}
	
	public PieceImage getImage(){
		return image;
	}
	public void setImage(PieceImage image){
		this.image = image;
	}
	
	public int getBeginX(){
		return beginX;
	}
	public void setBeginX(int beginX){
		this.beginX = beginX;
	}
	
	public int getBeginY(){
		return beginY;
	}
	public void setBeginY(int beginY){
		this.beginY = beginY;
	}
	
	public int getIndexX(){
		return indexX;
	}
	public void setIndexX(int indexX){
		this.indexX = indexX;
	}
	
	public int getIndexY(){
		return indexY;
	}
	public void setIndexY(int indexY){
		this.indexY = indexY;
	}
	
	public Point getCenter()
	{
		return new Point(getImage().getBitmap().getWidth() / 2
			+ getBeginX(), getBeginY()
			+ getImage().getBitmap().getHeight() / 2);
	}
	// �ж�����Piece�ϵ�ͼƬ�Ƿ���ͬ
	public boolean isSameImage(Piece other)
	{
		if (image == null)
		{
			if (other.image != null)
				return false;
		}
		// ֻҪPiece��װͼƬID��ͬ��������Ϊ����Piece��ȡ�
		return image.getImageId() == other.image.getImageId();
	}
}
