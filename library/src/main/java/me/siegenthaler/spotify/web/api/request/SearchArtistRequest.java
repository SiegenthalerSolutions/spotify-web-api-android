/**
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
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
