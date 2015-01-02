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

import java.util.Calendar;
import java.util.Date;

/**
 * (non-doc)
 */
public class Token {
    /**
     * The calendar of the system.
     */
    private final static Calendar CALENDAR = Calendar.getInstance();

    private final String mToken;
    private final String mType;
    private final Date mExpirationDate;
    private final int mExpiresTime;

    /**
     * (non-doc)
     */
    public Token(JSONObject data) throws JSONException {
        this.mToken = data.getString("access_token");
        this.mType = data.getString("token_type");
        this.mExpiresTime = data.getInt("expires_in");
        this.mExpirationDate = CALENDAR.getTime();
        this.mExpirationDate.setTime(mExpirationDate.getTime() + (mExpiresTime * 1000));
    }

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

    /**
     * Check if the token has expired.
     *
     * @return true if the token has expired, false otherwise.
     */
    final public boolean hasExpired() {
        return mExpirationDate.before(CALENDAR.getTime());
    }
}