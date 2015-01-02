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

import java.util.List;
import java.util.Map;

import me.siegenthaler.spotify.web.api.utilities.JsonParserUtil;

/**
 * <a href="https://developer.spotify.com/web-api/object-model/#playlist-object-simplified">Simplified Playlist</a>.
 */
public class SimpleBasePlaylist {
    private final boolean mCollaborative;
    private final Map<String, String> mExternalUrls;
    private final String mHref;
    private final String mId;
    private final List<Image> mImages;
    private final String mName;
    private final SimpleUser mOwner;
    private final boolean mPublic;
    private final String mType;
    private final String mUri;

    /**
     * (non-doc)
     */
    public SimpleBasePlaylist(JSONObject data) throws JSONException {
        this.mCollaborative = data.getBoolean("collaborative");
        this.mExternalUrls = JsonParserUtil.getStringMap(data.getJSONObject("external_urls"));
        this.mHref = data.getString("href");
        this.mId = data.getString("id");
        this.mImages = data.has("images") && !data.isNull("images") ? Image.getAll(data.getJSONArray("images")) : null;
        this.mName = data.getString("name");
        this.mOwner = new SimpleUser(data.getJSONObject("owner"));
        this.mPublic = data.getBoolean("public");
        this.mType = data.getString("type");
        this.mUri = data.getString("uri");
    }

    /**
     * (non-doc)
     */
    final public boolean isCollaborative() {
        return mCollaborative;
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
    final public String getName() {
        return mName;
    }

    /**
     * (non-doc)
     */
    final public SimpleUser getOwner() {
        return mOwner;
    }

    /**
     * (non-doc)
     */
    final public boolean isPublic() {
        return mPublic;
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
