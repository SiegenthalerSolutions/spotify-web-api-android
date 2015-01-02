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
import java.util.Locale;

import me.siegenthaler.spotify.web.api.model.Page;
import me.siegenthaler.spotify.web.api.model.SimpleAlbum;

/**
 * (non-doc)
 */
public final class ArtistAlbumsRequest extends AbstractPageRequest<ArtistAlbumsRequest, SimpleAlbum> {
    /**
     * (non-doc)
     */
    public ArtistAlbumsRequest setArtist(String id) {
        return setPath(String.format(Locale.ENGLISH, "/v1/artists/%s/albums", id));
    }

    /**
     * (non-doc)
     */
    public ArtistAlbumsRequest setAlbumType(String... type) {
        return addParameter("album_type", TextUtils.join(",", type));
    }

    /**
     * (non-doc)
     */
    public ArtistAlbumsRequest setMarket(String market) {
        return addParameter("market", market);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Page<SimpleAlbum> getResponse() throws IOException, JSONException {
        final String data = get();
        final JSONObject object = new JSONObject(data);
        final JSONObject root = object.getJSONObject("albums");

        final List<SimpleAlbum> list = SimpleAlbum.getAllSimple(root.getJSONArray("items"));
        return new Page<>(list, root);
    }
}
