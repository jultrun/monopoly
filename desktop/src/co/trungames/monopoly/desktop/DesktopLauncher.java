package co.trungames.monopoly.desktop;

import com.badlogic.gdx.Graphics.DisplayMode;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import co.trungames.monopoly.game.Menu;
import co.trungames.monopoly.game.Monopoly2;
import co.trungames.monopoly.game.UITest;

public class DesktopLauncher {
	public static void main (String[] arg) {
		DisplayMode displayMode = LwjglApplicationConfiguration.getDesktopDisplayMode();
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.setFromDisplayMode(displayMode);
		config.fullscreen=false;
		config.y=0;
		config.height=(int) (config.height*0.9);
		config.width=(int) (config.width*0.9);
		config.resizable=false;
		new LwjglApplication(new Menu(), config);
	}
}
