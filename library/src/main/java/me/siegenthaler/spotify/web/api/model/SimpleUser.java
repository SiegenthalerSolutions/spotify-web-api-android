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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import me.siegenthaler.spotify.web.api.utilities.JsonParserUtil;

/**
 * <a href="https://developer.spotify.com/web-api/object-model/#user-object-public">Public User</a>.
 */
public class SimpleUser {
    private final String mDisplayName;
    private final Map<String, String> mExternalUrls;
    private final Followers mFollowers;
    private final String mHref;
    private final String mId;
    private final List<Image> mImages;
    private final String mType;
    private final String mUri;

    /**
     * (non-doc)
     */
    public SimpleUser(JSONObject data) throws JSONException {
        this.mDisplayName = data.getString("display_name");
        this.mExternalUrls = JsonParserUtil.getStringMap(data.getJSONArray("external_urls"));
        this.mFollowers = new Followers(data.getJSONObject("followers"));
        this.mHref = data.getString("href");
        this.mId = data.getString("id");
        this.mImages = data.has("images") && !data.isNull("images") ? Image.getAll(data.getJSONArray("images")) : null;
        this.mType = data.getString("type");
        this.mUri = data.getString("uri");
    }

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
        return Collections.unmodifiableMap(mExternalUrls);
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
        return Collections.unmodifiableList(mImages);
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
