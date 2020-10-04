package IniParser;

import Exceptions.TypeMismatchException;


public class Getters {
    public int getInt (String string) throws RuntimeException {
        try {
            return Integer.parseInt(string);
        } catch (Exception e) {
            throw new TypeMismatchException("Error: cannot parse to int");
        }
    }

    public float getFloat(String string) throws RuntimeException {
        try {
            return Float.parseFloat(string);
        } catch (Exception e) {
            throw new TypeMismatchException("Error: cannot parse to float");
        }
    }
}
