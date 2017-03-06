package monopoly.game.board;

import java.util.ArrayList;
import java.util.List;

import monopoly.game.board.square.Square;
import monopoly.game.board.square.noProperties.Chance;
import monopoly.game.board.square.noProperties.CommunityChest;
import monopoly.game.board.square.noProperties.FreeParking;
import monopoly.game.board.square.noProperties.Income_tax;
import monopoly.game.board.square.noProperties.Jail;
import monopoly.game.board.square.noProperties.LuxuryTax;
import monopoly.game.board.square.noProperties.ToJail;
import monopoly.game.board.square.properties.PublicService;
import monopoly.game.board.square.properties.Street;
import monopoly.game.board.square.properties.Transport;

public class Board {
	ArrayList<Square> suquares=new ArrayList<>();
	public Board() {
		int i=1;
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
		
	}
	

}
