/**
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
package me.siegenthaler.spotify.web.api.request;

import android.text.TextUtils;

import org.json.JSONException;

import java.io.IOException;

/**
 * (non-doc)
 */
public abstract class FollowRequest<J extends FollowRequest<J>> extends AbstractRequest<J, String> {
    protected boolean mDelete;

    /**
     * (non-doc)
     */
    final public FollowRequest<J> setIds(String... ids) {
        setPath("/v1/me/following");
        return addParameter("ids", TextUtils.join(",", ids));
    }

    /**
     * (non-doc)
     */
    final public FollowRequest<J> setDelete(boolean isDeleteAction) {
        mDelete = isDeleteAction;
        return this;
    }

    /**
     * (non-doc)
     */
    final public FollowRequest<J> setType(String type) {
        return addParameter("type", type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    final public String getResponse() throws IOException, JSONException {
        return (mDelete ? delete() : put());
    }
}
