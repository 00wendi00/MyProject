package com.example.project18;

import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

public class GameView extends View{
	
	private GameService  gameService;
	private Piece selectedPiece;
	private LinkInfo linkInfo;
	private Paint paint;
	private Bitmap selectedImage;
	public GameView(Context context,AttributeSet attrs) {   // 这一步要仔细
		super(context,attrs);
		//这个方法  到位~~~
		this.paint.setShader(new BitmapShader(BitmapFactory.decodeResource(context.getResources(), R.drawable.next),
				Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
		this.paint.setStrokeWidth(9);
		//this.selectedImage = Ima       ??? 
	}
	public void setLinkInfo(LinkInfo linkInfo){
		this.linkInfo = linkInfo;
	}
	public void setGameService(GameService gameService){
		this.gameService  = gameService;
	}
	protected void onDraw(Canvas canvas){
		super.onDraw(canvas);
		if(this.gameService == null){
			return ;
		}
		Piece[][] pieces = gameService.getPieces();
		if(pieces != null){
			for(int i = 0;i<pieces.length;i++){
				for(int j = 0 ;j< pieces[i].length;j++){
					if(pieces[i][j] != null){
						Piece piece = pieces[i][j];
						canvas.drawBitmap(piece.getImage().getBitmap(), piece.getBeginX(), piece.getBeginY(),null);
					}
				}
			}
		}
		if (this.linkInfo != null) {
			drawLine(this.linkInfo,canvas);
			this.linkInfo = null;
		}
		if(this.selectedPiece != null){
			canvas.drawBitmap(this.selectedImage, this.selectedPiece.getBeginX(), this.selectedPiece.getBeginY(),null);
		}
	}
	private void drawLine(LinkInfo linkInfo,Canvas canvas){
		List<Point> points = linkInfo.getLinkPoints();
		for(int i = 0;i<points.size();i++){
			Point currentPoint = points.get(i);
			Point nextPoint = points.get(i+1);
			canvas.drawLine(currentPoint.x, currentPoint.y, nextPoint.x, nextPoint.y, this.paint);   // 这个静态方法  有用！！！
		}
	}
	public void setSelectedPiece(Piece piece){
		this.selectedPiece = piece;
	}
	public void startGame(){
		this.gameService.start();
		this.postInvalidate();
	}
	
	
	
}
