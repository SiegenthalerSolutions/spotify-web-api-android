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

import me.siegenthaler.spotify.web.api.model.Artist;

/**
 * (non-doc)
 */
public final class ArtistRelatedArtistsRequest extends AbstractRequest<ArtistRelatedArtistsRequest, List<Artist>> {
    /**
     * (non-doc)
     */
    public ArtistRelatedArtistsRequest setArtist(String id) {
        return setPath(String.format(Locale.ENGLISH, "/v1/artists/%s/related-artists", id));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Artist> getResponse() throws IOException, JSONException {
        final String data = get();
        final JSONObject object = new JSONObject(data);

        final List<Artist> artists = Artist.getAll(object.getJSONArray("artists"));
        return artists;
    }
}
