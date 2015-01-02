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
package me.siegenthaler.spotify.web.api.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * <a href="https://developer.spotify.com/web-api/object-model/#user-object-private">Private User</a>.
 */
public class User extends SimpleUser {
    private final String mCountry;
    private final String mEmail;
    private final String mProduct;

    /**
     * (non-doc)
     */
    public User(JSONObject data) throws JSONException {
        super(data);
        this.mCountry = data.getString("country");
        this.mEmail = data.getString("email");
        this.mProduct = data.getString("product");
    }

    /**
     * (non-doc)
     */
    final public String getCountry() {
        return mCountry;
    }

    /**
     * (non-doc)
     */
    final public String getEmail() {
        return mEmail;
    }

    /**
     * (non-doc)
     */
    final public String getProduct() {
        return mProduct;
    }
}
