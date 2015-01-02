/*
 * Copyright (C) 2014 Siegenthaler Solutions.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.siegenthaler.spotify.web.api.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://developer.spotify.com/web-api/object-model/#followers-object">Followers</a>.
 */
public class Followers {
    private final String mHref;
    private final int mTotal;

    /**
     * (non-doc)
     */
    static public List<Followers> getAll(JSONArray array) throws JSONException {
        final List<Followers> followers = new ArrayList<>(array.length());
        for (int i = 0, j = array.length(); i < j; i++) {
            followers.add(new Followers(array.getJSONObject(i)));
        }
        return followers;
    }

    /**
     * (non-doc)
     */
    public Followers(JSONObject data) throws JSONException {
        this.mHref = data.getString("href");
        this.mTotal = data.getInt("total");
    }

    /**
     * (non-doc)
     */
    final public String getHref() {
        return mHref;
    }

    /**
     * (non-doc)
     */
    final public int getTotal() {
        return mTotal;
    }
}
