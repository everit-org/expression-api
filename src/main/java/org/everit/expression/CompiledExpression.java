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
 * An expression that is already compiled and ready to use for evaluation.
 */
public interface CompiledExpression {

    /**
     * Evaluating an expression.
     *
     * @param vars
     *            The variables that can be used in the expression.
     * @return The result of the expression.
     */
    Object eval(Map<String, Object> vars);
}
