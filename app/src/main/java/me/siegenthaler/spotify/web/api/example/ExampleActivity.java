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

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.Response;

import java.util.List;

import me.siegenthaler.spotify.web.api.ClientAPI;
import me.siegenthaler.spotify.web.api.model.Page;
import me.siegenthaler.spotify.web.api.model.Track;

/**
 *
 */
public class ExampleActivity extends ActionBarActivity {
    private ClientAPI mClient;

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCreate(Bundle instance) {
        super.onCreate(instance);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mClient = new ClientAPI(getApplicationContext());
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

    private void onTextChange(String query)
    {
        mClient.getRequestQueue().cancelAll("SEARCH");
        mClient.searchTrack(query).setListener(new Response.Listener<Page<Track>>() {
            @Override
            public void onResponse(Page<Track> tracks) {
                final List<Track> items = tracks.getItems();
                for (Track item : items) {
                    Log.d("Track", item.getArtist(0).getName() + " - " + item.getName());
                }
            }
        }).setTag("SEARCH").build();
    }
}
