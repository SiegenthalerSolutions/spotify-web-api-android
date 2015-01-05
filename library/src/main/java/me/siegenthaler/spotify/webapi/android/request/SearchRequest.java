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

import java.lang.reflect.Type;

/**
 * (non-doc)
 */
public abstract class SearchRequest<J extends SearchRequest<J, T>, T> extends AbstractPageRequest<J, T> {
    /**
     * (non-doc)
     */
    public SearchRequest(Type type, String searchType) {
        super(type, searchType + "s");
        setPath("/v1/search");
        setType(searchType);
    }

    /**
     * (non-doc)
     */
    final public J setQuery(String query) {
        return addParameter("q", query);
    }

    /**
     * (non-doc)
     */
    final public J setMarket(String market) {
        return addParameter("market", market);
    }

    /**
     * (non-doc)
     */
    final public J setType(String type) {
        return addParameter("type", type);
    }
}
