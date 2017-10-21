package co.trungames.monopoly.game.board.square.noProperties;

import co.trungames.monopoly.game.board.square.Square;

public class Income_tax extends Square {
	private int tax;
	public Income_tax() {
		super("income");
		this.setTax(10);
	}
	public int getTax() {
		return tax;
	}
	public void setTax(int tax) {
		this.tax = tax;
	}

}
