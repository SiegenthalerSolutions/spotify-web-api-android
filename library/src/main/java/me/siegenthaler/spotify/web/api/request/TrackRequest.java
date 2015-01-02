/**
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
package me.siegenthaler.spotify.web.api.request;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Locale;

import me.siegenthaler.spotify.web.api.model.Track;

/**
 * (non-doc)
 */
public final class TrackRequest extends AbstractRequest<TrackRequest, Track> {
    /**
     * (non-doc)
     */
    public TrackRequest setTrack(String id) {
        return setPath(String.format(Locale.ENGLISH, "/v1/tracks/%s", id));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Track getResponse() throws IOException, JSONException {
        final String data = get();
        final JSONObject object = new JSONObject(data);
        return new Track(object);
    }
}
