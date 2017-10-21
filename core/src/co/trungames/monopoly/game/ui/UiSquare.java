package co.trungames.monopoly.game.ui;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;

import co.trungames.monopoly.game.board.square.Square;
import co.trungames.monopoly.game.board.square.properties.Propertie;

public class UiSquare extends Rectangle{
	Label label;
	Square square;
	Rectangle interior;
	Skin skin;	
	public UiSquare(Square square,Skin skin) {
		super(0,0,1,1,Color.YELLOW);
		this.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				dialog(event);;
			}
		});
		
		this.skin=skin;
		this.square=square;
	}
	@Override
	protected void sizeChanged() {
		if (getWidth()-10>0 && getHeight()-10>0) {
			interior= new Rectangle(2,2,getWidth()-4f,getHeight()-4,Color.WHITE);
			addActor(interior);  
		    Label label2 = new Label(square.getName(),Font.labelStyle);
		    label2.setPosition(3, getHeight()/2);
		    addActor(label2);
		}
	}


	

	protected void dialog(InputEvent event) {
		Dialog dialog=new Dialog(square.getName(), skin, "dialog");
		TextButton im= getStage().getRoot().findActor("im3");
		System.out.println(im.getText());
		dialog.getTitleLabel().setAlignment(Align.center);
		
		if (square instanceof Propertie) {
			dialog.getContentTable().add(new Label("precio:", skin)).align(Align.left);;
			dialog.getContentTable().add(new Label(((Propertie) square).getPrice()+"", skin)).align(Align.left);;
			dialog.getContentTable().row();
			dialog.getContentTable().add(new Label("Hipoteca:", skin)).align(Align.left);;
			dialog.getContentTable().add(new Label(((Propertie) square).getMortgage()+"", skin)).align(Align.left);;
			dialog.getContentTable().row();
			dialog.getContentTable().add(new Label("Renta:", skin)).align(Align.left);;
			dialog.getContentTable().add(new Label(((Propertie) square).getRent()+"", skin)).align(Align.left);;

		}
		
		dialog.button("ok",true);
		dialog.key(Keys.ESCAPE, false);
		dialog.show(getStage());
		dialog.setHeight(getParent().getParent().getHeight()/4f);
		dialog.setWidth((int)getParent().getParent().getWidth()/4);
	}
	
	
	

}
