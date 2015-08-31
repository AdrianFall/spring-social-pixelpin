package org.springframework.social.pixelpin.connect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.social.pixelpin.api.PixelPin;
import org.springframework.social.pixelpin.api.PixelPinUserProfile;
import org.springframework.web.client.HttpClientErrorException;

/**
 * Created by Adrian on 08/08/2015.
 */
public class PixelPinAdapter implements ApiAdapter<PixelPin> {

    private final static Log logger = LogFactory.getLog(PixelPinAdapter.class);

    public boolean test(PixelPin pixelPin) {
        try {
            pixelPin.userOperations().getUserProfile();
            return true;
        } catch (HttpClientErrorException e) {
            return false;
        }
    }

    public void setConnectionValues(PixelPin pixelPin, ConnectionValues values) {
        System.out.println("PixelPinAdapter setConnectionValues()");
        PixelPinUserProfile profile = pixelPin.userOperations().getUserProfile();
        values.setProviderUserId(String.valueOf(profile.getId()));
        values.setDisplayName(profile.getFirstName());
        System.out.println("PixelPinAdapter setConnectionValues() : profile id = " + profile.getId() + " profile email = " + profile.getEmail());
    }

    public UserProfile fetchUserProfile(PixelPin pixelPin) {
        System.out.println("PixelPinAdapter - fetchingUserProfile");
        PixelPinUserProfile profile = pixelPin.userOperations().getUserProfile();
        if (profile != null && logger.isDebugEnabled()) logger.debug("Fetched PixelPin UserProfile");
        return new UserProfileBuilder()
                .setName(profile.getFirstName())
                .setEmail(profile.getEmail())
                .build();
    }

    public void updateStatus(PixelPin pixelPin, String s) {

    }
}
