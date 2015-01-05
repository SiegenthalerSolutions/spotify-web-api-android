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

import java.util.Locale;

import me.siegenthaler.spotify.webapi.android.model.SimpleAlbum;

/**
 * (non-doc)
 */
public final class ArtistAlbumsRequest extends AbstractPageRequest<ArtistAlbumsRequest, SimpleAlbum> {
    private final static AbstractRequest.PageType PARAMETER_TYPE = new AbstractRequest.PageType(SimpleAlbum.class);

    /**
     * (non-doc)
     */
    public ArtistAlbumsRequest() {
        super(PARAMETER_TYPE, "albums");
    }

    /**
     * (non-doc)
     */
    public ArtistAlbumsRequest setArtist(String id) {
        return setPath(String.format(Locale.ENGLISH, "/v1/artists/%s/albums", id));
    }

    /**
     * (non-doc)
     */
    public ArtistAlbumsRequest setAlbumType(String... type) {
        return addParameter("album_type", TextUtils.join(",", type));
    }

    /**
     * (non-doc)
     */
    public ArtistAlbumsRequest setMarket(String market) {
        return addParameter("market", market);
    }
}
