/**
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
package me.siegenthaler.spotify.web.api.request;

import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * (non-doc)
 */
public abstract class FollowCheckRequest<J extends FollowCheckRequest<J>> extends AbstractRequest<J, List<Boolean>> {
    /**
     * (non-doc)
     */
    final public FollowCheckRequest<J> setIds(String... ids) {
        setPath("/v1/me/following");
        return addParameter("ids", TextUtils.join(",", ids));
    }

    /**
     * (non-doc)
     */
    final public FollowCheckRequest<J> setType(String type) {
        return addParameter("type", type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    final public List<Boolean> getResponse() throws IOException, JSONException {
        final String data = get();
        final JSONArray object = new JSONArray(data);

        final List<Boolean> result = new ArrayList<>(object.length());
        for (int i = 0, j = result.size(); i < j; i++) {
            result.add(object.getBoolean(i));
        }
        return result;
    }
}
