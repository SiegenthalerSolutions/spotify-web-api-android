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

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import me.siegenthaler.spotify.web.api.utilities.JsonParserUtil;

/**
 * <a href="https://developer.spotify.com/web-api/object-model/#album-object-full">Full Album</a>.
 */
public class Album extends SimpleAlbum {
    private final List<SimpleArtist> mArtists;
    private final List<NameValuePair> mCopyrights;
    private final Map<String, String> mExternalIds;
    private final List<String> mGenres;
    private final int mPopularity;
    private final String mReleaseDate;
    private final String mReleasePrecision;
    private final Page<SimpleTrack> mTracks;

    /**
     * (non-doc)
     */
    static public List<Album> getAll(JSONArray array) throws JSONException {
        final List<Album> albums = new ArrayList<>(array.length());
        for (int i = 0, j = albums.size(); i < j; i++) {
            albums.add(new Album(array.getJSONObject(i)));
        }
        return albums;
    }

    /**
     * (non-doc)
     */
    public Album(JSONObject data) throws JSONException {
        super(data);
        this.mArtists = SimpleArtist.getAllSimple(data.getJSONArray("artists"));
        this.mCopyrights = JsonParserUtil.getNameValueList(data.getJSONArray("copyrights"));
        this.mExternalIds = JsonParserUtil.getStringMap(data.getJSONArray("external_ids"));
        this.mGenres = JsonParserUtil.getStringList(data.getJSONArray("genres"));
        this.mPopularity = data.getInt("popularity");
        this.mReleaseDate = data.getString("release_date");
        this.mReleasePrecision = data.getString("release_date_precision");
        this.mTracks = null; // TODO
    }

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
        return Collections.unmodifiableList(mArtists);
    }

    /**
     * (non-doc)
     */
    final public NameValuePair getCopyright(int index) {
        if (index < 0 || index >= mArtists.size()) {
            throw new IllegalArgumentException();
        }
        return mCopyrights.get(index);
    }

    /**
     * (non-doc)
     */
    final public List<NameValuePair> getCopyrights() {
        return Collections.unmodifiableList(mCopyrights);
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
        return Collections.unmodifiableList(mGenres);
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
    final public String getReleaseDatePrecision() { return mReleasePrecision; }

    /**
     * (non-doc)
     */
    final public Page<SimpleTrack> getTracks() {
        return mTracks;
    }
}
