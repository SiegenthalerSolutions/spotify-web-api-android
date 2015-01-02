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

import me.siegenthaler.spotify.web.api.utilities.JsonParserUtil;

/**
 * <a href="https://developer.spotify.com/web-api/object-model/#artist-object-full">Full Artist</a>.
 */
public class Artist extends SimpleArtist {
    private final Followers mFollowers;
    private final List<String> mGenres;
    private final List<Image> mImages;
    private final int mPopularity;

    /**
     * (non-doc)
     */
    static public List<Artist> getAll(JSONArray array) throws JSONException {
        List<Artist> artists = new ArrayList<>(array.length());
        for (int i = 0, j = artists.size(); i < j; i++) {
            artists.add(new Artist(array.getJSONObject(i)));
        }
        return artists;
    }

    /**
     * (non-doc)
     */
    public Artist(JSONObject data) throws JSONException {
        super(data);

        this.mFollowers = new Followers(data.getJSONObject("followers"));
        this.mGenres = JsonParserUtil.getStringList(data.getJSONArray("genres"));
        this.mImages = Image.getAll(data.getJSONArray("images"));
        this.mPopularity = data.getInt("popularity");
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
    final public Image getImage(int index) {
        if (index < 0 || index >= mImages.size()) {
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

}
