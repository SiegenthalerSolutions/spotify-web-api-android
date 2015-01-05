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
import android.util.Base64;

import com.android.volley.Request;

import me.siegenthaler.spotify.webapi.android.model.Token;

/**
 * (non-doc)
 */
public final class AuthoriseClientFlowRequest extends AbstractRequest.Builder<AuthoriseClientFlowRequest, Token> {
    /**
     * (non-doc)
     */
    public AuthoriseClientFlowRequest() {
        super(Token.class, Request.Method.POST, null);
        setPath("/api/token");
    }

    /**
     * (non-doc)
     */
    public AuthoriseClientFlowRequest setAuthorisation(String id, String secret) {
        return addHeader(
                "Authorization",
                "Basic " + Base64.encodeToString((id + ":" + secret).getBytes(), Base64.NO_WRAP));
    }

    /**
     * (non-doc)
     */
    public AuthoriseClientFlowRequest setType(String type) {
        return addParameter("grant_type", type);
    }

    /**
     * (non-doc)
     */
    public AuthoriseClientFlowRequest setScopes(String... scopes) {
        return addParameter("scope", TextUtils.join(" ", scopes));
    }

    /**
     * (non-doc)
     */
    public AuthoriseClientFlowRequest setRedirectUrl(String url) {
        return addParameter("redirect_uri", url);
    }
}
