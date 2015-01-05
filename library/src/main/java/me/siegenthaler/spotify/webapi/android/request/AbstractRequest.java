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
package me.siegenthaler.spotify.webapi.android.request;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.error.ParseError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import me.siegenthaler.spotify.webapi.android.model.Page;

/**
 * (non-doc)
 */
@SuppressWarnings("unchecked")
public final class AbstractRequest<T> extends Request<T> {
    private final Gson mReader = new Gson();
    private final Map<String, String> mParameters;
    private final Map<String, String> mHeaders;
    private final Type mType;
    private final String mParent;
    private final Response.Listener<T> mListener;
    private final boolean mJsonBody;

    /**
     * (non-doc)
     */
    public AbstractRequest(Builder<?, T> builder) {
        super(builder.mMethod, "https://" + builder.mHost + ":443" + builder.mPath, builder.mErrorListener);
        this.mType = builder.mType;
        this.mParameters = builder.mParameters;
        this.mHeaders = builder.mHeaders;
        this.mParent = builder.mParent;
        this.mListener = builder.mListener;
        this.mJsonBody = builder.mJsonBody;
        setTag(builder.mIdentifier);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    final public String getBodyContentType() {
        return mJsonBody
                ? "application/json; charset=UTF-8"
                : "application/x-www-form-urlencoded; charset=UTF-8";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    final protected Map<String, String> getParams() {
        return mParameters;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    final public Map<String, String> getHeaders() {
        return mHeaders;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    final protected void deliverResponse(T response) {
        if (mListener != null) {
            mListener.onResponse(response);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    final protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            final String json =
                    new String(response.data, HttpHeaderParser.parseCharset(response.headers));

            final JsonElement element = mParent != null
                    ? mReader.fromJson(json, JsonObject.class).get(mParent)
                    : mReader.fromJson(json, JsonObject.class);
            return Response.success(
                    (T) mReader.fromJson(element, mType), HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JsonSyntaxException e) {
            return Response.error(new ParseError(e));
        }
    }

    /**
     * (non-doc)
     */
    public static class Builder<J extends Builder, T> {
        protected final Map<String, String> mParameters = new HashMap<>();
        protected final Map<String, String> mHeaders = new HashMap<>();
        protected final Type mType;
        protected final int mMethod;
        protected String mParent;
        protected String mPath;
        protected String mHost;
        protected Response.ErrorListener mErrorListener;
        protected Response.Listener<T> mListener;
        protected String mIdentifier;
        protected RequestQueue mClient;
        protected boolean mJsonBody;

        /**
         * (non-doc)
         */
        public Builder(Type type) {
            this(type, Method.GET);
        }

        /**
         * (non-doc)
         */
        public Builder(Type type, int method) {
            this(type, method, null);
        }

        /**
         * (non-doc)
         */
        public Builder(Type type, int method, String parent) {
            this.mType = type;
            this.mMethod = method;
            this.mParent = parent;
        }

        /**
         * (non-doc)
         */
        final protected J setJsonBody(boolean isJsonBody) {
            mJsonBody = isJsonBody;
            return (J) this;
        }

        /**
         * (non-doc)
         */
        final public J setClient(RequestQueue client) {
            mClient = client;
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
        final public J setHost(String host) {
            mHost = host;
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
        final public J setTag(String tag) {
            mIdentifier = tag;
            return (J) this;
        }

        /**
         * (non-doc)
         */
        final public AbstractRequest<T> build() {
            final AbstractRequest<T> request = new AbstractRequest<>(this);
            mClient.add(request);
            return request;
        }
    }

    /**
     * (non-doc)
     */
    public static class ListType implements ParameterizedType {
        private final Type mType;

        /**
         * Constructor.
         */
        public ListType(Type type) {
            this.mType = type;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Type[] getActualTypeArguments() {
            return new Type[]{mType};
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Type getRawType() {
            return ArrayList.class;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Type getOwnerType() {
            return null;
        }
    }

    /**
     * (non-doc)
     */
    public static class PageType implements ParameterizedType {
        private final Type mType;

        /**
         * Constructor.
         */
        public PageType(Type type) {
            this.mType = type;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Type[] getActualTypeArguments() {
            return new Type[]{mType};
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Type getRawType() {
            return Page.class;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Type getOwnerType() {
            return null;
        }
    }
}
