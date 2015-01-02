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

import com.android.volley.Request;

import org.json.JSONException;

/**
 * (non-doc)
 */
public final class FollowRemoveRequest extends AbstractRequest<FollowRemoveRequest, Void> {
    public final static String TYPE_ARTIST = "artist";
    public final static String TYPE_USER = "user";

    /**
     * (non-doc)
     */
    public FollowRemoveRequest setIds(String... ids) {
        setMethod(Request.Method.DELETE);
        setPath("/v1/me/following");
        return addParameter("ids", TextUtils.join(",", ids));
    }

    /**
     * (non-doc)
     */
    public FollowRemoveRequest setType(String type) {
        return addParameter("type", type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Void getResponse(String data) throws JSONException {
        return null;
    }
}
