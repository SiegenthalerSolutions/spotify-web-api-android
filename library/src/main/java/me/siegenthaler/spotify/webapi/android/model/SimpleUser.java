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
public class SimpleUser {
    @SerializedName("display-name")
    private String mDisplayName;

    @SerializedName("external_urls")
    private Map<String, String> mExternalUrls;

    @SerializedName("followers")
    private Followers mFollowers;

    @SerializedName("href")
    private String mHref;

    @SerializedName("id")
    private String mId;

    @SerializedName("images")
    private List<Image> mImages;

    @SerializedName("type")
    private String mType;

    @SerializedName("uri")
    private String mUri;

    /**
     * (non-doc)
     */
    final public String getDisplayName() {
        return mDisplayName;
    }

    /**
     * (non-doc)
     */
    final public Map<String, String> getExternalUrls() {
        return mExternalUrls;
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
        if (mImages == null) {
            return null;
        } else if (index < 0 || index >= mImages.size()) {
            throw new IllegalArgumentException();
        }
        return mImages.get(index);
    }

    /**
     * (non-doc)
     */
    final public List<Image> getImages() {
        return mImages;
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
