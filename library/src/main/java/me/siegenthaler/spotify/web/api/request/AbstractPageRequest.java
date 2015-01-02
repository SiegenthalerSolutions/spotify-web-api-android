/**
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
package me.siegenthaler.spotify.web.api.request;

import me.siegenthaler.spotify.web.api.model.Page;

/**
 * (non-doc)
 */
public abstract class AbstractPageRequest<J extends AbstractPageRequest<J, T>, T> extends AbstractRequest<J, Page<T>> {
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
