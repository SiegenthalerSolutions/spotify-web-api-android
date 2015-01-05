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

import me.siegenthaler.spotify.webapi.android.model.Artist;

/**
 * (non-doc)
 */
public final class ArtistListRequest extends AbstractRequest.Builder<ArtistListRequest, List<Artist>> {
    private final static AbstractRequest.ListType PARAMETER_TYPE = new AbstractRequest.ListType(Artist.class);

    /**
     * (non-doc)
     */
    public ArtistListRequest() {
        super(PARAMETER_TYPE, Request.Method.GET, "artists");
    }

    /**
     * (non-doc)
     */
    public ArtistListRequest setArtists(String... id) {
        setPath("/v1/artists");
        return addParameter("ids", TextUtils.join(",", id));
    }
}
