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
 * <a href="https://developer.spotify.com/web-api/object-model/#image-object">Image</a>.
 */
public class Image {
    private final String mLink;
    private final int mWidth;
    private final int mHeight;

    /**
     * (non-doc)
     */
    static public List<Image> getAll(JSONArray array) throws JSONException {
        final List<Image> images = new ArrayList<>(array.length());
        for (int i = 0, j = array.length(); i < j; i++) {
            images.add(new Image(array.getJSONObject(i)));
        }
        return images;
    }

    /**
     * (non-doc)
     */
    public Image(JSONObject data) throws JSONException {
        this.mLink = data.getString("url");
        this.mWidth = data.has("width") && data.isNull("width") ? data.getInt("width") : 0;
        this.mHeight = data.has("height") && data.isNull("height") ? data.getInt("height") : 0;
    }

    /**
     * (non-doc)
     */
    final public String getLink() {
        return mLink;
    }

    /**
     * (non-doc)
     */
    final public int getWidth() {
        return mWidth;
    }

    /**
     * (non-doc)
     */
    final public int getHeight() {
        return mHeight;
    }
} 