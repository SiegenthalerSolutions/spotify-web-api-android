/**
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
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
    public RestClient mClient;
    public String mHost;
    public String mPath;
    public List<NameValuePair> mParameters = new ArrayList<>();
    public List<NameValuePair> mHeaders = new ArrayList<>();
    public List<NameValuePair> mBodyParameters = new ArrayList<>();
    public JSONObject mJSONBody;

    /**
     * (non-doc)
     */
    public abstract T getResponse() throws IOException, JSONException;

    /**
     * (non-doc)
     */
    final public String post() throws IOException {
        return mClient.post(this);
    }

    /**
     * (non-doc)
     */
    final public String get() throws IOException {
        return mClient.get(this);
    }

    /**
     * (non-doc)
     */
    final public String put() throws IOException {
        return mClient.put(this);
    }

    /**
     * (non-doc)
     */
    final public String delete() throws IOException {
        return mClient.delete(this);
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