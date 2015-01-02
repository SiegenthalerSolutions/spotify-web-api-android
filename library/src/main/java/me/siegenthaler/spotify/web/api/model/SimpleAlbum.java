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
 * <a href="https://developer.spotify.com/web-api/object-model/#album-object-simplified">Simplified Album</a>.
 */
public class SimpleAlbum {
    private final String mAlbumType;
    private final List<String> mAvailableMarkets;
    private final Map<String, String> mExternalUrls;
    private final String mHref;
    private final String mId;
    private final List<Image> mImages;
    private final String mName;
    private final String mType;
    private final String mUri;

    /**
     * (non-doc)
     */
    static public List<SimpleAlbum> getAllSimple(JSONArray array) throws JSONException {
        final List<SimpleAlbum> albums = new ArrayList<>(array.length());
        for (int i = 0, j = albums.size(); i < j; i++) {
            albums.add(new SimpleAlbum(array.getJSONObject(i)));
        }
        return albums;
    }

    /**
     * (non-doc)
     */
    public SimpleAlbum(JSONObject data) throws JSONException {
        this.mAlbumType = data.getString("album_type");
        this.mAvailableMarkets = JsonParserUtil.getStringList(data.getJSONArray("available_markets"));
        this.mExternalUrls = JsonParserUtil.getStringMap(data.getJSONObject("external_urls"));
        this.mHref = data.getString("href");
        this.mId = data.getString("id");
        this.mImages = Image.getAll(data.getJSONArray("images"));
        this.mName = data.getString("name");
        this.mType = data.getString("type");
        this.mUri = data.getString("uri");
    }

    /**
     * (non-doc)
     */
    final public String getAlbumType() {
        return mAlbumType;
    }

    /**
     * (non-doc)
     */
    final public boolean isAvailable(String market) {
        return mAvailableMarkets.contains(market);
    }

    /**
     * (non-doc)
     */
    final public List<String> getAvailableMarkets() {
        return Collections.unmodifiableList(mAvailableMarkets);
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
    final public Image getImage(int index) {
        if (index < 0 || index >= mImages.size()) {
            throw new IllegalArgumentException();
        }
        return mImages.get(index);
    }

    /**
     * (non-doc)
     */
    final public List<Image> getImages() {
        return Collections.unmodifiableList(mImages);
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
