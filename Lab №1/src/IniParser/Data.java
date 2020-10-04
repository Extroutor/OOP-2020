package IniParser;

import Exceptions.PropOrSecNotFoundException;

import java.util.HashMap;
import java.util.Vector;

public class Data {
    private HashMap<String, Vector<String>> map;
    Getters get = new Getters();
    String _type;

    public Data(HashMap _map) {
        map = _map;
    }


    public String p(String section, String parameter) throws RuntimeException {
        try {
            int n = map.get(section).indexOf(parameter);
            return map.get(section).get(n + 1);
        } catch (Exception e) {
            throw new PropOrSecNotFoundException("Error: not such section or property");
        }
    }

    public void pArsing(String section, String parameter) throws RuntimeException {
        String value = p(section, parameter);
        if (_type.equals("Integer"))
            System.out.println(get.getInt(value));
        else if (_type.equals("Float"))
            System.out.println(get.getFloat(value));
        else
            System.out.println(value);
    }

    public void getValue(String section, String parameter, String type) throws RuntimeException {
        _type = type;
        pArsing(section, parameter);
    }
}
