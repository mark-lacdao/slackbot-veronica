package org.wholesome.veronica.interpreters;

/**
 * Created by mark.lacdao on 31/07/2015.
 */
public interface Interpreter {

    String interpret(String message);
    String interpret(String message, String sender);

}
