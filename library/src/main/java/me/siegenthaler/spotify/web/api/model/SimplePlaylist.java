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
 * <a href="https://developer.spotify.com/web-api/object-model/#playlist-object-simplified">Simplified Playlist</a>.
 */
public class SimplePlaylist extends SimpleBasePlaylist {
    private final Information mTracks;

    /**
     * (non-doc)
     */
    static public List<SimplePlaylist> getAllSimple(JSONArray array) throws JSONException {
        final List<SimplePlaylist> playlist = new ArrayList<>(array.length());
        for (int i = 0, j = playlist.size(); i < j; i++) {
            playlist.add(new SimplePlaylist(array.getJSONObject(i)));
        }
        return playlist;
    }

    /**
     * (non-doc)
     */
    public SimplePlaylist(JSONObject data) throws JSONException {
        super(data);
        this.mTracks = new Information(data.getJSONObject("tracks"));
    }

    /**
     * (non-doc)
     */
    final public Information getTracks() {
        return mTracks;
    }

    /**
     * (non-doc)
     */
    public static final class Information {
        private String mHref;
        private int mTotal;

        /**
         * (non-doc)
         */
        public Information(JSONObject data) throws JSONException {
            this.mHref = data.getString("href");
            this.mTotal = data.getInt("total");
        }

        /**
         * (non-doc)
         */
        public String getHref() {
            return mHref;
        }

        /**
         * (non-doc)
         */
        public int getTotal() {
            return mTotal;
        }
    }
}
