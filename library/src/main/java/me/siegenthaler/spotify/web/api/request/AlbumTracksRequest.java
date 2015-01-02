/**
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
package me.siegenthaler.spotify.web.api.request;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import me.siegenthaler.spotify.web.api.model.Page;
import me.siegenthaler.spotify.web.api.model.SimpleTrack;

/**
 * (non-doc)
 */
public final class AlbumTracksRequest extends AbstractPageRequest<AlbumTracksRequest, SimpleTrack> {
    /**
     * (non-doc)
     */
    public AlbumTracksRequest setAlbum(String id) {
        return setPath(String.format(Locale.ENGLISH, "/v1/albums/%s/tracks", id));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Page<SimpleTrack> getResponse() throws IOException, JSONException {
        final String data = get();
        final JSONObject object = new JSONObject(data);
        final JSONObject root = object.getJSONObject("tracks");

        final List<SimpleTrack> list = SimpleTrack.getAllSimple(root.getJSONArray("items"));
        return new Page<>(list, root);
    }
}
