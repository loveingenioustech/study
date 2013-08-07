package fluid;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * Session Bean implementation class Calculator
 */
@Stateless
public class Calculator {

	private static final String ENGINE_NAME = "JavaScript";
	/*
	 * On Mac OS X AppleScriptEngineinstead of JavaScript is available private
	 * static final String ENGINE_NAME = "AppleScriptEngine";
	 */
	private ScriptEngine scriptEngine = null;

	/**
	 * Default constructor.
	 */
	public Calculator() {
	}

	private final static double FIVE = 5;

	@PostConstruct
	public void initScripting() {
		ScriptEngineManager engineManager = new ScriptEngineManager();
		this.scriptEngine = engineManager.getEngineByName(ENGINE_NAME);
		if (this.scriptEngine == null) {
			throw new IllegalStateException("Cannot create… " + ENGINE_NAME);
		}
	}

	public Object calculate(String formula) {
		Object retVal = null;
		try {
			Bindings binding = this.scriptEngine.createBindings();
			binding.put("FIVE", FIVE);
			this.scriptEngine.setBindings(binding, ScriptContext.GLOBAL_SCOPE);
			retVal = this.scriptEngine.eval(formula);
		} catch (Exception e) {
			throw new IllegalStateException("Cannot create…: " + e, e);
		}
		return retVal;
	}

}
