package org.everit.expression;


public class CompileException extends AbstractExpressionException {

    public CompileException(final String message, final char[] expr, final int cursor) {
        super(message, expr, cursor);
    }

    public CompileException(final String message, final char[] expr, final int cursor, final Throwable e) {
        super(message, expr, cursor, e);
    }

}
