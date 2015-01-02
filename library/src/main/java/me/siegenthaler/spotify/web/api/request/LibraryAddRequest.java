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
package me.siegenthaler.spotify.web.api.request;

import android.text.TextUtils;

import org.json.JSONException;

import java.io.IOException;

/**
 * (non-doc)
 */
public final class LibraryAddRequest extends AbstractRequest<LibraryAddRequest, Void> {
    /**
     * (non-doc)
     */
    public LibraryAddRequest setTracks(String... ids) {
        setPath("/v1/me/tracks");
        return addParameter("ids", TextUtils.join(",", ids));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Void getResponse() throws IOException, JSONException {
        request(METHOD_PUT);
        return null;
    }
}
