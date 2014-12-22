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

public class ParserConfiguration {

    private final ClassLoader classLoader;

    private int startColumn = 1;

    private int startRow = 1;

    private Map<String, Class<?>> variableTypes = null;

    public ParserConfiguration(final ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    public ParserConfiguration(final ParserConfiguration original) {
        if (original == null) {
            throw new NullPointerException("Parser configuration parameter cannot be null");
        } else {
            this.startRow = original.startRow;
            this.startColumn = original.startColumn;
            this.classLoader = original.classLoader;
        }
    }

    public ClassLoader getClassLoader() {
        return classLoader;
    }

    /**
     * Get the current line offset. This measures the number of cursor positions back to the beginning of the line.
     *
     * @return int offset
     */
    public int getStartColumn() {
        return startColumn;
    }

    /**
     * Get total number of lines declared in the current context.
     *
     * @return int of lines
     */
    public int getStartRow() {
        return startRow;
    }

    public Map<String, Class<?>> getVariableTypes() {
        return variableTypes;
    }

    /**
     * Sets the current line offset. (Generally only used by the compiler)
     *
     * @param lineOffset
     *            The offset amount
     */
    public void setStartColumn(final int lineOffset) {
        this.startColumn = lineOffset;
    }

    public void setStartRow(final int lineNumber) {
        this.startRow = lineNumber;
    }

    public void setVariableTypes(final Map<String, Class<?>> variableTypes) {
        this.variableTypes = variableTypes;
    }
}
