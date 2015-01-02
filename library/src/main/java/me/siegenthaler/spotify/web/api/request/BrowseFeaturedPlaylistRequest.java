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
import me.siegenthaler.spotify.web.api.model.SimplePlaylist;

/**
 * (non-doc)
 */
public final class BrowseFeaturedPlaylistRequest extends AbstractPageRequest<BrowseFeaturedPlaylistRequest, SimplePlaylist> {
    /**
     * (non-doc)
     */
    public BrowseFeaturedPlaylistRequest() {
        setPath("/v1/browse/featured-playlists");
    }

    /**
     * (non-doc)
     */
    public BrowseFeaturedPlaylistRequest setCountry(String country) {
        return addParameter("country", country);
    }

    /**
     * (non-doc)
     */
    public BrowseFeaturedPlaylistRequest setLocale(String locale) {
        return addParameter("locale", locale);
    }

    /**
     * (non-doc)
     */
    public BrowseFeaturedPlaylistRequest setTimestamp(String timestamp) {
        return addParameter("timestamp", timestamp);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Page<SimplePlaylist> getResponse() throws IOException, JSONException {
        final String data = get();
        final JSONObject object = new JSONObject(data);
        final JSONObject root = object.getJSONObject("playlists");

        final List<SimplePlaylist> list = SimplePlaylist.getAllSimple(root.getJSONArray("items"));
        return new Page<>(list, root);
    }
}
