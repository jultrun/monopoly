package co.trungames.monopoly.game.board.square;

import co.trungames.monopoly.game.translation.Lang;

public abstract class Square {
	private String name;

	public Square(String key) {
		this.name = Lang.getString(Lang.SQUARE+"."+key+".name");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
