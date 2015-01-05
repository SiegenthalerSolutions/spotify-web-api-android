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

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * (non-doc)
 */
public class SimpleTrack {
    @SerializedName("artists")
    private List<SimpleArtist> mArtists;

    @SerializedName("available_markets")
    private List<String> mAvailableMarkets;

    @SerializedName("disc_number")
    private int mDiscNumber;

    @SerializedName("duration")
    private long mDuration;

    @SerializedName("explicit")
    private boolean mExplicit;

    @SerializedName("external_urls")
    private Map<String, String> mExternalUrls;

    @SerializedName("href")
    private String mHref;

    @SerializedName("id")
    private String mId;

    @SerializedName("name")
    private String mName;

    @SerializedName("preview_url")
    private String mPreviewUrl;

    @SerializedName("track_number")
    private int mTrackNumber;

    @SerializedName("type")
    private String mType;

    @SerializedName("uri")
    private String mUri;

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
