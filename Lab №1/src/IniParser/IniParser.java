package IniParser;

import Exceptions.FileFormatErrorException;
import Exceptions.PropOrSecNotFoundException;
import Exceptions.WrongFileExtensionException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class IniParser {
    String sectionPattern = "\\[[a-zA-Z0-9_]*]\\s*";
    String propertyPattern = "[a-zA-Z0-9_]* ?[=] ?[a-zA-Z0-9./]*\\s*";

    private int hasComments(String str) {
        return str.indexOf(";");
    }

    private String removeComments(String str) {

        if (hasComments(str) != -1)
            return str.replace(str.substring(hasComments(str)), "");
        return str;

    }

    private HashMap<String, ArrayList<String>> reading(File file) throws RuntimeException, FileNotFoundException {

        HashMap<String, ArrayList<String>> _map = new HashMap<>();
        if (file.getName().matches("[a-zA-Z0-9_]* \\.ini"))
            throw new WrongFileExtensionException("File extension is not INI");
        Scanner scanner = new Scanner(file);
        String str;
        String currentKey = "";
        while (scanner.hasNext()) {
            str = scanner.nextLine();
            String secwthcom = (removeComments(str)).trim();
            if (secwthcom.isBlank())
                continue;
            else {
                if (secwthcom.matches(sectionPattern)) {
                    currentKey = secwthcom.substring(1, secwthcom.length() - 1);
                    _map.put(currentKey, new ArrayList<>());
                } else if (secwthcom.matches(propertyPattern)) {
                    String[] words = secwthcom.split("=");
                    String string = words[0].trim();
                    _map.get(currentKey).add(string);
                    String string2 = words[1].trim();
                    _map.get(currentKey).add(string2);
                } else
                    throw new FileFormatErrorException("Wrong format of ini file");
            }
        }
        return _map;

    }

    public Data Parse(File file) throws RuntimeException, FileNotFoundException {

        return new Data(reading(file));

    }
}
