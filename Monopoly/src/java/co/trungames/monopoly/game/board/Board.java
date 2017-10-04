package co.trungames.monopoly.game.board;

import java.util.ArrayList;
import java.util.Stack;

import co.trungames.monopoly.game.board.cards.Cart;
import co.trungames.monopoly.game.board.square.Square;
import co.trungames.monopoly.game.board.square.noProperties.Chance;
import co.trungames.monopoly.game.board.square.noProperties.CommunityChest;
import co.trungames.monopoly.game.board.square.noProperties.FreeParking;
import co.trungames.monopoly.game.board.square.noProperties.Go;
import co.trungames.monopoly.game.board.square.noProperties.Income_tax;
import co.trungames.monopoly.game.board.square.noProperties.Jail;
import co.trungames.monopoly.game.board.square.noProperties.LuxuryTax;
import co.trungames.monopoly.game.board.square.noProperties.ToJail;
import co.trungames.monopoly.game.board.square.properties.PublicService;
import co.trungames.monopoly.game.board.square.properties.Street;
import co.trungames.monopoly.game.board.square.properties.Transport;
import co.trungames.monopoly.game.translation.Lang;

public class Board {
	private ArrayList<Square> suquares=new ArrayList<>();
	private Stack<Cart> communityChest=new Stack<>();
	private Stack<Cart> chance=new Stack<>();
	private ArrayList<Player> players=new ArrayList<>();
	public Board() {
		int i=1;
		suquares.add(new Go());
		suquares.add(new Street(i++, 1));
		suquares.add(new CommunityChest());
		suquares.add(new Street(i++, 1));
		suquares.add(new Income_tax());
		suquares.add(new Transport(1));
		suquares.add(new Street(i++, 2));
		suquares.add(new Chance());
		suquares.add(new Street(i++, 2));
		suquares.add(new Street(i++, 2));
		suquares.add(new Jail());
		suquares.add(new Street(i++, 3));
		suquares.add(new PublicService(1));
		suquares.add(new Street(i++, 3));
		suquares.add(new Street(i++, 3));
		suquares.add(new Transport(2));
		suquares.add(new Street(i++, 4));
		suquares.add(new CommunityChest());
		suquares.add(new Street(i++, 4));
		suquares.add(new Street(i++, 4));
		suquares.add(new FreeParking());
		suquares.add(new Street(i++, 5));
		suquares.add(new Chance());
		suquares.add(new Street(i++, 5));
		suquares.add(new Street(i++, 5));
		suquares.add(new Transport(3));
		suquares.add(new Street(i++, 6));
		suquares.add(new Street(i++, 6));
		suquares.add(new PublicService(2));
		suquares.add(new Street(i++, 6));
		suquares.add(new ToJail());
		suquares.add(new Street(i++, 7));
		suquares.add(new Street(i++, 7));
		suquares.add(new CommunityChest());
		suquares.add(new Street(i++, 7));
		suquares.add(new Transport(4));
		suquares.add(new Chance());
		suquares.add(new Street(i++, 8));
		suquares.add(new LuxuryTax());
		suquares.add(new Street(i++, 8));
		for (int j = 0; j < 16; j++) {
			communityChest.add(new Cart("communityChest"+(j+1)));
			chance.add(new Cart("chance"+(j+1)));
		}
		chance.get(14).setMessage(Lang.getString("board.carts.chance.to_jail"));
		chance.get(15).setMessage(Lang.getString("board.carts.chance.out_jail"));
		communityChest.get(14).setMessage(Lang.getString("board.carts.community_chest.carts.to_jail"));
		communityChest.get(15).setMessage(Lang.getString("board.carts.community_chest.out_jail"));
	}
	public ArrayList<Square> getSuquares() {
		return suquares;
	}
	public void setSuquares(ArrayList<Square> suquares) {
		this.suquares = suquares;
	}
	public Stack<Cart> getCommunityChets() {
		return communityChest;
	}
	public void setCommunityChets(Stack<Cart> communityChets) {
		this.communityChest = communityChets;
	}
	public Stack<Cart> getChance() {
		return chance;
	}
	public void setChance(Stack<Cart> chance) {
		this.chance = chance;
	}
	
	public ArrayList<Player> getPlayers() {
		return players;
	}
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	public Player getPlayer(int index){
		return players.get(index);
	}

	
	

}
