package co.trungames.monopoly.game.translation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;
import org.luaj.vm2.lib.jse.JsePlatform;

public class Script {
	private static final String FOLDER_SCRIPTS = "scrips";
	private static Globals luaGlobals = JsePlatform.standardGlobals();
	public static void init(String script) throws IOException {
		script = script + ".lua";
		InputStream scriptsFile = null;
		
		try {
			scriptsFile = new FileInputStream(FOLDER_SCRIPTS + File.separator + script);
			luaGlobals.load(scriptsFile, script, "t", luaGlobals).call();
		} catch (FileNotFoundException e) {
			scriptsFile = ClassLoader.getSystemResourceAsStream(FOLDER_SCRIPTS + File.separator + script);
			if(scriptsFile!=null){
				luaGlobals.load(scriptsFile, script, "t", luaGlobals).call();
				scriptsFile.close();
			}
		}finally {
			if(scriptsFile!=null){
				scriptsFile.close();
			}
		}

	}
	public static void getScript(String function,Object ... args){
		LuaValue luaFunction = luaGlobals.get(function);
		LuaValue[] luaArgs = new LuaValue[args.length];
		if(!luaFunction.isnil()){
			for (int i = 0; i < luaArgs.length; i++) {	
				luaArgs[i] = CoerceJavaToLua.coerce(args[i]);
			}
			luaFunction.invoke(LuaValue.varargsOf(luaArgs));
		}
		
		
		
	}

}
