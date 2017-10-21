package co.trungames.monopoly.game;

import java.io.IOException;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ButtonGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.kotcrab.vis.ui.VisUI;
import com.kotcrab.vis.ui.widget.VisTable;

import co.trungames.monopoly.game.board.Board;
import co.trungames.monopoly.game.translation.Lang;
import co.trungames.monopoly.game.translation.Script;
import co.trungames.monopoly.game.ui.Font;
import co.trungames.monopoly.game.ui.UiSquare;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.Value;

public class Menu extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	int width;
	int height;
	private Skin skin;
	Stage stage; 
	Board board;
	@Override
	public void create () {
		try {
			Lang.init("es_CO");
			Script.init("es_CO");
		} catch (IOException e) {
			e.printStackTrace();
		}
		board = new Board();
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);// Make the stage consume events
	       
		batch = new SpriteBatch();
		width = Gdx.graphics.getWidth();
		height = Gdx.graphics.getHeight();
		
		 VisUI.load(); 
	      skin=VisUI.getSkin(); 
	     Font.Generatefont();
	      VisTable screenTable = new VisTable(); 
	      screenTable .setFillParent(true); 
	      stage.addActor(screenTable);
	      screenTable.debug();
	      TextButton im=new TextButton("ss2",skin);
	      
	      im.setName("im3");
	      screenTable.add(im).expand().growX().top().height(height*0.26f); 
	      //TextButton nameLabel = new TextButton("Namswswdswswse:", skin); 
	      //List list = new List(skin); 
	    //list.setItems(1,2,3,4,5,6,7,11,221,212,121,121212,12121,2121,12121,121212,121221,2121,2121,2121,212,1212,121,1221); 
	    //list.getSelection().setMultiple(true); 
	    //list.getSelection().setRequired(false); 
	    // list.getSelection().setToggle(true); 
	    //ScrollPane scrollPane2 = new ScrollPane(list, skin); 
	    //scrollPane2.setFlickScroll(false); 
	    //Label minSizeLabel = new Label("minWidth cell", skin); // demos SplitPane respecting widget's minWidth 
	    //Table rightSideTable = new Table(skin); 
	    //rightSideTable.add(minSizeLabel).growX().row(); 
	    //rightSideTable.add(scrollPane2).grow(); 
	     
	      //screenTable.add(rightSideTable); 
	      VisTable boardTable = new VisTable(); 
	       
	      screenTable.add(boardTable).width(width*0.84f); 
	       
	      float widthm=(int)(width*0.84f)/11; 
	      float heightm=height/11;
	    
	      for (int i = 21; i <= 31; i++) { 
	        boardTable.add(new UiSquare(board.getSuquares().get(i-1), skin)).width(widthm).height(heightm); 
	    } 
	      boardTable.row(); 
	      
	      for (int i = 20,j=32; i >= 12; i--,j++) { 
	        boardTable.add(new UiSquare(board.getSuquares().get(i-1), skin)).width(widthm).height(heightm); 
	        boardTable.add().colspan(9);   
	        boardTable.add(new UiSquare(board.getSuquares().get(j-1), skin)).width(widthm).height(heightm); 
	        boardTable.row(); 
	    } 
	      for (int i = 11; i >= 1; i--) { 
	        boardTable.add(new UiSquare(board.getSuquares().get(i-1), skin)).width(widthm).height(heightm); 
	    } 
	       
	     
	}

	@Override
	public void render () {
        //Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.draw();
    }
	
	@Override
	public void dispose () {
		batch.dispose();
		skin.dispose();
		stage.dispose();
	}
	
}
