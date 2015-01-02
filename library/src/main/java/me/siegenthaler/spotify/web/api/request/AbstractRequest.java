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

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import me.siegenthaler.spotify.web.api.RestClient;

/**
 * (non-doc)
 */
@SuppressWarnings("unchecked")
public abstract class AbstractRequest<J extends AbstractRequest, T> {
    public final static String METHOD_GET = "GET";
    public final static String METHOD_POST = "POST";
    public final static String METHOD_PUT = "PUT";
    public final static String METHOD_DELETE = "DELETE";

    public RestClient mClient;
    public String mHost;
    public String mPath;
    public List<NameValuePair> mParameters = new ArrayList<>();
    public List<NameValuePair> mHeaders = new ArrayList<>();
    public List<NameValuePair> mBodyParameters = new ArrayList<>();
    public JSONObject mJSONBody;
    public String mMethod;

    /**
     * (non-doc)
     */
    public abstract T getResponse() throws IOException, JSONException;

    /**
     * (non-doc)
     */
    final public String request(String method) throws IOException {
        return mClient.request(this, method);
    }

    /**
     * (non-doc)
     */
    final public J setClient(RestClient client) {
        mClient = client;
        return (J) this;
    }

    /**
     * (non-doc)
     */
    final public J setHost(String host) {
        mHost = host;
        return (J) this;
    }

    /**
     * (non-doc)
     */
    final public J setPath(String path) {
        mPath = path;
        return (J) this;
    }

    /**
     * (non-doc)
     */
    final public J setParameters(List<NameValuePair> parameters) {
        mParameters = parameters;
        return (J) this;
    }

    /**
     * (non-doc)
     */
    final public J addParameter(String name, String value) {
        mParameters.add(new BasicNameValuePair(name, value));
        return (J) this;
    }

    /**
     * (non-doc)
     */
    final public J setHeaders(List<NameValuePair> headerParameters) {
        mHeaders = headerParameters;
        return (J) this;
    }

    /**
     * (non-doc)
     */
    final public J addHeader(String name, String value) {
        mHeaders.add(new BasicNameValuePair(name, value));
        return (J) this;
    }

    /**
     * (non-doc)
     */
    final public J setBodyAsParameters(List<NameValuePair> bodyParameters) {
        mBodyParameters = bodyParameters;
        return (J) this;
    }

    /**
     * (non-doc)
     */
    final public J addBody(String name, String value) {
        mBodyParameters.add(new BasicNameValuePair(name, value));
        return (J) this;
    }

    /**
     * (non-doc)
     */
    final public J setBodyAsJson(JSONObject jsonBody) {
        mJSONBody = jsonBody;
        return (J) this;
    }
}