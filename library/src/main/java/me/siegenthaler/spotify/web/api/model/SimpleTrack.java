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
 * <a href="https://developer.spotify.com/web-api/object-model/#track-object-simplified">Simplified Track</a>.
 */
public class SimpleTrack {
    private final List<SimpleArtist> mArtists;
    private final List<String> mAvailableMarkets;
    private final int mDiscNumber;
    private final long mDuration;
    private final boolean mExplicit;
    private final Map<String, String> mExternalUrls;
    private final String mHref;
    private final String mId;
    private final String mName;
    private final String mPreviewUrl;
    private final int mTrackNumber;
    private final String mType;
    private final String mUri;

    /**
     * (non-doc)
     */
    static public List<SimpleTrack> getAllSimple(JSONArray array) throws JSONException {
        final List<SimpleTrack> tracks = new ArrayList<>(array.length());
        for (int i = 0, j = tracks.size(); i < j; i++) {
            tracks.add(new SimpleTrack(array.getJSONObject(i)));
        }
        return tracks;
    }

    /**
     * (non-doc)
     */
    public SimpleTrack(JSONObject data) throws JSONException {
        this.mArtists = SimpleArtist.getAllSimple(data.getJSONArray("artists"));
        this.mAvailableMarkets = JsonParserUtil.getStringList(data.getJSONArray("available_markets"));
        this.mDiscNumber = data.getInt("disc_number");
        this.mDuration = data.getLong("duration");
        this.mExplicit = data.getBoolean("explicit");
        this.mExternalUrls = JsonParserUtil.getStringMap(data.getJSONObject("external_urls"));
        this.mHref = data.getString("href");
        this.mId = data.getString("id");
        this.mName = data.getString("name");
        this.mPreviewUrl = data.getString("preview_url");
        this.mTrackNumber = data.getInt("track_number");
        this.mType = data.getString("type");
        this.mUri = data.getString("uri");
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
    final public int getDiscNumber() {
        return mDiscNumber;
    }

    /**
     * (non-doc)
     */
    final public long getDuration() {
        return mDuration;
    }

    /**
     * (non-doc)
     */
    final public boolean isExplicit() {
        return mExplicit;
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
    final public String getPreviewUrl() {
        return mPreviewUrl;
    }

    /**
     * (non-doc)
     */
    final public int getTrackNumber() {
        return mTrackNumber;
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
