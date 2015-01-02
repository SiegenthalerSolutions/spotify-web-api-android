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

import me.siegenthaler.spotify.web.api.ClientAPI;
import me.siegenthaler.spotify.web.api.model.Album;
import me.siegenthaler.spotify.web.api.model.Page;
import me.siegenthaler.spotify.web.api.model.SimplePlaylist;
import me.siegenthaler.spotify.web.api.model.Track;

/**
 *
 */
public class ExampleActivity extends Activity {
    private ClientAPI mClient;

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCreate(Bundle instance) {
        super.onCreate(instance);

        mClient = new ClientAPI(getApplicationContext());
        mClient.getAlbum("2dIGnmEIy1WZIcZCFSj6i8").setListener(new Response.Listener<Album>() {
            @Override
            public void onResponse(Album album) {
                Log.d("Album", album.getName());
            }
        }).send();

        mClient.searchTrack("ihre persönliche glücksmelodie").setListener(new Response.Listener<Page<Track>>() {
            @Override
            public void onResponse(Page<Track> tracks) {
                final List<Track> items = tracks.getItems();
                for (Track item : items) {
                    Log.d("Track", item.getArtist(0).getName() + " - " + item.getName());
                }
            }
        }).send();

        mClient.getPlaylists("wolftein").setListener(new Response.Listener<Page<SimplePlaylist>>() {
            @Override
            public void onResponse(Page<SimplePlaylist> playlists) {
                final List<SimplePlaylist> items = playlists.getItems();
                for (SimplePlaylist item : items) {
                    Log.d("Playlist", item.getName());
                }
            }
        }).setErrorListener(new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.d("Playlist", volleyError.toString());  // Will trigger no authentication error
            }
        }).send();
    }
}
