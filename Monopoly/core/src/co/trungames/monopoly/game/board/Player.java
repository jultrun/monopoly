package co.trungames.monopoly.game.board;

import java.util.ArrayList;
import co.trungames.monopoly.game.board.square.properties.Propertie;
import co.trungames.monopoly.game.board.square.properties.Street;
import co.trungames.monopoly.game.translation.Lang;

public class Player {
	private String name;
	private int money;
	private boolean inJail;
	private int pos;
	private ArrayList<Propertie> properties;
	
	public Player(String name, int money) {
		this.name = name;
		this.money = money;
		this.pos=0;
		this.properties=new ArrayList<>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public boolean addMoney(int money) {
		if (money>0) {
			this.money=this.money+money;
			return true;
		}else{
			int newMoney=this.money-money;
			if (newMoney>0) {
				this.money=this.money-money;
				return true;
			}else{
				return false;
			}
		}
	}
	
	public void addGoBound() {
		//addMoney(Lang.getInt("board.square.go.bound"));
	}
	public boolean isInJail() {
		return inJail;
	}
	public void setInJail(boolean inJail) {
		this.inJail = inJail;
	}
	public int getPos() {
		return pos;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}
	public void addPos(int pos) {
		this.pos = this.pos+pos%39;
	}
	
	public ArrayList<Propertie> getProperties() {
		return properties;
	}
	public void setProperties(ArrayList<Propertie> properties) {
		this.properties = properties;
	}
	public void addProperties(Propertie propertie){
		properties.add(propertie);
	}
	public void builHause(Street street){
		
	}
	
	

}
