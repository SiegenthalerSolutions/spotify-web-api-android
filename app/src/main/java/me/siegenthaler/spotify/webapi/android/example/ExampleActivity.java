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
package me.siegenthaler.spotify.webapi.android.example;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.android.volley.toolbox.Volley;

import java.util.List;

import me.siegenthaler.spotify.webapi.android.ClientRestAPI;
import me.siegenthaler.spotify.webapi.android.model.Album;
import me.siegenthaler.spotify.webapi.android.model.Page;
import me.siegenthaler.spotify.webapi.android.model.Track;

/**
 *
 */
public class ExampleActivity extends ActionBarActivity {
    private ClientRestAPI mClient;

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCreate(Bundle instance) {
        super.onCreate(instance);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mClient = new ClientRestAPI(Volley.newRequestQueue(getApplicationContext()));

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("XXX", "Click");
                mClient.getAlbum("2dIGnmEIy1WZIcZCFSj6i8").setListener(new Response.Listener<Album>() {
                    @Override
                    public void onResponse(Album o) {
                        Log.d("XXX", o.getName());
                    }
                }).setErrorListener(new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.d("XXX", "ERROR:" + volleyError.getMessage());
                    }
                }).build();
            }
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.home_menu, menu);

        final MenuItem item
                = menu.findItem(R.id.search);
        final SearchView view
                = (SearchView) item.getActionView();
        final SearchManager manager
                = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        view.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                onTextChange(s);
                return true;
            }
        });
        view.setSearchableInfo(manager.getSearchableInfo(getComponentName()));
        return true;
    }

    /**
     * (non-doc)
     */
    private void onTextChange(String query) {
        mClient.getRequestQueue().cancelAll("SEARCH");
        mClient.searchTrack(query).setListener(new Response.Listener<Page<Track>>() {
            @Override
            public void onResponse(Page<Track> tracks) {
                final List<Track> items = tracks.getItems();
                for (Track item : items) {
                    Log.d("Track", item.getArtist(0).getName() + " - " + item.getName());
                }
            }
        }).setErrorListener(new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
            }
        }).setLimit(25).setTag("SEARCH").build();
    }
}
