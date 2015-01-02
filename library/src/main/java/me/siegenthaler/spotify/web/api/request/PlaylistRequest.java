/**
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
package me.siegenthaler.spotify.web.api.request;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Locale;

import me.siegenthaler.spotify.web.api.model.Playlist;

/**
 * (non-doc)
 */
public final class PlaylistRequest extends AbstractRequest<PlaylistRequest, Playlist> {
    /**
     * (non-doc)
     */
    public PlaylistRequest setPlaylist(String user, String id) {
        return setPath(String.format(Locale.ENGLISH, "/v1/users/%s/playlists/%s", user, id));
    }

    /**
     * (non-doc)
     */
    public PlaylistRequest setFields(String field) {
        return addParameter("fields", field);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Playlist getResponse() throws IOException, JSONException {
        final String data = get();
        final JSONObject object = new JSONObject(data);
        return new Playlist(object);
    }
}
