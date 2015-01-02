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
import org.json.JSONObject;

import java.io.IOException;

import me.siegenthaler.spotify.web.api.model.Token;

/**
 * (non-doc)
 */
public final class AuthoriseFlowRequest extends AbstractRequest<AuthoriseFlowRequest, Token> {
    /**
     * (non-doc)
     */
    public AuthoriseFlowRequest setAuthorisation(String id) {
        setPath("/authorize");
        addParameter("response_type", "code");
        return addParameter("client_id", id);
    }

    /**
     * (non-doc)
     */
    public AuthoriseFlowRequest setRedirectUrl(String url) {
        return addParameter("redirect_uri", url);
    }

    /**
     * (non-doc)
     */
    public AuthoriseFlowRequest setState(String state) {
        return addBody("state", state);
    }

    /**
     * (non-doc)
     */
    public AuthoriseFlowRequest setScopes(String... scopes) {
        return addBody("scope", TextUtils.join(" ", scopes));
    }

    /**
     * (non-doc)
     */
    public AuthoriseFlowRequest setForceDialog(boolean isForced) {
        return addBody("show_dialog", isForced ? "true" : "false");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Token getResponse() throws IOException, JSONException {
        final String data = request(METHOD_GET);
        final JSONObject object = new JSONObject(data);
        return new Token(object);
    }
}
