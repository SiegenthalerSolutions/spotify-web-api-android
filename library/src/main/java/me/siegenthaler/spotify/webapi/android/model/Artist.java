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

/**
 * (non-doc)
 */
public class Artist extends SimpleArtist {
    @SerializedName("followers")
    private Followers mFollowers;

    @SerializedName("genres")
    private List<String> mGenres;

    @SerializedName("images")
    private List<Image> mImages;

    @SerializedName("popularity")
    private int mPopularity;

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
        return mImages;
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

}
