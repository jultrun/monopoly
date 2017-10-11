package co.trungames.monopoly.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class Menu extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	int width;
	int height;
	private Skin skin;
	Stage stage; 
	@Override
	public void create () {
		batch = new SpriteBatch();
		width = Gdx.graphics.getWidth();
		height = Gdx.graphics.getHeight();
		img = new Texture("badlogic.jpg");
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);// Make the stage consume events

        createBasicSkin();
        TextButton newGameButton = new TextButton("New game", skin); // Use the initialized skin
        newGameButton.setPosition(Gdx.graphics.getWidth()/2 - Gdx.graphics.getWidth()/8 , Gdx.graphics.getHeight()/2);
        stage.addActor(newGameButton);
        TextButton newGameButton2 = new TextButton("New game", skin);
        newGameButton2.setPosition(Gdx.graphics.getWidth()/2 - Gdx.graphics.getWidth()/8 , Gdx.graphics.getHeight()/4);
        stage.addActor(newGameButton2);
	}

	@Override
	public void render () {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.draw();
    }
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
	private void createBasicSkin(){
	  skin = new Skin();
	  //Create a font
	  BitmapFont font = new BitmapFont();
	 
	  skin.add("default", font);
	 
	  //Create a texture
	  Pixmap pixmap = new Pixmap((int)Gdx.graphics.getWidth()/4,(int)Gdx.graphics.getHeight()/10, Pixmap.Format.RGB888);
	  pixmap.setColor(Color.WHITE);
	  pixmap.fill();
	  skin.add("background",new Texture(pixmap));
	 
	  //Create a button style
	  TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
	  textButtonStyle.up = skin.newDrawable("background", Color.GRAY);
	  textButtonStyle.down = skin.newDrawable("background", Color.DARK_GRAY);
	  textButtonStyle.checked = skin.newDrawable("background", Color.DARK_GRAY);
	  textButtonStyle.over = skin.newDrawable("background", Color.LIGHT_GRAY);
	  textButtonStyle.font = skin.getFont("default");
	  skin.add("default", textButtonStyle);
	 
	}
}
