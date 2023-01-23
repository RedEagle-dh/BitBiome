package org.bitbiome.classes;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.JSONWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;



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

    public JSONObject getJSONObject(String fileName) {
        String resourceName = "./../../../" + fileName;
        InputStream is = JsonParser.class.getResourceAsStream(resourceName);
        if (is == null) {
            throw new NullPointerException("Cannot find resource file " + resourceName);
        }

        JSONTokener tokener = new JSONTokener(is);
        return new JSONObject(tokener);
    }

    public void writeObject(String fileName, JSONObject object) {

        String resourceName = System.getProperty("user.dir") + "/src/main/resources/" + fileName;
        try {
            FileWriter fw = new FileWriter(resourceName, false);
            fw.write(object.toString(1));
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
