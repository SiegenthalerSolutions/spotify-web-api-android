/**
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
package me.siegenthaler.spotify.web.api.request;

/**
 *
 */
public final class FollowCheckArtistRequest extends FollowCheckRequest<FollowCheckArtistRequest> {
    /**
     * (non-doc)
     */
    public FollowCheckArtistRequest() {
        setType("artist");
    }
}
