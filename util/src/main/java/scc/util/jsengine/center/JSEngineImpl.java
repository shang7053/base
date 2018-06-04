package scc.util.jsengine.center;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import scc.util.jsengine.service.IJSEngine;

public class JSEngineImpl implements IJSEngine{
	private static final ScriptEngineManager manager=new ScriptEngineManager();
	private static final ScriptEngine engine=manager.getEngineByName("javascript");
	
	private boolean evalJSByClassPathFile(String jsfileName){
		try {
			engine.eval(new BufferedReader(new InputStreamReader(JSEngineImpl.class.getClassLoader().getResourceAsStream("js.js"))));
			return true;
		} catch (ScriptException e) {
			//e.printStackTrace();
			return false;
		}
	}
	private boolean evalJSByRealPathFile(String jsfileName){
		try {
			engine.eval(new BufferedReader(new FileReader(jsfileName)));
			return true;
		} catch (ScriptException | FileNotFoundException e) {
			//e.printStackTrace();
			return false;
		}
	}
	@Override
	public String getStringReturn(String jsFile, String functionname) {
		evalJSByClassPathFile(jsFile);
		if(engine instanceof Invocable){
			Invocable invocable=(Invocable) engine;
			try {
				return (String) invocable.invokeFunction(functionname);
			} catch (ScriptException | NoSuchMethodException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	@Override
	public String getStringReturnByRealPath(String jsFile, String functionname) {
		evalJSByRealPathFile(jsFile);
		if(engine instanceof Invocable){
			Invocable invocable=(Invocable) engine;
			try {
				return (String) invocable.invokeFunction(functionname);
			} catch (ScriptException | NoSuchMethodException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
}
