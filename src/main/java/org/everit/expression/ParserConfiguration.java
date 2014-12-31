/**
 * This file is part of Everit - Expression API.
 *
 * Everit - Expression API is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Everit - Expression API is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Everit - Expression API.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.everit.expression;

import java.util.Map;

/**
 * Additional configuration for the parser that helps generating compiled expressions or error messages more
 * efficiently.
 */
public class ParserConfiguration {

    /**
     * See {@link #getClassLoader()}.
     */
    private final ClassLoader classLoader;

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
     *            Classloader is a required property for the parser configuration.
     */
    public ParserConfiguration(final ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    /**
     * Constructor that copies the content of the passed configuration.
     *
     * @param originalConfiguration
     *            The configuration that will be cloned to initialize the attributes of the newly instantiated
     *            configuration.
     */
    public ParserConfiguration(final ParserConfiguration originalConfiguration) {
        if (originalConfiguration == null) {
            throw new NullPointerException("Parser configuration parameter cannot be null");
        } else {
            this.startRow = originalConfiguration.startRow;
            this.startColumn = originalConfiguration.startColumn;
            this.classLoader = originalConfiguration.classLoader;
        }
    }

    /**
     *
     * @return A classloader that is used to compile the expressions. Passing a classloader can be important due to the
     *         following reasons:
     *         <ul>
     *         <li>Classloader might be used to resolve class types based on their names.</li>
     *         <li>Implementations of this API might generate classes at runtime to enhance the performance of the
     *         compiled expression. The generated classes should be loaded by the configured classloader. The compiled
     *         expression can be garbage collected only if the classloader is dropped as well, and the classloader can
     *         be garbage collected only if the expression is dropped as well. The two has a very strong relationship
     *         and if every expression is compiled with the system classloader, a memory leak might be created in case
     *         the expression is re-compiled multiple times.</li>
     *         </ul>
     */
    public ClassLoader getClassLoader() {
        return classLoader;
    }

    /**
     *
     * @return the column where the expression starts within it's context (e.g.: if the expression is embedded into a
     *         template). The value of this property is normally used to be able to show more descriptive message in
     *         exceptions for the developer. Default value is 1.
     */
    public int getStartColumn() {
        return startColumn;
    }

    /**
     * @return the row where the expression starts within it's context (e.g.: if the expression is embedded into a
     *         template). The value of this property is normally used to be able to show more descriptive message in
     *         exceptions for the developer. Default value is 1.
     *
     */
    public int getStartRow() {
        return startRow;
    }

    /**
     * @return the variable name and type mapping. Compilers might be able to generate compiled expressions with higher
     *         performance if they know the type of the variables. This property is optional.
     */
    public Map<String, Class<?>> getVariableTypes() {
        return variableTypes;
    }

    /**
     * See {@link #getStartColumn()}.
     */
    public void setStartColumn(final int lineOffset) {
        this.startColumn = lineOffset;
    }

    /**
     * See {@link #getStartRow()}.
     */
    public void setStartRow(final int lineNumber) {
        this.startRow = lineNumber;
    }

    /**
     * See {@link #getVariableTypes()}.
     */
    public void setVariableTypes(final Map<String, Class<?>> variableTypes) {
        this.variableTypes = variableTypes;
    }
}
