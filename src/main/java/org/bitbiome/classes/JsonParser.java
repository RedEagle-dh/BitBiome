package org.bitbiome.classes;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;


public class JsonParser {

    /*
    Usage of this method:
        Get a whole json file with this method.
        After that you have the JSON File as an object.
        The following methods are available:
            object.getString(String keyName); -> For values.

            object.getJSONArray(String keyName); -> For Arrays
            jsonArray.getJSONObject(int index);

            More: https://www.baeldung.com/java-org-json
                  https://stleary.github.io/JSON-java/index.html
                  https://github.com/stleary/JSON-java
     */

        public static JSONObject readJSONFile(String filePath) {
        StringBuilder sb = null;
        try {
            FileReader reader = new FileReader(filePath);
            char[] buffer = new char[1024];
            int length;
            sb = new StringBuilder();
            while ((length = reader.read(buffer)) != -1) {
                sb.append(buffer, 0, length);
            }

            reader.close();

        } catch (IOException e) {
            System.out.println(e);
        }

        return new JSONObject(sb.toString());
    }

    public static void writeObject(String fileName, JSONObject object) {

        String resourceName = fileName;

        try {
            FileWriter fw = new FileWriter(resourceName, false);
            fw.write(object.toString(1));
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
