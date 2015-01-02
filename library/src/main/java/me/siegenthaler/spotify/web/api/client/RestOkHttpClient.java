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
package me.siegenthaler.spotify.web.api.client;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.client.utils.URLEncodedUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.List;

import me.siegenthaler.spotify.web.api.RestClient;
import me.siegenthaler.spotify.web.api.request.AbstractRequest;

/**
 * (non-doc)
 */

public class RestOkHttpClient implements RestClient {
    public static final int DEFAULT_PORT = 443;
    public static final String DEFAULT_SCHEME = "https";

    private final OkHttpClient mClient = new OkHttpClient();

    /**
     * (non-doc)
     */
    @SuppressWarnings("unchecked")
    @Override
    public String request(AbstractRequest request, String method) throws IOException {
        final List<NameValuePair> collection = request.mParameters;
        final List<NameValuePair> headers = request.mHeaders;

        final Request.Builder builder = new Request.Builder();
        try {
            final URI requestLink = URIUtils.createURI(
                    DEFAULT_SCHEME,
                    request.mHost,
                    DEFAULT_PORT,
                    request.mPath,
                    collection.size() > 0 ? URLEncodedUtils.format(collection, "UTF-8") : null,
                    null);
            builder.url(requestLink.toURL());
        } catch (URISyntaxException exception) {
            throw new IOException(exception);
        }
        for (NameValuePair pair : headers) {
            builder.header(pair.getName(), pair.getValue());
        }
        if (request.mJSONBody != null) {
            builder.method(method, RequestBody.create(
                    MediaType.parse("application/json; charset=utf-8"),
                    request.mJSONBody.toString()));
        } else if (request.mBodyParameters.size() > 0) {
            builder.method(method, RequestBody.create(
                    MediaType.parse("application/x-www-form-urlencoded; charset=utf-8"),
                    getQuery(request.mBodyParameters)));
        }

        final Response response = mClient.newCall(builder.build()).execute();
        if (!response.isSuccessful()) {
            throw new IOException("Unexpected code: " + response.code());
        }
        return response.body().string();
    }

    /**
     * (non-doc)
     */
    private String getQuery(List<NameValuePair> params) throws UnsupportedEncodingException {
        final StringBuilder result = new StringBuilder();
        boolean first = true;

        for (NameValuePair pair : params) {
            if (first) {
                first = false;
            } else {
                result.append("&");
            }
            result.append(URLEncoder.encode(pair.getName(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(pair.getValue(), "UTF-8"));
        }
        return result.toString();
    }
}
