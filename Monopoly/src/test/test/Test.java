package test;

import java.io.IOException;

import monopoly.game.board.square.properties.Transport;
import monopoly.game.lang.Lang;

public class Test {

	@org.junit.Test
	public void test() {
		
		try {
			Lang.init("es_CO");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Transport u=new Transport(1);
		System.out.println(u.getName());
		System.out.println(u.getPrice());
		System.out.println(u.getMortgage());
		System.out.println(u.getRent());

		for (int i = 1; i <= -22; i++) {
			System.out.println("board.square.street"+i+".name=");
			System.out.println("board.square.street"+i+".price=");
			System.out.println("board.square.street"+i+".mortgage=");
			System.out.println("board.square.street"+i+".rent=");
			System.out.println("board.square.street"+i+".rent_with_1house=");
			System.out.println("board.square.street"+i+".rent_with_2house=");
			System.out.println("board.square.street"+i+".rent_with_3house=");
			System.out.println("board.square.street"+i+".rent_with_4house=");
			System.out.println("board.square.street"+i+".rent_with_hotel=");
			System.out.println("board.square.street"+i+".price_bulding=");
			System.out.println();
		}
	}

}
