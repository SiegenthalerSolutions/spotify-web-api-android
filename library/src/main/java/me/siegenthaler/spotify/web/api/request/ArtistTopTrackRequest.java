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
package me.siegenthaler.spotify.web.api.request;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import me.siegenthaler.spotify.web.api.model.Track;

/**
 * (non-doc)
 */
public final class ArtistTopTrackRequest extends AbstractRequest<ArtistTopTrackRequest, List<Track>> {
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

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Track> getResponse() throws IOException, JSONException {
        final String data = request(METHOD_GET);
        final JSONObject object = new JSONObject(data);

        final List<Track> tracks = Track.getAll(object.getJSONArray("tracks"));
        return tracks;
    }
}
