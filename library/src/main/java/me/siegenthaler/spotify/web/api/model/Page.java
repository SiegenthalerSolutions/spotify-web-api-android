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

/**
 * <a href="https://developer.spotify.com/web-api/object-model/#paging-object">Page</a>.
 */
public class Page<T> {
    private final String mHref;
    private final List<T> mItems;
    private final int mLimit;
    private final String mNext;
    private final int mOffset;
    private final String mPrevious;
    private final int mTotal;

    /**
     * (non-doc)
     */
    public Page(List<T> items, JSONObject data) throws JSONException {
        this.mHref = data.getString("href");
        this.mItems = items;
        this.mLimit = data.getInt("limit");
        this.mNext = data.getString("next");
        this.mOffset = data.getInt("offset");
        this.mPrevious = data.getString("previous");
        this.mTotal = data.getInt("total");
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