package com.evrasoft.cnd.pojo;

import org.eclipse.xtext.ISetup;

import com.google.inject.Guice;
import com.google.inject.Injector;
 
public class CndPojoGeneratorSetup implements ISetup {
 
    @Override
    public Injector createInjectorAndDoEMFRegistration() {
        return Guice.createInjector(new CndPojoGeneratorModule());
    }
 
}