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
package me.siegenthaler.spotify.webapi.android;

import com.android.volley.RequestQueue;

import me.siegenthaler.spotify.webapi.android.model.Token;
import me.siegenthaler.spotify.webapi.android.request.AbstractRequest;
import me.siegenthaler.spotify.webapi.android.request.AlbumListRequest;
import me.siegenthaler.spotify.webapi.android.request.AlbumRequest;
import me.siegenthaler.spotify.webapi.android.request.AlbumTracksRequest;
import me.siegenthaler.spotify.webapi.android.request.ArtistAlbumsRequest;
import me.siegenthaler.spotify.webapi.android.request.ArtistListRequest;
import me.siegenthaler.spotify.webapi.android.request.ArtistRelatedRequest;
import me.siegenthaler.spotify.webapi.android.request.ArtistRequest;
import me.siegenthaler.spotify.webapi.android.request.ArtistTopTrackRequest;
import me.siegenthaler.spotify.webapi.android.request.AuthoriseClientFlowRequest;
import me.siegenthaler.spotify.webapi.android.request.AuthoriseRefreshRequest;
import me.siegenthaler.spotify.webapi.android.request.PlaylistAddTracksRequest;
import me.siegenthaler.spotify.webapi.android.request.PlaylistChangeDetailsRequest;
import me.siegenthaler.spotify.webapi.android.request.PlaylistCreateRequest;
import me.siegenthaler.spotify.webapi.android.request.PlaylistListRequest;
import me.siegenthaler.spotify.webapi.android.request.PlaylistReplaceTracksRequest;
import me.siegenthaler.spotify.webapi.android.request.PlaylistRequest;
import me.siegenthaler.spotify.webapi.android.request.PlaylistTrackRequest;
import me.siegenthaler.spotify.webapi.android.request.SearchAlbumRequest;
import me.siegenthaler.spotify.webapi.android.request.SearchArtistRequest;
import me.siegenthaler.spotify.webapi.android.request.SearchPlaylistRequest;
import me.siegenthaler.spotify.webapi.android.request.SearchTrackRequest;
import me.siegenthaler.spotify.webapi.android.request.TrackListRequest;
import me.siegenthaler.spotify.webapi.android.request.TrackRequest;
import me.siegenthaler.spotify.webapi.android.request.browse.BrowseAlbumRequest;
import me.siegenthaler.spotify.webapi.android.request.browse.BrowsePlaylistRequest;
import me.siegenthaler.spotify.webapi.android.request.follow.FollowAddRequest;
import me.siegenthaler.spotify.webapi.android.request.follow.FollowCheckRequest;
import me.siegenthaler.spotify.webapi.android.request.follow.FollowRemoveRequest;
import me.siegenthaler.spotify.webapi.android.request.music.MusicAddRequest;
import me.siegenthaler.spotify.webapi.android.request.music.MusicRemoveRequest;
import me.siegenthaler.spotify.webapi.android.request.music.MusicTrackCheckRequest;
import me.siegenthaler.spotify.webapi.android.request.music.MusicTrackRequest;
import me.siegenthaler.spotify.webapi.android.request.profile.UserElseRequest;
import me.siegenthaler.spotify.webapi.android.request.profile.UserRequest;

/**
 * (non-doc)
 */
public class ClientRestAPI {
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
    private Token mToken = null;

    /**
     * (non-doc)
     */
    public ClientRestAPI(RequestQueue queue) {
        this.mRequestQueue = queue;
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
    public ArtistRelatedRequest getArtistsRelated(String id) {
        return addDefaultHeader(new ArtistRelatedRequest()).setArtist(id);
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
    public BrowsePlaylistRequest browsePlaylists() {
        return addDefaultHeader(new BrowsePlaylistRequest());
    }

    /**
     * (non-doc)
     */
    public BrowseAlbumRequest browseAlbums() {
        return addDefaultHeader(new BrowseAlbumRequest());
    }


    /**
     * (non-doc)
     */
    public MusicTrackCheckRequest containsInMusic(String... ids) {
        return addDefaultHeader(new MusicTrackCheckRequest()).setIds(ids);
    }

    /**
     * (non-doc)
     */
    public MusicAddRequest addToMusic(String... ids) {
        return addDefaultHeader(new MusicAddRequest()).setTracks(ids);
    }

    /**
     * (non-doc)
     */
    public MusicRemoveRequest removeFromMusic(String... ids) {
        return addDefaultHeader(new MusicRemoveRequest()).setTracks(ids);
    }

    /**
     * (non-doc)
     */
    public MusicTrackRequest getMusicTracks() {
        return addDefaultHeader(new MusicTrackRequest());
    }

    /**
     * (non-doc)
     */
    public FollowAddRequest addFollower(String type, String... ids) {
        return addDefaultHeader(new FollowAddRequest().setType(type).setIds(ids));
    }

    /**
     * (non-doc)
     */
    public FollowRemoveRequest removeFollower(String type, String... ids) {
        return addDefaultHeader(new FollowRemoveRequest().setType(type).setIds(ids));
    }

    /**
     * (non-doc)
     */
    public FollowCheckRequest isFollowing(String type, String... ids) {
        return addDefaultHeader(new FollowCheckRequest().setType(type).setIds(ids));
    }

    /**
     * (non-doc)
     */
    public PlaylistAddTracksRequest addTrackToPlaylist(String user, String playlist) {
        return addDefaultHeader(new PlaylistAddTracksRequest().setPlaylist(user, playlist));
    }

    /**
     * (non-doc)
     */
    public PlaylistChangeDetailsRequest changePlaylistDetail(String user, String playlist) {
        return addDefaultHeader(new PlaylistChangeDetailsRequest().setPlaylist(user, playlist));
    }

    /**
     * (non-doc)
     */
    public PlaylistCreateRequest createPlaylist(String user, String playlist) {
        return addDefaultHeader(new PlaylistCreateRequest().setUser(user).serName(playlist));
    }

    /**
     * (non-doc)
     */
    public PlaylistReplaceTracksRequest replacePlaylistTracks(String user, String playlist) {
        return addDefaultHeader(new PlaylistReplaceTracksRequest().setPlaylist(user, playlist));
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
    public PlaylistListRequest getPlaylists(String user) {
        return addDefaultHeader(new PlaylistListRequest()).setUser(user);
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
    protected <T extends AbstractRequest.Builder<T, ?>> T addAuthenticationHeader(T request) {
        return request.setClient(mRequestQueue).setHost(DEFAULT_AUTHENTICATION_HOST);
    }

    /**
     * (non-doc)
     */
    protected <T extends AbstractRequest.Builder<T, ?>> T addDefaultHeader(T request) {
        if (mToken != null) {
            request.addHeader("Authorization", "Bearer " + mToken.getToken());
        }
        return request.setClient(mRequestQueue).setHost(DEFAULT_HOST);
    }
}
