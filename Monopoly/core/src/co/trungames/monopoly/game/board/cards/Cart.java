package co.trungames.monopoly.game.board.cards;

import co.trungames.monopoly.game.board.Board;
import co.trungames.monopoly.game.translation.Script;

public class Cart {
	private String message;
	private String id;
	public Cart(String id) {
		this.id=id;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void effect(Board board){
		Script.getScript(id,board,this);
	}

}
