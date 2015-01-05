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

/**
 * (non-doc)
 */
public class PlaylistChangeDetailsRequest extends AbstractRequest.Builder<PlaylistChangeDetailsRequest, Void> {
    /**
     * (non-doc)
     */
    public PlaylistChangeDetailsRequest() {
        super(Void.class, Request.Method.PUT);
        setJsonBody(true);
    }

    /**
     * (non-doc)
     */
    final public PlaylistChangeDetailsRequest setPlaylist(String user, String playlist) {
        return setPath(String.format(Locale.ENGLISH, "/v1/users/%s/playlists/%s", user, playlist));
    }

    /**
     * (non-doc)
     */
    final public PlaylistChangeDetailsRequest serName(String name) {
        return addParameter("name", name);
    }

    /**
     * (non-doc)
     */
    final public PlaylistChangeDetailsRequest setPublic(boolean isPublic) {
        return addParameter("public", isPublic ? "true" : "false");
    }
}
