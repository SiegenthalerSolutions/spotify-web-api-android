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
package me.siegenthaler.spotify.web.api;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import me.siegenthaler.spotify.web.api.model.Token;
import me.siegenthaler.spotify.web.api.request.AbstractRequest;
import me.siegenthaler.spotify.web.api.request.AlbumListRequest;
import me.siegenthaler.spotify.web.api.request.AlbumRequest;
import me.siegenthaler.spotify.web.api.request.AlbumTracksRequest;
import me.siegenthaler.spotify.web.api.request.ArtistAlbumsRequest;
import me.siegenthaler.spotify.web.api.request.ArtistListRequest;
import me.siegenthaler.spotify.web.api.request.ArtistRelatedArtistsRequest;
import me.siegenthaler.spotify.web.api.request.ArtistRequest;
import me.siegenthaler.spotify.web.api.request.ArtistTopTrackRequest;
import me.siegenthaler.spotify.web.api.request.AuthoriseClientFlowRequest;
import me.siegenthaler.spotify.web.api.request.AuthoriseRefreshRequest;
import me.siegenthaler.spotify.web.api.request.BrowseFeaturedPlaylistRequest;
import me.siegenthaler.spotify.web.api.request.BrowseNewReleasesRequest;
import me.siegenthaler.spotify.web.api.request.PlaylistRequest;
import me.siegenthaler.spotify.web.api.request.PlaylistTrackRequest;
import me.siegenthaler.spotify.web.api.request.PlaylistUserRequest;
import me.siegenthaler.spotify.web.api.request.SearchAlbumRequest;
import me.siegenthaler.spotify.web.api.request.SearchArtistRequest;
import me.siegenthaler.spotify.web.api.request.SearchPlaylistRequest;
import me.siegenthaler.spotify.web.api.request.SearchTrackRequest;
import me.siegenthaler.spotify.web.api.request.TrackListRequest;
import me.siegenthaler.spotify.web.api.request.TrackRequest;
import me.siegenthaler.spotify.web.api.request.UserElseRequest;
import me.siegenthaler.spotify.web.api.request.UserRequest;

/**
 * (non-doc)
 */
public class ClientAPI {
    /**
     * Default port of Spotify API calls.
     */
    private static final int DEFAULT_PORT = 443;

    /**
     * Default http scheme of Spotify API calls.
     */
    private static final String DEFAULT_SCHEME = "https";

    /**
     * Default host of Spotify API calls.
     */
    private static final String DEFAULT_HOST = "api.spotify.com";

    /**
     * Default host of Spotify authentication API calls.
     */
    private static final String DEFAULT_AUTHENTICATION_HOST = "accounts.spotify.com";

    private final RequestQueue mRequestQueue;
    private final ClientMusicAPI mClientMusicAPI;
    private Token mToken = null;

    /**
     * (non-doc)
     */
    public ClientAPI(Context context) {
        this.mRequestQueue = Volley.newRequestQueue(context);
        this.mClientMusicAPI = new ClientMusicAPI(this);
    }

    /**
     * (non-doc)
     */
    public RequestQueue getRequestQueue() {
        return mRequestQueue;
    }

    /**
     * (non-doc)
     */
    public void setToken(Token token) {
        mToken = token;
    }

    /**
     * (non-doc)
     */
    public AuthoriseClientFlowRequest authorise(String clientId, String clientSecret) {
        return addAuthenticationHeader(new AuthoriseClientFlowRequest())
                .setAuthorisation(clientId, clientSecret)
                .setType("client_credentials");
    }

    /**
     * (non-doc)
     */
    public AuthoriseRefreshRequest refresh(String clientId, String clientSecret, String code, String redirectUri) {
        return addAuthenticationHeader(new AuthoriseRefreshRequest())
                .setAuthorisation(clientId, clientSecret)
                .setCode(code)
                .setRedirectUri(redirectUri);
    }

    /**
     * (non-doc)
     */
    public AlbumRequest getAlbum(String id) {
        return addDefaultHeader(new AlbumRequest()).setAlbum(id);
    }

    /**
     * (non-doc)
     */
    public AlbumListRequest getAlbums(String... id) {
        return addDefaultHeader(new AlbumListRequest()).setAlbums(id);
    }

    /**
     * (non-doc)
     */
    public AlbumTracksRequest getAlbumTracks(String id) {
        return addDefaultHeader(new AlbumTracksRequest()).setAlbum(id);
    }

    /**
     * (non-doc)
     */
    public ArtistRequest getArtist(String id) {
        return addDefaultHeader(new ArtistRequest()).setArtist(id);
    }

    /**
     * (non-doc)
     */
    public ArtistListRequest getArtists(String... id) {
        return addDefaultHeader(new ArtistListRequest()).setArtists(id);
    }

    /**
     * (non-doc)
     */
    public ArtistAlbumsRequest getArtistAlbums(String id) {
        return addDefaultHeader(new ArtistAlbumsRequest()).setArtist(id);
    }

    /**
     * (non-doc)
     */
    public ArtistRelatedArtistsRequest getArtistsRelated(String id) {
        return addDefaultHeader(new ArtistRelatedArtistsRequest()).setArtist(id);
    }

    /**
     * (non-doc)
     */
    public ArtistTopTrackRequest getArtistTopTracks(String id) {
        return addDefaultHeader(new ArtistTopTrackRequest()).setArtist(id);
    }

    /**
     * (non-doc)
     */
    public BrowseFeaturedPlaylistRequest browseFeaturePlaylists() {
        return addDefaultHeader(new BrowseFeaturedPlaylistRequest());
    }

    /**
     * (non-doc)
     */
    public BrowseNewReleasesRequest browseAlbumReleases() {
        return addDefaultHeader(new BrowseNewReleasesRequest());
    }

    /**
     * (non-doc)
     */
    public ClientMusicAPI getMyMusic() {
        return mClientMusicAPI;
    }

    /**
     * (non-doc)
     */
    public PlaylistRequest getPlaylist(String user, String id) {
        return addDefaultHeader(new PlaylistRequest()).setPlaylist(user, id);
    }

    /**
     * (non-doc)
     */
    public PlaylistTrackRequest getPlaylistTracks(String user, String id) {
        return addDefaultHeader(new PlaylistTrackRequest()).setPlaylist(user, id);
    }

    /**
     * (non-doc)
     */
    public PlaylistUserRequest getPlaylists(String user) {
        return addDefaultHeader(new PlaylistUserRequest()).setUser(user);
    }

    /**
     * (non-doc)
     */
    public SearchAlbumRequest searchAlbum(String query) {
        return addDefaultHeader(new SearchAlbumRequest()).setQuery(query);
    }

    /**
     * (non-doc)
     */
    public SearchArtistRequest searchArtist(String query) {
        return addDefaultHeader(new SearchArtistRequest()).setQuery(query);
    }

    /**
     * (non-doc)
     */
    public SearchPlaylistRequest searchPlaylist(String query) {
        return addDefaultHeader(new SearchPlaylistRequest()).setQuery(query);
    }

    /**
     * (non-doc)
     */
    public SearchTrackRequest searchTrack(String query) {
        return addDefaultHeader(new SearchTrackRequest()).setQuery(query);
    }

    /**
     * (non-doc)
     */
    public TrackRequest getTrack(String id) {
        return addDefaultHeader(new TrackRequest()).setTrack(id);
    }

    /**
     * (non-doc)
     */
    public TrackListRequest getTracks(String... id) {
        return addDefaultHeader(new TrackListRequest()).setTracks(id);
    }

    /**
     * (non-doc)
     */
    public UserRequest getUser() {
        return addDefaultHeader(new UserRequest());
    }

    /**
     * (non-doc)
     */
    public UserElseRequest getUser(String id) {
        return addDefaultHeader(new UserElseRequest().setUser(id));
    }

    /**
     * (non-doc)
     */
    protected <T extends AbstractRequest<T, ?>> T addAuthenticationHeader(T request) {
        return request
                .setClient(mRequestQueue)
                .setHost(DEFAULT_AUTHENTICATION_HOST)
                .setScheme(DEFAULT_SCHEME)
                .setPort(DEFAULT_PORT);
    }

    /**
     * (non-doc)
     */
    protected <T extends AbstractRequest<T, ?>> T addDefaultHeader(T request) {
        if (mToken != null && !mToken.hasExpired()) {
            request.addHeader("Authorization", "Bearer " + mToken.getToken());
        }
        return request
                .setClient(mRequestQueue)
                .setHost(DEFAULT_HOST)
                .setScheme(DEFAULT_SCHEME)
                .setPort(DEFAULT_PORT);
    }
}
