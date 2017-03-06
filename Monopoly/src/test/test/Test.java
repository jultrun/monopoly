package test;

import java.io.IOException;

import monopoly.game.board.Board;
import monopoly.game.translation.Lang;
import monopoly.game.translation.Script;

public class Test {

	@org.junit.Test
	public void test() {
		try {
			Lang.init("es_CO");
			Script.init("es_CO");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Board b=new Board();
		b.getChance().get(0).effect(b);
		System.out.println(b.getChance().get(0).getMessage());
		
	}

}
