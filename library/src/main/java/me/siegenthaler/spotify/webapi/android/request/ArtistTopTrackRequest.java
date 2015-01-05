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

import com.android.volley.Request;

import java.util.List;
import java.util.Locale;

import me.siegenthaler.spotify.webapi.android.model.Track;

/**
 * (non-doc)
 */
public final class ArtistTopTrackRequest extends AbstractRequest.Builder<ArtistTopTrackRequest, List<Track>> {
    private final static AbstractRequest.ListType PARAMETER_TYPE = new AbstractRequest.ListType(Track.class);

    /**
     * (non-doc)
     */
    public ArtistTopTrackRequest() {
        super(PARAMETER_TYPE, Request.Method.GET, "tracks");
    }

    /**
     * (non-doc)
     */
    public ArtistTopTrackRequest setArtist(String id) {
        return setPath(String.format(Locale.ENGLISH, "/v1/artists/%s/top-tracks", id));
    }

    /**
     * (non-doc)
     */
    public ArtistTopTrackRequest setCountry(String market) {
        return addParameter("country", market);
    }
}
