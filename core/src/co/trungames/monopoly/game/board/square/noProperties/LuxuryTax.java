package co.trungames.monopoly.game.board.square.noProperties;

import co.trungames.monopoly.game.board.square.Square;

public class LuxuryTax extends Square {
	private int tax;
	public LuxuryTax() {
		super("luxury");
		this.setTax(10);
	}
	public int getTax() {
		return tax;
	}
	public void setTax(int tax) {
		this.tax = tax;
	}

}
