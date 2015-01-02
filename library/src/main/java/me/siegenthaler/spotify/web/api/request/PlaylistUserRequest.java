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
import me.siegenthaler.spotify.web.api.model.SimplePlaylist;

/**
 * (non-doc)
 */
public final class PlaylistUserRequest extends AbstractPageRequest<PlaylistUserRequest, SimplePlaylist> {
    /**
     * (non-doc)
     */
    final public PlaylistUserRequest setUser(String user) {
        return setPath(String.format(Locale.ENGLISH, "/v1/users/%s/playlists", user));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Page<SimplePlaylist> getResponse() throws IOException, JSONException {
        final String data = get();
        final JSONObject object = new JSONObject(data);

        final List<SimplePlaylist> list = SimplePlaylist.getAllSimple(object.getJSONArray("items"));
        return new Page<>(list, object);
    }
}
