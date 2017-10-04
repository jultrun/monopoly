package co.trungames.monopoly.game;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.JOptionPane;

import co.trungames.monopoly.game.board.Board;
import co.trungames.monopoly.game.board.Player;
import co.trungames.monopoly.game.board.cards.Cart;
import co.trungames.monopoly.game.board.square.Square;
import co.trungames.monopoly.game.board.square.noProperties.Chance;
import co.trungames.monopoly.game.board.square.noProperties.CommunityChest;
import co.trungames.monopoly.game.board.square.noProperties.FreeParking;
import co.trungames.monopoly.game.board.square.noProperties.Income_tax;
import co.trungames.monopoly.game.board.square.noProperties.Jail;
import co.trungames.monopoly.game.board.square.noProperties.LuxuryTax;
import co.trungames.monopoly.game.board.square.noProperties.ToJail;
import co.trungames.monopoly.game.board.square.properties.Propertie;
import co.trungames.monopoly.game.board.square.properties.PublicService;
import co.trungames.monopoly.game.board.square.properties.Street;
import co.trungames.monopoly.game.board.square.properties.Transport;
import co.trungames.monopoly.game.translation.Lang;
import co.trungames.monopoly.game.translation.Script;

public class Monopoly {
	private Board board;
	private int turno = 0;

	public void init() {
		try {
			Lang.init("es_CO");
			Script.init("es_CO");
		} catch (IOException e) {
			e.printStackTrace();
		}
		board = new Board();
		Scanner sc = new Scanner(System.in);
		System.out.println("introdusca el numero de jugadores entre 2 y 8");
		int numPlayers = 0;
		do {
			try {
				numPlayers = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("debe ser un numero entero entre 2 y 8");
			}
			if (numPlayers < 2 || numPlayers > 8) {
				System.out.println("debe ser entre 1 y 8");
			}
		} while (numPlayers < 2 || numPlayers > 8);
		for (int i = 0; i < numPlayers; i++) {
			System.out.println("introdusca el nombre del jugador " + (i + 1));
			String name = sc.nextLine();
			board.getPlayers().add(new Player(name, Lang.getInt("board.square.go.bound")));
		}
		
		boolean win = false;
		while (!win) {
			if (getActualPlayer().isInJail()) {

			}
			System.out.println("introdusca/n" + "1 para tirar los dados\n" + "2 para consulatar el dinero disponi\n"
					+ "3\n" + "4\n" + "5\n");
			int opc = 0;
			do {
				try {
					opc = Integer.parseInt(sc.nextLine());
				} catch (Exception e) {
					System.out.println("debe ser entre 1 y 5");
				}
				if (opc < 1 || opc > 5) {
					System.out.println("debe ser entre 1 y 5");
				}
			} while (opc < 1 || opc > 5);
			switch (opc) {
			case 2:
				System.out.println("tienes "+getActualPlayer().getMoney()+" pesos");
				break;
			case 3:

				break;
			case 4:

				break;

			case 1:
				int dice1=0;
				int dice2=0;
				dice1= new Random().nextInt(5)+1;
				dice2= new Random().nextInt(5)+1;
				int oldPos=getActualPlayer().getPos();
				getActualPlayer().addPos(dice1+dice2);
				if(oldPos>getActualPlayer().getPos()){
					getActualPlayer().addGoBound();
				}
				Square squareActual=board.getSuquares().get(getActualPlayer().getPos());
				if(squareActual instanceof Propertie){
					if (((Propertie) squareActual).getPlayer()==null) {
						System.out.println("estas en "+squareActual.getName()+" con costo de "+((Propertie) squareActual).getPrice());
						System.out.println("deseas comprarla 1 si.2 no ");
						do {
							try {
								opc = Integer.parseInt(sc.nextLine());
							} catch (Exception e) {
								System.out.println("debe ser entre 1 y 2");
							}
							if (opc < 1 || opc > 2) {
								System.out.println("debe ser entre 1 y 2");
							}
						} while (opc < 1 || opc > 2);
						if(opc==1){
							((Propertie) squareActual).setPlayer(getActualPlayer());
							getActualPlayer().addMoney(((Propertie) squareActual).getPrice());
						}
						
					}
					
					if (squareActual instanceof PublicService){	
					}else if (squareActual instanceof Transport){
						
					}else if (squareActual instanceof Street){
						
					}
				}else{
					if(squareActual instanceof Chance){
						Cart cart =board.getChance().pop();
						if (cart.getMessage().equals(Lang.getString("board.carts.chance.out_jail"))) {
							
						}else{
							cart.effect(board);
						}
						
					}else if (squareActual instanceof CommunityChest) {
						Cart cart =board.getCommunityChets().pop();
						if (cart.getMessage().equals(Lang.getString("board.carts.community_chest.out_jail"))) {
							
						}else{
							cart.effect(board);
						}
					}else if (squareActual instanceof Income_tax) {
						getActualPlayer().addMoney(-10);						
					}else if (squareActual instanceof LuxuryTax) {
						getActualPlayer().addMoney(-10);	
					}else if (squareActual instanceof ToJail) {
						getActualPlayer().setInJail(true);
						getActualPlayer().setPos(10);
					}
				}
				
				break;
			}
			

		}

	}

	public static void main(String[] args) {
		Stack<String> a=new Stack<String>();
		
		a.push("a");
		a.push("b");
		a.push("c");
		a.push("d");
		a.push("e");
		System.out.println(a.pop());
		System.out.println(a.pop());
		a.add(0,"s");
		System.out.println(a.pop());
		//Monopoly monopoly = new Monopoly();
		//int n = JOptionPane.showConfirmDialog(
			//    null,
			  //  "deseas comprar la propiedad?",
			    //"An Inane Question",
			    //JOptionPane.YES_NO_OPTION);
		//System.out.println(n);
		//monopoly.init();

	}
	public Player getActualPlayer(){
		return board.getPlayer(turno);
	}

}
