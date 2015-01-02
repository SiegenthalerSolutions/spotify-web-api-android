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
 * <a href="https://developer.spotify.com/web-api/object-model/#track-object-full">Full Track</a>.
 */
public class Track extends SimpleTrack {
    private final SimpleAlbum mAlbum;
    private final Map<String, String> mExternalIds;
    private final int mPopularity;

    /**
     * (non-doc)
     */
    static public List<Track> getAll(JSONArray array) throws JSONException {
        final List<Track> tracks = new ArrayList<>(array.length());
        for (int i = 0, j = tracks.size(); i < j; i++) {
            tracks.add(new Track(array.getJSONObject(i)));
        }
        return tracks;
    }

    /**
     * (non-doc)
     */
    public Track(JSONObject data) throws JSONException {
        super(data);
        this.mAlbum = new SimpleAlbum(data.getJSONObject("album"));
        this.mExternalIds = JsonParserUtil.getStringMap(data.getJSONArray("external_ids"));
        this.mPopularity = data.getInt("popularity");
    }

    /**
     * (non-doc)
     */
    final public SimpleAlbum getAlbum() {
        return mAlbum;
    }

    /**
     * (non-doc)
     */
    final public Map<String, String> getExternalIds() {
        return Collections.unmodifiableMap(mExternalIds);
    }

    /**
     * (non-doc)
     */
    final public int getPopularity() {
        return mPopularity;
    }
}
