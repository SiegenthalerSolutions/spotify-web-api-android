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
public class Playlist extends SimpleBasePlaylist {
    private final String mDescription;
    private final Followers mFollowers;
    private final String mSnapshotId;
    private final Page<Information> mTracks;

    /**
     * (non-doc)
     */
    static public List<Playlist> getAll(JSONArray array) throws JSONException {
        final List<Playlist> playlist = new ArrayList<>(array.length());
        for (int i = 0, j = array.length(); i < j; i++) {
            playlist.add(new Playlist(array.getJSONObject(i)));
        }
        return playlist;
    }

    /**
     * (non-doc)
     */
    static public Page<Information> getAllInformation(JSONObject array) throws JSONException {
        final JSONArray items = array.getJSONArray("items");

        final List<Information> list = new ArrayList<>(items.length());
        for (int i = 0, j = array.length(); i < j; i++) {
            list.add(new Information(items.getJSONObject(i)));
        }
        return new Page<>(list, array);
    }

    /**
     * (non-doc)
     */
    public Playlist(JSONObject data) throws JSONException {
        super(data);
        this.mDescription = data.getString("description");
        this.mFollowers = new Followers(data.getJSONObject("followers"));
        this.mSnapshotId = data.getString("snapshot_id");
        this.mTracks = getAllInformation(data.getJSONObject("tracks"));
    }

    /**
     * (non-doc)
     */
    final public String getDescription() {
        return mDescription;
    }

    /**
     * (non-doc)
     */
    final public Followers getFollowers() {
        return mFollowers;
    }

    /**
     * (non-doc)
     */
    final public String getSnapshotId() {
        return mSnapshotId;
    }

    /**
     * (non-doc)
     */
    final public Page<Information> getTracks() {
        return mTracks;
    }

    /**
     * (non-doc)
     */
    public static final class Information {
        private String mAddedAt;
        private SimpleUser mAddedBy;
        private Track mTrack;

        /**
         * (non-doc)
         */
        public Information(JSONObject data) throws JSONException {
            this.mAddedAt = data.has("added_at") && data.isNull("added_at")
                    ? data.getString("added_at") : null;
            this.mAddedBy = data.has("added_by") && data.isNull("added_by")
                    ? new SimpleUser(data.getJSONObject("added_by"))  : null;
            this.mTrack = new Track(data.getJSONObject("track"));
        }

        /**
         * (non-doc)
         */
        public String getAddedAt() {
            return mAddedAt;
        }

        /**
         * (non-doc)
         */
        public SimpleUser getAddedBy() {
            return mAddedBy;
        }

        /**
         * (non-doc)
         */
        public Track getTrack() {
            return mTrack;
        }
    }
}
