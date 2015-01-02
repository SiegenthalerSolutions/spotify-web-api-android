/**
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
package me.siegenthaler.spotify.web.api.request;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Locale;

import me.siegenthaler.spotify.web.api.model.Artist;

/**
 * (non-doc)
 */
public final class ArtistRequest extends AbstractRequest<ArtistRequest, Artist> {
    /**
     * (non-doc)
     */
    public ArtistRequest setArtist(String id) {
        return setPath(String.format(Locale.ENGLISH, "/v1/artists/%s", id));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Artist getResponse() throws IOException, JSONException {
        final String data = get();
        final JSONObject object = new JSONObject(data);
        return new Artist(object);
    }
}
