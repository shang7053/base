package testjs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Test {
	
	public static void main(String[] args){
		long start=System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			ScriptEngineManager manager=new ScriptEngineManager();
			ScriptEngine engine=manager.getEngineByName("javascript");
			BufferedReader fr=new BufferedReader(new InputStreamReader(Test.class.getClassLoader().getResourceAsStream("js.js")));
			try {
				engine.eval(fr);
				if(engine instanceof Invocable){
					Invocable invocable=(Invocable) engine;
					System.out.println(invocable.invokeFunction("testjs"));
				}
			} catch (ScriptException | NoSuchMethodException e) {
				e.printStackTrace();
			}
		}
		long end=System.currentTimeMillis();
		System.out.println("执行耗时:"+(end-start)+"平均耗时"+((end-start)/100));	
	}
}
