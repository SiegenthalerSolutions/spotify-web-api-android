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

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * (non-doc)
 */
public final class LibraryCheckRequest extends AbstractRequest<LibraryCheckRequest, List<Boolean>> {
    /**
     * (non-doc)
     */
    public LibraryCheckRequest setIds(String... ids) {
        setPath("v1/me/tracks/contains");
        return addParameter("ids", TextUtils.join(",", ids));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Boolean> getResponse() throws IOException, JSONException {
        final String data = request(METHOD_GET);
        final JSONArray object = new JSONArray(data);

        final List<Boolean> result = new ArrayList<>(object.length());
        for (int i = 0, j = result.size(); i < j; i++) {
            result.add(object.getBoolean(i));
        }
        return result;
    }
}
