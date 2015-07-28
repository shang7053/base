package demo;

import com.jfinal.config.*;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;

public class DemoConfig extends JFinalConfig {
	public void configConstant(Constants me) {
		me.setDevMode(true);
		me.setViewType(ViewType.JSP);
	}

	public void configRoute(Routes me) {
		me.add("/hello", HelloController.class);
	}

	public void configPlugin(Plugins me) {
		loadPropertyFile("your_app_config.txt");
		C3p0Plugin c3p0Plugin = new C3p0Plugin(getProperty("jdbcUrl"),
		getProperty("user"), getProperty("password"));
		me.add(c3p0Plugin);
		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
		me.add(arp);
		//arp.addMapping("user", User.class);
	}

	public void configInterceptor(Interceptors me) {
	}

	public void configHandler(Handlers me) {
	}
}