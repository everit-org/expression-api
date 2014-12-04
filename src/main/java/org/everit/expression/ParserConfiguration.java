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

public class ParserConfiguration {

    private final ClassLoader classLoader;

    private int column = 1;

    private int lineNumber = 1;

    public ParserConfiguration() {
        this.classLoader = null;
    }

    public ParserConfiguration(final ParserConfiguration original) {
        if (original == null) {
            this.classLoader = null;
        } else {
            this.lineNumber = original.lineNumber;
            this.column = original.column;
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
    public int getColumn() {
        return column;
    }

    /**
     * Get total number of lines declared in the current context.
     *
     * @return int of lines
     */
    public int getLineNumber() {
        return lineNumber;
    }

    /**
     * Sets the current line offset. (Generally only used by the compiler)
     *
     * @param lineOffset
     *            The offset amount
     */
    public void setColumn(final int lineOffset) {
        this.column = lineOffset;
    }

    public void setLineNumber(final int lineNumber) {
        this.lineNumber = lineNumber;
    }
}
