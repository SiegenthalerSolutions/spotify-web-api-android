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

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.error.ParseError;
import com.android.volley.request.JsonRequest;
import com.android.volley.toolbox.HttpHeaderParser;

import org.apache.http.client.utils.URIUtils;
import org.json.JSONException;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * (non-doc)
 */
@SuppressWarnings("unchecked")
public abstract class AbstractRequest<J extends AbstractRequest, T> {
    protected String mHost;
    protected String mScheme;
    protected String mPath;
    protected int mPort;
    protected int mMethod = Request.Method.GET;
    protected final Map<String, String> mParameters = new HashMap<>();
    protected final Map<String, String> mHeaders = new HashMap<>();
    protected String mRawBody;
    protected Response.Listener mListener;
    protected Response.ErrorListener mErrorListener;

    /**
     * (non-doc)
     */
    public abstract T getResponse(String data) throws JSONException;

    /**
     * (non-doc)
     */
    final public Request<T> build() {
        return new BuiltJsonRequest<>(this, new ConstructCallback<T>() {
            @Override
            public T construct(String data) throws JSONException {
                return getResponse(data);
            }
        });
    }

    /**
     * (non-doc)
     */
    final public String getQueryPath() {
        try {
            final URI link = URIUtils.createURI(
                    mScheme,
                    mHost,
                    mPort,
                    mPath,
                    null,
                    null);
            return link.toASCIIString();
        } catch (URISyntaxException exception) {
            throw new IllegalStateException(exception);
        }
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
    final public J setMethod(int method) {
        mMethod = method;
        return (J) this;
    }

    /**
     * (non-doc)
     */
    final public J setScheme(String scheme) {
        mScheme = scheme;
        return (J) this;
    }

    /**
     * (non-doc)
     */
    final public J setPort(int port) {
        mPort = port;
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
    final public J setListener(Response.Listener listener) {
        mListener = listener;
        return (J) this;
    }

    /**
     * (non-doc)
     */
    final public J setErrorListener(Response.ErrorListener listener) {
        mErrorListener = listener;
        return (J) this;
    }

    /**
     * (non-doc)
     */
    final public J setBody(String body) {
        mRawBody = body;
        return (J) this;
    }

    /**
     * (non-doc)
     */
    final public J addParameter(String name, String value) {
        mParameters.put(name, value);
        return (J) this;
    }

    /**
     * (non-doc)
     */
    final public J addHeader(String name, String value) {
        mHeaders.put(name, value);
        return (J) this;
    }

    /**
     * (non-doc)
     */
    public static interface ConstructCallback<T> {
        /**
         * (non-doc)
         */
        public T construct(String data) throws JSONException;
    }

    /**
     * (non-doc)
     */
    public static final class BuiltJsonRequest<T> extends JsonRequest<T> {
        private final Map<String, String> mParameters;
        private final Map<String, String> mHeaders;
        private final ConstructCallback<T> mCallback;

        /**
         * (non-doc)
         */
        public BuiltJsonRequest(AbstractRequest builder, ConstructCallback<T> callback) {
            super(builder.mMethod, builder.getQueryPath(), (builder.mRawBody == null) ? null : builder.mRawBody,
                    builder.mListener, builder.mErrorListener);
            this.mParameters = builder.mParameters;
            this.mHeaders = builder.mHeaders;
            this.mCallback = callback;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected Map<String, String> getParams() {
            return mParameters;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Map<String, String> getHeaders() {
            return mHeaders;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected Response<T> parseNetworkResponse(NetworkResponse response) {
            try {
                final String jsonString =
                        new String(response.data, HttpHeaderParser.parseCharset(response.headers));

                return Response.success(mCallback.construct(jsonString),
                        HttpHeaderParser.parseCacheHeaders(response));
            } catch (UnsupportedEncodingException e) {
                return Response.error(new ParseError(e));
            } catch (JSONException je) {
                return Response.error(new ParseError(je));
            }
        }
    }
}