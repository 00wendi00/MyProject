package com.example.project18;

import java.util.ArrayList;
import java.util.List;

public class VerticalBoard extends AbstractBoard{
	protected List<Piece> createPieces(GameConf config,Piece[][] pieces){
		List<Piece> notNullPieces = new ArrayList<Piece>();
		for(int i = 0 ;i<pieces.length;i++){
			for(int j = 0 ;j <pieces[i].length;j++){
				if(i % 2 ==0){
					Piece piece = new Piece(i, j);
					notNullPieces.add(piece);
				}
			}
		}
		return notNullPieces;
	}
}
