package co.trungames.monopoly.game.board.square.properties;

import co.trungames.monopoly.game.translation.Lang;

public class PublicService extends Propertie {

	public PublicService(int keyId) {
		super("public_service");
		setName(Lang.getString(Lang.PUBLIC_SERVICE+keyId+".name"));
	}
	public int getRent1(int n) {
		return 4*n*getRent();
	}
	public int getRent2(int n) {
		return 10*n*getRent();
	}

}
