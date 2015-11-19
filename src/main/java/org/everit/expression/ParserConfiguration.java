/*
 * Copyright (C) 2011 Everit Kft. (http://www.everit.biz)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.everit.expression;

import java.util.Map;

/**
 * Additional configuration for the parser that helps generating compiled expressions or error
 * messages more efficiently.
 */
public class ParserConfiguration {

  /**
   * See {@link #getClassLoader()}.
   */
  private final ClassLoader classLoader;

  /**
   * See {@link #getName()}.
   */
  private String name;

  /**
   * See {@link #getStartColumn()}.
   */
  private int startColumn = 1;
  /**
   * See {@link #getStartRow()}.
   */
  private int startRow = 1;

  /**
   * See {@link #getVariableTypes()}.
   */
  private Map<String, Class<?>> variableTypes = null;

  /**
   * Constructor.
   *
   * @param classLoader
   *          Classloader is a required property for the parser configuration.
   */
  public ParserConfiguration(final ClassLoader classLoader) {
    this.classLoader = classLoader;
  }

  /**
   * Constructor that copies the content of the passed configuration.
   *
   * @param originalConfiguration
   *          The configuration that will be cloned to initialize the attributes of the newly
   *          instantiated configuration.
   */
  public ParserConfiguration(final ParserConfiguration originalConfiguration) {
    if (originalConfiguration == null) {
      throw new NullPointerException("Parser configuration parameter cannot be null");
    } else {
      startRow = originalConfiguration.startRow;
      startColumn = originalConfiguration.startColumn;
      classLoader = originalConfiguration.classLoader;
      name = originalConfiguration.name;
    }
  }

  /**
   * Gets the classloader.
   *
   * @return A classloader that is used to compile the expressions. Passing a classloader can be
   *         important due to the following reasons:
   *         <ul>
   *         <li>Classloader might be used to resolve class types based on their names.</li>
   *         <li>Implementations of this API might generate classes at runtime to enhance the
   *         performance of the compiled expression. The generated classes should be loaded by the
   *         configured classloader. The compiled expression can be garbage collected only if the
   *         classloader is dropped as well, and the classloader can be garbage collected only if
   *         the expression is dropped as well. The two has a very strong relationship and if every
   *         expression is compiled with the system classloader, a memory leak might be created in
   *         case the expression is re-compiled multiple times.</li>
   *         </ul>
   */
  public ClassLoader getClassLoader() {
    return classLoader;
  }

  /**
   * Gets the template name.
   *
   * @return the name of template.
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the column wher the expression starts.
   *
   * @return the column where the expression starts within it's context (e.g.: if the expression is
   *         embedded into a template). The value of this property is normally used to be able to
   *         show more descriptive message in exceptions for the developer. Default value is 1.
   */
  public int getStartColumn() {
    return startColumn;
  }

  /**
   * Gets the row where the expression starts.
   *
   * @return the row where the expression starts within it's context (e.g.: if the expression is
   *         embedded into a template). The value of this property is normally used to be able to
   *         show more descriptive message in exceptions for the developer. Default value is 1.
   *
   */
  public int getStartRow() {
    return startRow;
  }

  /**
   * Gets the variable name and type mapping.
   *
   * @return the variable name and type mapping. Compilers might be able to generate compiled
   *         expressions with higher performance if they know the type of the variables. This
   *         property is optional.
   */
  public Map<String, Class<?>> getVariableTypes() {
    return variableTypes;
  }

  /**
   * See {@link #getStartColumn()}.
   */
  public void setStartColumn(final int lineOffset) {
    startColumn = lineOffset;
  }

  /**
   * See {@link #getStartRow()}.
   */
  public void setStartRow(final int lineNumber) {
    startRow = lineNumber;
  }

  /**
   * See {@link #getVariableTypes()}.
   */
  public void setVariableTypes(final Map<String, Class<?>> variableTypes) {
    this.variableTypes = variableTypes;
  }
}
