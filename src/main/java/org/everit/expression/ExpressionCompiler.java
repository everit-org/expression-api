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

/**
 * Expression compiler.
 *
 */
public interface ExpressionCompiler {

  /**
   * Compiles an expression that is embedded in a document. By calling this method, the
   * implementation of the expression compiler might save memory by re-using the passed character
   * array. The {@link ParserConfiguration#getStartRow()} and
   * {@link ParserConfiguration#getStartColumn()} values should point to the place of
   * {@code expressionStart}.
   *
   * @param document
   *          The text that contains the expression.
   * @param expressionStart
   *          The position of the expression within the document. In case the expression starts on
   *          the first character of the document, the value of this parameter should be zero.
   * @param expressionLength
   *          The length of the expression.
   * @param parserConfiguration
   *          The initial configuration of the parser. The implementation of this interface should
   *          not change the configuration instance.
   * @return The compiled expression.
   * @throws NullPointerException
   *           if expression or parserContext is null.
   * @throws IndexOutOfBoundsException
   *           if the expression is outside of the document based on the expressionStart and
   *           expressionLength parameters.
   */
  CompiledExpression compile(char[] document, int expressionStart, int expressionLength,
      ParserConfiguration parserConfiguration);

  /**
   * Compiles an expression.
   *
   * @param expression
   *          The representation of the expression as a text.
   * @param parserConfiguration
   *          The initial configuration of the parser. The implementation of this interface should
   *          not change the configuration instance.
   * @return The compiled expression.
   * @throws NullPointerException
   *           if expression or parserContext is null.
   */
  CompiledExpression compile(String expression, ParserConfiguration parserConfiguration);
}
