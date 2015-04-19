package com.example.project18;

public interface GameService {
	void start();
	Piece[][] getPieces();
	boolean hasPieces();
	Piece findPiece(float touchX,float touchY);
	LinkInfo link(Piece p1,Piece p2);
}
