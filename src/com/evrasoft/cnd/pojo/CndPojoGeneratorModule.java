package com.evrasoft.cnd.pojo;

import org.eclipse.xtext.generator.IGenerator;


public class CndPojoGeneratorModule extends com.evrasoft.jcr.CndRuntimeModule {

	 public Class<? extends IGenerator> bindIGenerator() {
	        return CndJpaGenerator.class;
	    }
}
