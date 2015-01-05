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

import java.util.Locale;

import me.siegenthaler.spotify.webapi.android.model.Playlist;

/**
 * (non-doc)
 */
public final class PlaylistTrackRequest extends AbstractPageRequest<PlaylistTrackRequest, Playlist.Information> {
    private final static AbstractRequest.PageType PARAMETER_TYPE = new AbstractRequest.PageType(Playlist.Information.class);

    /**
     * (non-doc)
     */
    public PlaylistTrackRequest() {
        super(PARAMETER_TYPE);
    }

    /**
     * (non-doc)
     */
    public PlaylistTrackRequest setPlaylist(String user, String id) {
        return setPath(String.format(Locale.ENGLISH, "/v1/users/%s/playlists/%s/tracks", user, id));
    }

    /**
     * (non-doc)
     */
    public PlaylistTrackRequest setFields(String field) {
        return addParameter("fields", field);
    }
}
