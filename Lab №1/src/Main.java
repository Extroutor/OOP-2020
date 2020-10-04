import IniParser.IniParser;

public class Main {
    public static void main(String[] args) throws RuntimeException {

        var ini = new IniParser();
        var data = ini.Parse("input.ini");

        data.getValue("Install4F96D1932A9F858E", "Default", "String");
        data.getValue("General", "StartWithLastProfile", "Integer");
    }
}
