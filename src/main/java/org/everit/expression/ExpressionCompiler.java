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
     * Compiles an expression within the given parser context.
     *
     * @param expression
     *            The representation of the expression as a text.
     * @param parserConfiguration
     *            The current context that the expression is parsed in. This is useful if the expression is presented in
     *            a template and template specific information should be shown in the dropped exceptions (e.g.: line
     *            number and column). The compiler implementation might not support parserContext, therefore before
     *            using this function the original context should be cloned.
     * @return The compiled expression.
     * @throws NullPointerException
     *             if expression or parserContext is null.
     */
    CompiledExpression compile(String expression, ParserConfiguration parserConfiguration);
}
