package com.evrasoft.cnd.pojo;

import com.evrasoft.jcr.cnd.Model;
import com.evrasoft.jcr.cnd.NodeTypeDefinition;
import com.evrasoft.jcr.cnd.PropertyDefinition;
import com.evrasoft.jcr.cnd.PropertyType;
import com.google.common.base.Objects;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * Simple CND to POJO generator
 */
@SuppressWarnings("all")
public class CndJpaGenerator implements IGenerator {
  public void doGenerate(final Resource resource, final IFileSystemAccess fsa) {
    EList<EObject> _contents = resource.getContents();
    for (final EObject o : _contents) {
      this.compile(o, fsa);
    }
  }
  
  protected void _compile(final Model m, final IFileSystemAccess fsa) {
    EList<NodeTypeDefinition> _nodeTypes = m.getNodeTypes();
    for (final NodeTypeDefinition e : _nodeTypes) {
      this.compile(e, fsa);
    }
  }
  
  public void compile(final NodeTypeDefinition e, final IFileSystemAccess fsa) {
    String _name = e.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    String _plus = ("cnd/pojo/" + _firstUpper);
    String _plus_1 = (_plus + ".java");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package cnd.pojo;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _name_1 = e.getName();
    String _firstUpper_1 = StringExtensions.toFirstUpper(_name_1);
    _builder.append(_firstUpper_1, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    {
      EList<PropertyDefinition> _declaredPropertyDefinitions = e.getDeclaredPropertyDefinitions();
      for(final PropertyDefinition p : _declaredPropertyDefinitions) {
        _builder.append("\t");
        _builder.append("private ");
        PropertyType _type = p.getType();
        String _javaType = this.getJavaType(_type);
        _builder.append(_javaType, "	");
        _builder.append(" ");
        String _name_2 = p.getName();
        _builder.append(_name_2, "	");
        _builder.append(";        \t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    {
      EList<PropertyDefinition> _declaredPropertyDefinitions_1 = e.getDeclaredPropertyDefinitions();
      for(final PropertyDefinition p_1 : _declaredPropertyDefinitions_1) {
        _builder.append("\t");
        _builder.append("public ");
        PropertyType _type_1 = p_1.getType();
        String _javaType_1 = this.getJavaType(_type_1);
        _builder.append(_javaType_1, "	");
        _builder.append(" get");
        String _name_3 = p_1.getName();
        String _firstUpper_2 = StringExtensions.toFirstUpper(_name_3);
        _builder.append(_firstUpper_2, "	");
        _builder.append("(){");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("    ");
        _builder.append("return this.");
        String _name_4 = p_1.getName();
        _builder.append(_name_4, "	    ");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}        \t\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public void set");
        String _name_5 = p_1.getName();
        String _firstUpper_3 = StringExtensions.toFirstUpper(_name_5);
        _builder.append(_firstUpper_3, "	");
        _builder.append("(");
        PropertyType _type_2 = p_1.getType();
        String _javaType_2 = this.getJavaType(_type_2);
        _builder.append(_javaType_2, "	");
        _builder.append(" ");
        String _name_6 = p_1.getName();
        _builder.append(_name_6, "	");
        _builder.append("){");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("    ");
        _builder.append("this.");
        String _name_7 = p_1.getName();
        _builder.append(_name_7, "	    ");
        _builder.append(" = ");
        String _name_8 = p_1.getName();
        _builder.append(_name_8, "	    ");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}        \t\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.append("}");
    _builder.newLine();
    fsa.generateFile(_plus_1, _builder);
  }
  
  protected void _compile(final EObject m, final IFileSystemAccess fsa) {
  }
  
  public String getJavaType(final PropertyType type) {
    boolean _equals = Objects.equal(type, PropertyType.TSTRING);
    if (_equals) {
      return "String";
    } else {
      boolean _equals_1 = Objects.equal(type, PropertyType.TDECIMAL);
      if (_equals_1) {
        return "Integer";
      } else {
        boolean _equals_2 = Objects.equal(type, PropertyType.TBOOLEAN);
        if (_equals_2) {
          return "Boolean";
        } else {
          boolean _equals_3 = Objects.equal(type, PropertyType.TLONG);
          if (_equals_3) {
            return "Long";
          } else {
            boolean _equals_4 = Objects.equal(type, PropertyType.TDOUBLE);
            if (_equals_4) {
              return "Double";
            } else {
              boolean _equals_5 = Objects.equal(type, PropertyType.TBINARY);
              if (_equals_5) {
                return "byte[]";
              } else {
                boolean _equals_6 = Objects.equal(type, PropertyType.TNAME);
                if (_equals_6) {
                  return "String";
                } else {
                  boolean _equals_7 = Objects.equal(type, PropertyType.TREFERENCE);
                  if (_equals_7) {
                    return "String";
                  } else {
                    boolean _equals_8 = Objects.equal(type, PropertyType.TNAME);
                    if (_equals_8) {
                      return "String";
                    } else {
                      boolean _equals_9 = Objects.equal(type, PropertyType.TPATH);
                      if (_equals_9) {
                        return "String";
                      } else {
                        boolean _equals_10 = Objects.equal(type, PropertyType.TWEAKREFERENCE);
                        if (_equals_10) {
                          return "String";
                        } else {
                          boolean _equals_11 = Objects.equal(type, PropertyType.TURI);
                          if (_equals_11) {
                            return "String";
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    String _name = type.getName();
    String _lowerCase = _name.toLowerCase();
    return StringExtensions.toFirstUpper(_lowerCase);
  }
  
  public void compile(final EObject m, final IFileSystemAccess fsa) {
    if (m instanceof Model) {
      _compile((Model)m, fsa);
      return;
    } else if (m != null) {
      _compile(m, fsa);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(m, fsa).toString());
    }
  }
}
