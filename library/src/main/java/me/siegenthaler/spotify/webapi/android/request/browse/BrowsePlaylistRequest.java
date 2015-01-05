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
package me.siegenthaler.spotify.webapi.android.request.browse;

import me.siegenthaler.spotify.webapi.android.model.SimplePlaylist;
import me.siegenthaler.spotify.webapi.android.request.AbstractPageRequest;
import me.siegenthaler.spotify.webapi.android.request.AbstractRequest;

/**
 * (non-doc)
 */
public final class BrowsePlaylistRequest extends AbstractPageRequest<BrowsePlaylistRequest, SimplePlaylist> {
    private final static AbstractRequest.PageType PARAMETER_TYPE = new AbstractRequest.PageType(SimplePlaylist.class);

    /**
     * (non-doc)
     */
    public BrowsePlaylistRequest() {
        super(PARAMETER_TYPE, "playlists");
        setPath("/v1/browse/featured-playlists");
    }

    /**
     * (non-doc)
     */
    public BrowsePlaylistRequest setCountry(String country) {
        return addParameter("country", country);
    }

    /**
     * (non-doc)
     */
    public BrowsePlaylistRequest setLocale(String locale) {
        return addParameter("locale", locale);
    }

    /**
     * (non-doc)
     */
    public BrowsePlaylistRequest setTimestamp(String timestamp) {
        return addParameter("timestamp", timestamp);
    }
}
