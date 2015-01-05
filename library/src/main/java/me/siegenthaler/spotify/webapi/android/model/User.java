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
public class User extends SimpleUser {
    @SerializedName("country")
    private String mCountry;

    @SerializedName("email")
    private String mEmail;

    @SerializedName("product")
    private String mProduct;

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
