/**
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
package me.siegenthaler.spotify.web.api.request;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import me.siegenthaler.spotify.web.api.model.Page;
import me.siegenthaler.spotify.web.api.model.Track;

/**
 * (non-doc)
 */
public final class SearchTrackRequest extends SearchRequest<SearchTrackRequest, Track> {
    /**
     * (non-doc)
     */
    public SearchTrackRequest() {
        setType("track");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Page<Track> getResponse() throws IOException, JSONException {
        final String data = get();
        final JSONObject object = new JSONObject(data);
        final JSONObject root = object.getJSONObject("tracks");

        final List<Track> list = Track.getAll(root.getJSONArray("items"));
        return new Page<>(list, root);
    }
}
