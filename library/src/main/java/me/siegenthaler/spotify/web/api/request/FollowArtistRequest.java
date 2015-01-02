/**
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
package me.siegenthaler.spotify.web.api.request;

/**
 *
 */
public final class FollowArtistRequest extends FollowRequest<FollowArtistRequest> {
    /**
     * (non-doc)
     */
    public FollowArtistRequest() {
        setType("artist");
    }
}
