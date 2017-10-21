package co.trungames.monopoly.game.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class Font {
	public static LabelStyle labelStyle;
	public static void Generatefont() {
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("font/Amble-Light.ttf"));
	    FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
	    parameter.size = 7;
	    parameter.color = Color.BLACK;
	    BitmapFont font24 = generator.generateFont(parameter); // font size 24 pixels
	    generator.dispose();
	    labelStyle = new LabelStyle();
	    labelStyle.font = font24;
	    
	}
    
}