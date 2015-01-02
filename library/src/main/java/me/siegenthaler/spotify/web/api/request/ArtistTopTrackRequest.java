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

import me.siegenthaler.spotify.web.api.model.Track;

/**
 * (non-doc)
 */
public final class ArtistTopTrackRequest extends AbstractRequest<ArtistTopTrackRequest, List<Track>> {
    /**
     * (non-doc)
     */
    public ArtistTopTrackRequest setArtist(String id) {
        return setPath(String.format(Locale.ENGLISH, "/v1/artists/%s/top-tracks", id));
    }

    /**
     * (non-doc)
     */
    public ArtistTopTrackRequest setCountry(String market) {
        return addParameter("country", market);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Track> getResponse() throws IOException, JSONException {
        final String data = get();
        final JSONObject object = new JSONObject(data);

        final List<Track> tracks = Track.getAll(object.getJSONArray("tracks"));
        return tracks;
    }
}
