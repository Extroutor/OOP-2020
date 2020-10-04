import IniParser.IniParser;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws RuntimeException, FileNotFoundException {

        var ini = new IniParser();
        var data = ini.Parse(new File("input.ini"));

        System.out.println(data.getString("Install4F96D1932A9F858E", "Default"));
        System.out.println(data.getInt("General", "StartWithLastProfile"));
        System.out.println(data.getFloat("Profile1", "Default"));

    }
}
