package com.evrasoft.cnd.pojo

import org.eclipse.xtext.generator.IGenerator
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.emf.ecore.EObject
import com.evrasoft.jcr.cnd.Model
import com.evrasoft.jcr.cnd.NodeTypeDefinition
import com.evrasoft.jcr.cnd.PropertyType

/**
 * Simple CND to POJO generator
 */
class CndJpaGenerator implements IGenerator {
	
	override void doGenerate(Resource resource, IFileSystemAccess fsa) {
        for (EObject o : resource.contents) {
            o.compile(fsa)
        }
    }
 
    def dispatch void compile(Model m, IFileSystemAccess fsa) {
        for (e : m.nodeTypes) {
            e.compile(fsa)
        }
    }
 
    def compile(NodeTypeDefinition e, IFileSystemAccess fsa) {
    	
        fsa.generateFile("cnd/pojo/" + e.name.toFirstUpper+".java", '''
        package cnd.pojo;
        
        public class «e.name.toFirstUpper» {
        	«FOR p : e.declaredPropertyDefinitions»
        		private «p.type.javaType» «p.name»;        		
        	«ENDFOR»

        	«FOR p : e.declaredPropertyDefinitions»
        	public «p.type.javaType» get«p.name.toFirstUpper»(){
        	    return this.«p.name»;
        	}        		
        	public void set«p.name.toFirstUpper»(«p.type.javaType» «p.name»){
        	    this.«p.name» = «p.name»;
        	}        		
        	
        	«ENDFOR»        	
        }
        ''')
    }
 
   def dispatch void compile(EObject m, IFileSystemAccess fsa) { }
   
   def getJavaType(PropertyType type) {
		if (type == PropertyType.TSTRING) {
			return "String";
		} else if (type == PropertyType.TDECIMAL) {
			return "Integer";
		} else if (type == PropertyType.TBOOLEAN) {
			return "Boolean";
		} else if (type == PropertyType.TLONG) {
			return "Long";
		} else if (type == PropertyType.TDOUBLE) {
			return "Double";
		} else if (type == PropertyType.TBINARY) {
			return "byte[]";
		}else if (type == PropertyType.TNAME) {
			return "String";
		}else if (type == PropertyType.TREFERENCE) {
			return "String";
		}else if (type == PropertyType.TNAME) {
			return "String";
		}else if (type == PropertyType.TPATH) {
			return "String";
		}else if (type == PropertyType.TWEAKREFERENCE) {
			return "String";
		}else if (type == PropertyType.TURI) {
			return "String";
		}
		   	
   		return type.getName.toLowerCase.toFirstUpper;
   }
}