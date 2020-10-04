package IniParser;

import Exceptions.PropOrSecNotFoundException;
import Exceptions.NotFoundOrInvalidFileException;
import Exceptions.WrongFileExtensionException;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class IniParser {
    Scanner file;
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

    private HashMap<String, Vector<String>> reading(String _path) throws RuntimeException {
        HashMap<String, Vector<String>> _map = new HashMap<>();
        File sc = new File(_path);
        if (_path.matches("[a-zA-Z0-9_]* \\.ini"))
            throw new WrongFileExtensionException("File extension is not INI");
        {
            try {
                file = new Scanner(sc);
            } catch (Exception e) {
                throw new NotFoundOrInvalidFileException("Error: not such file or invalid file");
            }
        }
        String str;
        String currentKey = "";
        while (file.hasNext()) {
            str = file.nextLine();
            String secwthcom = (removeComments(str)).trim();
            if (secwthcom.isBlank())
                continue;
            else {
                if (secwthcom.matches(sectionPattern)) {
                    currentKey = secwthcom.substring(1, secwthcom.length() - 1);
                    _map.put(currentKey, new Vector<>());
                } else if (secwthcom.matches(propertyPattern)) {
                    String[] words = secwthcom.split("=");
                    String string = words[0].trim();
                    _map.get(currentKey).add(string);
                    String string2 = words[1].trim();
                    _map.get(currentKey).add(string2);
                } else
                    throw new PropOrSecNotFoundException("Wrong format of ini file");
            }
        }
        return _map;
    }

    public Data Parse(String path) throws RuntimeException {

        return new Data(reading(path));

    }
}
