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
package me.siegenthaler.spotify.web.api.example;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.error.VolleyError;

import java.util.List;

import me.siegenthaler.spotify.web.api.RestClient;
import me.siegenthaler.spotify.web.api.model.Page;
import me.siegenthaler.spotify.web.api.model.Track;
import me.siegenthaler.spotify.web.api.request.AbstractRequest;
import me.siegenthaler.spotify.web.api.request.SearchTrackRequest;

/**
 *
 */
public class ExampleActivity extends Activity {
    public static final int DEFAULT_PORT = 443;
    public static final String DEFAULT_SCHEME = "https";
    public static final String DEFAULT_HOST = "api.spotify.com";

    private RestClient mClient;

    @Override
    public void onCreate(Bundle instance) {
        super.onCreate(instance);

        mClient = new RestClient();
        mClient.init(getApplicationContext());

        mClient.getRequestQueue().add(addDefaultHeader(new SearchTrackRequest())
                .setQuery("Skrillex")
                .setOffset(0)
                .setErrorListener(new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.e("Spotify-Web-Api", volleyError.toString());
                    }
                })
                .setListener(new Response.Listener<Page<Track>>() {
                    @Override
                    public void onResponse(Page<Track> o) {
                        Log.d("A", o.getHref());
                        Log.d("A", o.getNext());
                        Log.d("A", o.getPrevious());
                        Log.d("A", "" + o.getTotal());
                        Log.d("A", "" + o.getLimit());

                        List<Track> tracks = o.getItems();
                        for (int i = 0; i < tracks.size(); i++) {
                            Log.d("Spotify-Web-Api", tracks.get(i).getName());
                        }
                        Log.d("Spotify-Web-Api", o.getHref());
                    }
                })
                .setLimit(50).build());
    }

    private <T extends AbstractRequest<T, ?>> T addDefaultHeader(T request) {
        return request.setHost(DEFAULT_HOST)
                .setScheme(DEFAULT_SCHEME)
                .setPort(DEFAULT_PORT);
    }
}
