package co.trungames.monopoly.game;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import co.trungames.monopoly.game.board.Board;
import co.trungames.monopoly.game.translation.Lang;
import co.trungames.monopoly.game.translation.Script;

public class Test {

	
	public static void main(String[] args) throws FileNotFoundException {
		try {
			Lang.init("es_CO");
			Script.init("es_CO");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Board b=new Board();
		
		b.getChance().get(0).effect(b);
		
		
	}

}
