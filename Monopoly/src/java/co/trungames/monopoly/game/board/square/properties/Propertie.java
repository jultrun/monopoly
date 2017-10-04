package co.trungames.monopoly.game.board.square.properties;

import co.trungames.monopoly.game.board.Player;
import co.trungames.monopoly.game.board.square.Square;
import co.trungames.monopoly.game.translation.Lang;

public abstract class Propertie extends Square{
	private int price;
	private boolean purchased=false;
    private int mortgage;
    private boolean mortgaged=false;
    private int rent;
    private Player player;
    
  

	public Propertie(String key) {
		super(key);
		this.price = Lang.getInt(Lang.SQUARE+"."+key+".price");
		this.mortgage = Lang.getInt(Lang.SQUARE+"."+key+".mortgage");
		this.rent = Lang.getInt(Lang.SQUARE+"."+key+".rent");
		this.player = null;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getMortgage() {
		return mortgage;
	}
	public void setMortgage(int mortgage) {
		this.mortgage = mortgage;
	}
	public boolean isMortgaged() {
		return mortgaged;
	}
	public void setMortgaged(boolean mortgaged) {
		this.mortgaged = mortgaged;
	}
	public int getRent() {
		return rent;
	}
	public void setRent(int rent) {
		this.rent = rent;
	}
	public boolean isPurchased() {
		return purchased;
	}
	public void setPurchased(boolean purchased) {
		this.purchased = purchased;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
}
