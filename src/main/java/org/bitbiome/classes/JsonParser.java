package org.bitbiome.classes;

import org.json.JSONObject;
import org.json.JSONTokener;

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

    public static JSONObject getJSONObject(String fileName) {
        String resourceName = "./../../" + fileName;
        InputStream is = JsonParser.class.getResourceAsStream(resourceName);
        if (is == null) {
            throw new NullPointerException("Cannot find resource file " + resourceName);
        }

        JSONTokener tokener = new JSONTokener(is);

        return new JSONObject(tokener);
    }
}
