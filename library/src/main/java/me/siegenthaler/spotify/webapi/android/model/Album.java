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

import java.util.List;
import java.util.Map;

/**
 * (non-doc)
 */
public class Album extends SimpleAlbum {
    @SerializedName("artists")
    private List<SimpleArtist> mArtists;

    @SerializedName("copyrights")
    private List<Copyright> mCopyrights;

    @SerializedName("external_ids")
    private Map<String, String> mExternalIds;

    @SerializedName("genres")
    private List<String> mGenres;

    @SerializedName("popularity")
    private int mPopularity;

    @SerializedName("release_date")
    private String mReleaseDate;

    @SerializedName("release_date_precision")
    private String mReleasePrecision;

    @SerializedName("tracks")
    private Page<SimpleTrack> mTracks;

    /**
     * (non-doc)
     */
    final public SimpleArtist getArtist(int index) {
        if (index < 0 || index >= mArtists.size()) {
            throw new IllegalArgumentException();
        }
        return mArtists.get(index);
    }

    /**
     * (non-doc)
     */
    final public List<SimpleArtist> getArtists() {
        return mArtists;
    }

    /**
     * (non-doc)
     */
    final public Copyright getCopyright(int index) {
        if (index < 0 || index >= mArtists.size()) {
            throw new IllegalArgumentException();
        }
        return mCopyrights.get(index);
    }

    /**
     * (non-doc)
     */
    final public List<Copyright> getCopyrights() {
        return mCopyrights;
    }

    /**
     * (non-doc)
     */
    final public Map<String, String> getExternalIds() {
        return mExternalIds;
    }

    /**
     * (non-doc)
     */
    final public String getGenre(int index) {
        if (index < 0 || index >= mGenres.size()) {
            throw new IllegalArgumentException();
        }
        return mGenres.get(index);
    }

    /**
     * (non-doc)
     */
    final public List<String> getGenres() {
        return mGenres;
    }

    /**
     * (non-doc)
     */
    final public int getPopularity() {
        return mPopularity;
    }

    /**
     * (non-doc)
     */
    final public String getReleaseData() {
        return mReleaseDate;
    }

    /**
     * (non-doc)
     */
    final public String getReleaseDatePrecision() {
        return mReleasePrecision;
    }

    /**
     * (non-doc)
     */
    final public Page<SimpleTrack> getTracks() {
        return mTracks;
    }

    /**
     * (non-doc)
     */
    public final static class Copyright {
        @SerializedName("text")
        private String mText;

        @SerializedName("type")
        private String mType;

        /**
         * (non-doc)
         */
        public String getText() {
            return mText;
        }

        /**
         * (non-doc)
         */
        public String getType() {
            return mType;
        }
    }
}
