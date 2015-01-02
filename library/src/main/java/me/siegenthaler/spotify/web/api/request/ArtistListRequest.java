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

import android.text.TextUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import me.siegenthaler.spotify.web.api.model.Artist;

/**
 * (non-doc)
 */
public final class ArtistListRequest extends AbstractRequest<ArtistListRequest, List<Artist>> {
    /**
     * (non-doc)
     */
    public ArtistListRequest setArtists(String... id) {
        setPath("/v1/albums");
        return addParameter("ids", TextUtils.join(",", id));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Artist> getResponse(String data) throws JSONException {
        final JSONObject object = new JSONObject(data);
        return Artist.getAll(object.getJSONArray("artists"));
    }
}
