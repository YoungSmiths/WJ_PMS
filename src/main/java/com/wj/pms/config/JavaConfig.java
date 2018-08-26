package com.wj.pms.config;

import org.springframework.context.annotation.LoadTimeWeavingConfigurer;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.instrument.classloading.ReflectiveLoadTimeWeaver;

//@Configuration
//@EnableSpringConfigured
public class JavaConfig  implements LoadTimeWeavingConfigurer {

	@Override
	public LoadTimeWeaver getLoadTimeWeaver() {
		return new ReflectiveLoadTimeWeaver();
	}
}
