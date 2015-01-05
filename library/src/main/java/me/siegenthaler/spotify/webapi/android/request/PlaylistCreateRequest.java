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

import com.android.volley.Request;

import java.util.Locale;

import me.siegenthaler.spotify.webapi.android.model.Playlist;

/**
 * (non-doc)
 */
public class PlaylistCreateRequest extends AbstractRequest.Builder<PlaylistCreateRequest, Playlist> {
    /**
     * (non-doc)
     */
    public PlaylistCreateRequest() {
        super(Playlist.class, Request.Method.POST);
        setJsonBody(true);
    }

    /**
     * (non-doc)
     */
    final public PlaylistCreateRequest setUser(String user) {
        return setPath(String.format(Locale.ENGLISH, "/v1/users/%s/playlists", user));
    }

    /**
     * (non-doc)
     */
    final public PlaylistCreateRequest serName(String name) {
        return addParameter("name", name);
    }

    /**
     * (non-doc)
     */
    final public PlaylistCreateRequest setPublic(boolean isPublic) {
        return addParameter("public", isPublic ? "true" : "false");
    }
}
