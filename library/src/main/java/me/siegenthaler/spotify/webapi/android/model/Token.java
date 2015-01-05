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
package me.siegenthaler.spotify.webapi.android.model;

import com.google.gson.annotations.SerializedName;

/**
 * (non-doc)
 */
public class Token {
    @SerializedName("access_token")
    private String mToken;

    @SerializedName("token_type")
    private String mType;

    @SerializedName("expires_in")
    private int mExpiresTime;

    /**
     * Retrieve the access token.
     *
     * @return the access token that will be used for authentication.
     */
    final public String getToken() {
        return mToken;
    }

    /**
     * Retrieves the type of the token.
     *
     * @return a representation string of the privilege of the current session.
     */
    final public String getType() {
        return mType;
    }

    /**
     * Retrieves the expires time of the token.
     *
     * @return a millisecond representation of the expiration time.
     */
    final public int getExpirationTime() {
        return mExpiresTime;
    }
}