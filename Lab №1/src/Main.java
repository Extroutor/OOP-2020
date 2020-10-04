import IniParser.IniParser;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws RuntimeException, FileNotFoundException {

        var ini = new IniParser();
        var data = ini.Parse(new File("input.ini"));

        System.out.println(data.getString("COMMON", "DiskCachePath"));
        System.out.println(data.getInt("LEGACY_XML", "ListenTcpPort"));
        System.out.println(data.getFloat("ADC_DEV", "BufferLenSecons"));
        
    }
}
