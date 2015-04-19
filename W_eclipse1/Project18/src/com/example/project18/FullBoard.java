package com.example.project18;

import java.util.ArrayList;
import java.util.List;

public class FullBoard extends AbstractBoard{
	protected List<Piece> createPieces(GameConf conf,Piece[][] pieces){
		List<Piece> notNullPieces = new ArrayList<Piece>();
		for(int i = 0; i<pieces.length-1;i++){
			for(int j = 1 ;j<pieces[i].length-1;j++){
				Piece piece = new Piece(i, j);
				notNullPieces.add(piece);
			}
		}
		return notNullPieces;
	}
}
