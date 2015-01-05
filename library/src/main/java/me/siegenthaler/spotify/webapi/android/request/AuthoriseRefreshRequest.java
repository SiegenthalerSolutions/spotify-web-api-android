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

import android.util.Base64;

import com.android.volley.Request;

import me.siegenthaler.spotify.webapi.android.model.Token;

/**
 * (non-doc)
 */
public final class AuthoriseRefreshRequest extends AbstractRequest.Builder<AuthoriseRefreshRequest, Token> {
    /**
     * (non-doc)
     */
    public AuthoriseRefreshRequest() {
        super(Token.class, Request.Method.POST, null);
        setPath("/api/token");
        addParameter("grant_type", "authorization_code");
    }

    /**
     * (non-doc)
     */
    public AuthoriseRefreshRequest setAuthorisation(String id, String secret) {
        return addHeader(
                "Authorization",
                "Basic " + Base64.encodeToString((id + ":" + secret).getBytes(), Base64.NO_WRAP));
    }

    /**
     * (non-doc)
     */
    public AuthoriseRefreshRequest setCode(String code) {
        return addParameter("code", code);
    }

    /**
     * (non-doc)
     */
    public AuthoriseRefreshRequest setRedirectUri(String uri) {
        return addParameter("redirect_uri", uri);
    }
}
