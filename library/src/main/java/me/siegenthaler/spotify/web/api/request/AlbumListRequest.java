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

import me.siegenthaler.spotify.web.api.model.Album;

/**
 * (non-doc)
 */
public final class AlbumListRequest extends AbstractRequest<AlbumListRequest, List<Album>> {
    /**
     * (non-doc)
     */
    public AlbumListRequest setAlbums(String... id) {
        setPath("/v1/albums");
        return addParameter("ids", TextUtils.join(",", id));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Album> getResponse() throws IOException, JSONException {
        final String data = get();
        final JSONObject object = new JSONObject(data);
        return Album.getAll(object.getJSONArray("albums"));
    }
}
