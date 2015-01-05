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
package me.siegenthaler.spotify.webapi.android.request.follow;

import android.text.TextUtils;

import java.util.List;

import me.siegenthaler.spotify.webapi.android.request.AbstractRequest;

/**
 * (non-doc)
 */
public final class FollowCheckRequest extends AbstractRequest.Builder<FollowCheckRequest, List<Boolean>> {
    private final static AbstractRequest.ListType PARAMETER_TYPE = new AbstractRequest.ListType(Boolean.class);

    public final static String TYPE_ARTIST = "artist";
    public final static String TYPE_USER = "user";

    /**
     * (non-doc)
     */
    public FollowCheckRequest() {
        super(PARAMETER_TYPE);
        setPath("/v1/me/following");
    }

    /**
     * (non-doc)
     */
    public FollowCheckRequest setIds(String... ids) {
        return addParameter("ids", TextUtils.join(",", ids));
    }

    /**
     * (non-doc)
     */
    public FollowCheckRequest setType(String type) {
        return addParameter("type", type);
    }
}
