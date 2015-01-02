/**
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
package me.siegenthaler.spotify.web.api.request;

import android.text.TextUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import me.siegenthaler.spotify.web.api.model.Track;

/**
 * (non-doc)
 */
public final class TrackListRequest extends AbstractRequest<TrackListRequest, List<Track>> {
    /**
     * (non-doc)
     */
    public TrackListRequest setTracks(String... id) {
        setPath("/v1/tracks");
        return addParameter("ids", TextUtils.join(",", id));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Track> getResponse() throws IOException, JSONException {
        final String data = get();
        final JSONObject object = new JSONObject(data);
        return Track.getAll(object.getJSONArray("tracks"));
    }
}
