package co.trungames.monopoly.game;

import java.awt.image.ImagingOpException;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.kotcrab.vis.ui.util.dialog.Dialogs;
import com.kotcrab.vis.ui.util.dialog.InputDialogAdapter;

import co.trungames.monopoly.game.board.Board;
import co.trungames.monopoly.game.board.square.Square;
import co.trungames.monopoly.game.board.square.properties.Propertie;
import co.trungames.monopoly.game.board.square.properties.Street;

public class SquareUi extends Button{
	private ShapeRenderer renderer = new ShapeRenderer();
	Label label;
	Square square;
	private Texture texture;

	
	public SquareUi(Square square,Skin skin) {
		super(skin);
		this.square=square;
		
		Color color;
		
		createTexture((int)getWidth(), (int)getHeight(),Color.LIME);
		getStyle().up=new TextureRegionDrawable(new TextureRegion(texture));
		
		
		Label label=new Label("ssdsdsdf", skin);
		label.setPosition(0, (getHeight()/2)+label.getHeight());
		addActor(label);
		this.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				dialog(event);
			}
		});
		
	}
	
	//@Override
	public void drawe(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		renderer.setProjectionMatrix(batch.getProjectionMatrix());
		renderer.setTransformMatrix(batch.getTransformMatrix());
		renderer.translate(getX(), getY(), 0);
		batch.end();		
		renderer.begin(ShapeType.Filled);
		if (square instanceof Street) {
			switch (((Street) square).getGroup()) {
			case 1:
				renderer.setColor(Color.RED);
				break;
			case 2:
				renderer.setColor(Color.BLUE);
				break;
			case 3:
				renderer.setColor(Color.GREEN);
				break;
			case 4:
				renderer.setColor(Color.FOREST);
				break;
			case 5:
				renderer.setColor(Color.CYAN);
				break;
			case 6:
				renderer.setColor(Color.PURPLE);
				break;
			case 7:
				renderer.setColor(Color.BROWN);
				break;
			case 8:
				renderer.setColor(Color.MAGENTA);
				break;
			}
			renderer.rect(0, 0, getWidth(), getHeight()/3);			
		}
		renderer.end();
		renderer.begin(ShapeType.Line);
		renderer.setColor(Color.BLACK);
		renderer.rect(0, 0, getWidth(), getHeight());
		renderer.end();
		batch.begin();	
	}
	
	protected void dialog(ChangeEvent event) {
		
		Dialog dialog=new Dialog(square.getName(), getSkin(), "dialog");
		dialog.getTitleLabel().setAlignment(Align.center);
		
		Pixmap labelColor = new Pixmap((int)dialog.getTitleLabel().getWidth(), (int)dialog.getTitleLabel().getHeight(), Pixmap.Format.RGB888);
		labelColor.setColor(Color.BLACK);
	
		labelColor.fill();
		dialog.getTitleLabel().getStyle().background = new Image(new Texture(labelColor)).getDrawable();
		
		if (square instanceof Propertie) {
			dialog.getContentTable().add(new Label("precio:", getSkin())).align(Align.left);;
			dialog.getContentTable().add(new Label(((Propertie) square).getPrice()+"", getSkin())).align(Align.left);;
			dialog.getContentTable().row();
			dialog.getContentTable().add(new Label("Hipoteca:", getSkin())).align(Align.left);;
			dialog.getContentTable().add(new Label(((Propertie) square).getMortgage()+"", getSkin())).align(Align.left);;
			dialog.getContentTable().row();
			dialog.getContentTable().add(new Label("Renta:", getSkin())).align(Align.left);;
			dialog.getContentTable().add(new Label(((Propertie) square).getRent()+"", getSkin())).align(Align.left);;

		}
		
		//dialog.getTitleTable().add(new TextButton("X", getSkin())).height(getPadTop());
		
		dialog.button("ok",true);
		dialog.key(Keys.ESCAPE, false);
		dialog.show(getStage());
		dialog.setHeight(getParent().getParent().getHeight()/4f);
		dialog.setWidth(getParent().getParent().getWidth()/4f);
	}
	 private void createTexture(int width, int height, Color color) {
	        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
	        pixmap.setColor(color);
	        pixmap.fillRectangle(0, 0, width, height);
	        texture = new Texture(pixmap);
	        pixmap.dispose();
	    }

	
	

}
