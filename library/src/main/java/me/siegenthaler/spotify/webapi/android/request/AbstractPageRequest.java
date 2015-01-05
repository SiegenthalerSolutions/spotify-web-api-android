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

import java.lang.reflect.Type;

import me.siegenthaler.spotify.webapi.android.model.Page;

/**
 * (non-doc)
 */
public abstract class AbstractPageRequest<J extends AbstractPageRequest<J, T>, T> extends AbstractRequest.Builder<J, Page<T>> {
    /**
     * (non-doc)
     */
    public AbstractPageRequest(Type type) {
        this(type, null);
    }

    /**
     * (non-doc)
     */
    public AbstractPageRequest(Type type, String parent) {
        super(type, Request.Method.GET, parent);
    }

    /**
     * (non-doc)
     */
    final public AbstractPageRequest<J, T> setLimit(int limit) {
        return addParameter("limit", String.valueOf(limit));
    }

    /**
     * (non-doc)
     */
    final public AbstractPageRequest<J, T> setOffset(int offset) {
        return addParameter("offset", String.valueOf(offset));
    }
}
