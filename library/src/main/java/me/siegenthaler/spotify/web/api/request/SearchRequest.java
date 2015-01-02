/**
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
package me.siegenthaler.spotify.web.api.request;

/**
 * (non-doc)
 */
public abstract class SearchRequest<J extends SearchRequest<J, T>, T> extends AbstractPageRequest<J, T> {
    /**
     * (non-doc)
     */
    final public SearchRequest<J, T> setQuery(String query) {
        setPath("/v1/search");
        return addParameter("q", query);
    }

    /**
     * (non-doc)
     */
    final public SearchRequest<J, T> setMarket(String market) {
        return addParameter("market", market);
    }

    /**
     * (non-doc)
     */
    final public SearchRequest<J, T> setType(String type) {
        return addParameter("type", type);
    }
}
