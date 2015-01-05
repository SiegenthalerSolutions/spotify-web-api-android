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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * (non-doc)
 */
public class Page<T> {
    @SerializedName("href")
    private String mHref;

    @SerializedName("items")
    private List<T> mItems;

    @SerializedName("limit")
    private int mLimit;

    @SerializedName("next")
    private String mNext;

    @SerializedName("offset")
    private int mOffset;

    @SerializedName("previous")
    private String mPrevious;

    @SerializedName("total")
    private int mTotal;

    /**
     * (non-doc)
     */
    final public String getHref() {
        return mHref;
    }

    /**
     * (non-doc)
     */
    final public List<T> getItems() {
        return mItems;
    }

    /**
     * (non-doc)
     */
    final public int getLimit() {
        return mLimit;
    }

    /**
     * (non-doc)
     */
    final public String getNext() {
        return mNext;
    }

    /**
     * (non-doc)
     */
    final public int getOffset() {
        return mOffset;
    }

    /**
     * (non-doc)
     */
    final public String getPrevious() {
        return mPrevious;
    }

    /**
     * (non-doc)
     */
    final public int getTotal() {
        return mTotal;
    }
}