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
package me.siegenthaler.spotify.webapi.android.model;

import com.google.gson.annotations.SerializedName;

/**
 * (non-doc)
 */
public class Playlist extends SimplePlaylistBase {
    @SerializedName("description")
    private String mDescription;

    @SerializedName("followers")
    private Followers mFollowers;

    @SerializedName("snapshot_id")
    private String mSnapshotId;

    @SerializedName("tracks")
    private Page<Information> mTracks;

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
        @SerializedName("added_at")
        private String mAddedAt;

        @SerializedName("added_by")
        private SimpleUser mAddedBy;

        @SerializedName("track")
        private Track mTrack;

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
