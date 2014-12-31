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

/**
 * Expression compiler.
 *
 */
public interface ExpressionCompiler {

    /**
     * Compiles an expression that is embedded in a document. By calling this method, the implementation of the
     * expression compiler might save memory by re-using the passed character array. The
     * {@link ParserConfiguration#getStartRow()} and {@link ParserConfiguration#getStartColumn()} values should point to
     * the place of {@code expressionStart}.
     *
     * @param document
     *            The text that contains the expression.
     * @param expressionStart
     *            The position of the expression within the document. In case the expression starts on the first
     *            character of the document, the value of this parameter should be zero.
     * @param expressionLength
     *            The length of the expression.
     * @param parserConfiguration
     *            The initial configuration of the parser. The implementation of this interface should not change the
     *            configuration instance.
     * @return The compiled expression.
     * @throws NullPointerException
     *             if expression or parserContext is null.
     * @throws IndexOutOfBoundsException
     *             if the expression is outside of the document based on the expressionStart and expressionLength
     *             parameters.
     */
    CompiledExpression compile(char[] document, int expressionStart, int expressionLength,
            ParserConfiguration parserConfiguration);

    /**
     * Compiles an expression.
     *
     * @param expression
     *            The representation of the expression as a text.
     * @param parserConfiguration
     *            The initial configuration of the parser. The implementation of this interface should not change the
     *            configuration instance.
     * @return The compiled expression.
     * @throws NullPointerException
     *             if expression or parserContext is null.
     */
    CompiledExpression compile(String expression, ParserConfiguration parserConfiguration);
}
