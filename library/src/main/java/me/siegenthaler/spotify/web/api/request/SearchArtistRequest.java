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

import me.siegenthaler.spotify.web.api.model.Artist;
import me.siegenthaler.spotify.web.api.model.Page;

/**
 * (non-doc)
 */
public final class SearchArtistRequest extends SearchRequest<SearchArtistRequest, Artist> {
    /**
     * (non-doc)
     */
    public SearchArtistRequest() {
        setType("artist");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Page<Artist> getResponse() throws IOException, JSONException {
        final String data = get();
        final JSONObject object = new JSONObject(data);
        final JSONObject root = object.getJSONObject("artists");

        final List<Artist> list = Artist.getAll(root.getJSONArray("items"));
        return new Page<>(list, root);
    }
}
