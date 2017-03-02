package monopoly.game.board.square.properties;

import monopoly.game.lang.Lang;

public class Street extends Propertie{
	private int rentWith1House;
    private int rentWith2House;
    private int rentWith3House;
    private int rentWith4House;
    private int rentWithHotel;
    private int priceBulding;
    private int group;

	public Street(int keyId,int group) {
		super("street"+keyId);
		this.rentWith1House = Lang.getInt(Lang.STREET+keyId+".rent_with_1house");
		this.rentWith2House = Lang.getInt(Lang.STREET+keyId+".rent_with_2house");
		this.rentWith3House = Lang.getInt(Lang.STREET+keyId+".rent_with_3house");
		this.rentWith4House = Lang.getInt(Lang.STREET+keyId+".rent_with_4house");
		this.rentWithHotel  = Lang.getInt(Lang.STREET+keyId+".rent_with_1hotel");
		this.priceBulding   = Lang.getInt(Lang.STREET+keyId+".price_bulding");
		this.group=group;
	}

	public int getRentWith1House() {
		return rentWith1House;
	}

	public void setRentWith1House(int rentWith1House) {
		this.rentWith1House = rentWith1House;
	}

	public int getRentWith2House() {
		return rentWith2House;
	}

	public void setRentWith2House(int rentWith2House) {
		this.rentWith2House = rentWith2House;
	}

	public int getRentWith3House() {
		return rentWith3House;
	}

	public void setRentWith3House(int rentWith3House) {
		this.rentWith3House = rentWith3House;
	}

	public int getRentWith4House() {
		return rentWith4House;
	}

	public void setRentWith4House(int rentWith4House) {
		this.rentWith4House = rentWith4House;
	}

	public int getRentWithHotel() {
		return rentWithHotel;
	}

	public void setRentWithHotel(int rentWithHotel) {
		this.rentWithHotel = rentWithHotel;
	}
	

	public int getPriceBulding() {
		return priceBulding;
	}

	public void setPriceBulding(int priceBulding) {
		this.priceBulding = priceBulding;
	}
	

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return "Street [rentWith1House=" + rentWith1House + ", rentWith2House=" + rentWith2House + ", rentWith3House="
				+ rentWith3House + ", rentWith4House=" + rentWith4House + ", rentWithHotel=" + rentWithHotel
				+ ", priceBulding=" + priceBulding + ", getPrice()=" + getPrice() + ", getMortgage()=" + getMortgage()
				+ ", isMortgaged()=" + isMortgaged() + ", getRent()=" + getRent() + ", isPurchased()=" + isPurchased()
				+ ", getName()=" + getName() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	
	

}

		