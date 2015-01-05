/*
 * Copyright (C) 2014 Siegenthaler Solutions.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.siegenthaler.spotify.webapi.android.request;

import android.text.TextUtils;

import com.android.volley.Request;

import java.util.Locale;

import me.siegenthaler.spotify.webapi.android.model.Snapshot;

/**
 * (non-doc)
 */
public class PlaylistAddTracksRequest extends AbstractRequest.Builder<PlaylistAddTracksRequest, Snapshot> {
    /**
     * (non-doc)
     */
    public PlaylistAddTracksRequest() {
        super(Snapshot.class, Request.Method.POST);
    }

    /**
     * (non-doc)
     */
    final public PlaylistAddTracksRequest setPlaylist(String user, String playlist) {
        return setPath(String.format(Locale.ENGLISH, "/v1/users/%s/playlists/%s/tracks", user, playlist));
    }

    /**
     * (non-doc)
     */
    final public PlaylistAddTracksRequest setTracks(int position, String... ids) {
        addParameter("position", String.valueOf(position));
        return addParameter("uris", TextUtils.join(",", ids));
    }
}
