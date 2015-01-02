/**
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
package me.siegenthaler.spotify.web.api.utilities;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * (non-doc)
 */
public final class JsonParserUtil {
    /**
     * (non-doc)
     */
    static public List<NameValuePair> getCopyrightsList(JSONArray array) throws JSONException {
        final List<NameValuePair> list = new ArrayList<>(array.length());
        for (int i = 0, j = list.size(); i < j; i++) {
            final JSONObject object = array.getJSONObject(i);
            list.add(new BasicNameValuePair(object.getString("text"), object.getString("type")));
        }
        return list;
    }

    /**
     * (non-doc)
     */
    static public List<String> getStringList(JSONArray array) throws JSONException {
        final List<String> list = new ArrayList<>(array.length());
        for (int i = 0, j = list.size(); i < j; i++) {
            list.add(array.getString(i));
        }
        return list;
    }

    /**
     * (non-doc)
     */
    static public Map<String, String> getStringMap(JSONObject object) throws JSONException {
        final Iterator<String> keysItr = object.keys();
        final Map<String, String> map = new HashMap<>(object.length());

        while (keysItr.hasNext()) {
            final String key = keysItr.next();
            map.put(key, object.getString(key));
        }
        return map;
    }
}
