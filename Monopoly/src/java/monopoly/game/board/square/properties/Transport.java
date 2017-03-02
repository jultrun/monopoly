package monopoly.game.board.square.properties;

import monopoly.game.lang.Lang;

public class Transport extends Propertie {
	private int rent2;
	private int rent3;
	private int rent4;
	public Transport(int keyId) {
		super("transport");
		setName(Lang.getString(Lang.TRANSPORT+keyId+".name"));
		this.rent2 = Lang.getInt(Lang.TRANSPORT+".rent2");
		this.rent3 = Lang.getInt(Lang.TRANSPORT+".rent3");
		this.rent4  = Lang.getInt(Lang.TRANSPORT+".rent4");
	}
	public int getRent2() {
		return rent2;
	}
	public void setRent2(int rent2) {
		this.rent2 = rent2;
	}
	public int getRent3() {
		return rent3;
	}
	public void setRent3(int rent3) {
		this.rent3 = rent3;
	}
	public int getRent4() {
		return rent4;
	}
	public void setRent4(int rent4) {
		this.rent4 = rent4;
	}
    

}
