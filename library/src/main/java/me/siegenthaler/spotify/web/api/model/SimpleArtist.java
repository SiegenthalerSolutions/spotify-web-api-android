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
import java.util.Collections;
import java.util.List;
import java.util.Map;

import me.siegenthaler.spotify.web.api.utilities.JsonParserUtil;

/**
 * <a href="https://developer.spotify.com/web-api/object-model/#artist-object-simplified">Simplified Artist</a>.
 */
public class SimpleArtist {
    private final Map<String, String> mExternalUrls;
    private final String mHref;
    private final String mId;
    private final String mName;
    private final String mType;
    private final String mUri;

    /**
     * (non-doc)
     */
    static public List<SimpleArtist> getAllSimple(JSONArray array) throws JSONException {
        final List<SimpleArtist> artists = new ArrayList<>(array.length());
        for (int i = 0, j = artists.size(); i < j; i++) {
            artists.add(new SimpleArtist(array.getJSONObject(i)));
        }
        return artists;
    }

    /**
     * (non-doc)
     */
    public SimpleArtist(JSONObject data) throws JSONException {
        this.mExternalUrls = JsonParserUtil.getStringMap(data.getJSONObject("external_urls"));
        this.mHref = data.getString("href");
        this.mId = data.getString("id");
        this.mName = data.getString("name");
        this.mType = data.getString("type");
        this.mUri = data.getString("uri");
    }

    /**
     * (non-doc)
     */
    final public Map<String, String> getExternalUrls() {
        return Collections.unmodifiableMap(mExternalUrls);
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
    final public String getId() {
        return mId;
    }

    /**
     * (non-doc)
     */
    final public String getName() {
        return mName;
    }

    /**
     * (non-doc)
     */
    final public String getType() {
        return mType;
    }

    /**
     * (non-doc)
     */
    final public String getUri() {
        return mUri;
    }
}
