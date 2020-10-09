package IniParser;

import Exceptions.PropOrSecNotFoundException;
import Exceptions.TypeMismatchException;

import java.util.ArrayList;
import java.util.HashMap;

public class Data {
    private final HashMap<String, HashMap<String, String>> map;

    public Data(HashMap<String, HashMap<String, String>> _map) {
        map = _map;
    }

    public int getInt (String section, String parameter) throws RuntimeException {

        String string = result(section, parameter);
        try {
            return Integer.parseInt(string);
        } catch (Exception e) {
            throw new TypeMismatchException("Error: cannot parse to int");
        }

    }

    public String getString (String section, String parameter) throws RuntimeException {

            return result(section, parameter);
    }

    public float getFloat(String section, String parameter) throws RuntimeException {

        String string = result(section, parameter);
        try {
            return Float.parseFloat(string);
        } catch (Exception e) {
            throw new TypeMismatchException("Error: cannot parse to float");
        }

    }

    public String result (String section, String parameter) throws RuntimeException {

        try {
            return map.get(section).get(parameter);
        } catch (Exception e) {
            throw new PropOrSecNotFoundException("Error: not such section or property");
        }

    }
}
