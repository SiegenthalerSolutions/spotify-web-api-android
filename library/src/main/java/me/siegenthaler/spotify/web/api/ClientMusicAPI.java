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
package me.siegenthaler.spotify.web.api;

import me.siegenthaler.spotify.web.api.request.LibraryAddRequest;
import me.siegenthaler.spotify.web.api.request.LibraryCheckRequest;
import me.siegenthaler.spotify.web.api.request.LibraryGetRequest;
import me.siegenthaler.spotify.web.api.request.LibraryRemoveRequest;


/**
 * (non-doc)
 */
public class ClientMusicAPI {
    private final ClientAPI mClientAPI;

    /**
     * (non-doc)
     */
    public ClientMusicAPI(ClientAPI api) {
        this.mClientAPI = api;
    }

    /**
     * (non-doc)
     */
    public LibraryCheckRequest contains(String... ids) {
        return mClientAPI.addDefaultHeader(new LibraryCheckRequest()).setIds(ids);
    }

    /**
     * (non-doc)
     */
    public LibraryAddRequest insert(String... ids) {
        return mClientAPI.addDefaultHeader(new LibraryAddRequest()).setTracks(ids);
    }

    /**
     * (non-doc)
     */
    public LibraryRemoveRequest remove(String... ids) {
        return mClientAPI.addDefaultHeader(new LibraryRemoveRequest()).setTracks(ids);
    }

    /**
     * (non-doc)
     */
    public LibraryGetRequest getAll() {
        return mClientAPI.addDefaultHeader(new LibraryGetRequest());
    }
}
