package FIRe.Exceptions;

import FIRe.Main;

public class CustomEventFieldAccessException extends Exception {
    public CustomEventFieldAccessException(int lineNumber){
        super("ERROR: Cannot access fields of a custom event in line " + lineNumber + ".");
    }
}
