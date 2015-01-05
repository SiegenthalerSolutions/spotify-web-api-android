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
package me.siegenthaler.spotify.webapi.android.request;

import android.text.TextUtils;

import com.android.volley.Request;

import java.util.List;

import me.siegenthaler.spotify.webapi.android.model.Album;

/**
 * (non-doc)
 */
public final class AlbumListRequest extends AbstractRequest.Builder<AlbumListRequest, List<Album>> {
    private final static AbstractRequest.ListType PARAMETER_TYPE = new AbstractRequest.ListType(Album.class);

    /**
     * (non-doc)
     */
    public AlbumListRequest() {
        super(PARAMETER_TYPE, Request.Method.GET, "albums");
    }

    /**
     * (non-doc)
     */
    public AlbumListRequest setAlbums(String... id) {
        setPath("/v1/albums");
        return addParameter("ids", TextUtils.join(",", id));
    }
}
