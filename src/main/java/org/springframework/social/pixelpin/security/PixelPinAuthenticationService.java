package org.springframework.social.pixelpin.security;

import org.springframework.social.pixelpin.api.PixelPin;
import org.springframework.social.pixelpin.connect.PixelPinConnectionFactory;
import org.springframework.social.security.provider.OAuth2AuthenticationService;

/**
 * Created by Adrian on 08/08/2015.
 */
public class PixelPinAuthenticationService extends OAuth2AuthenticationService<PixelPin> {
    public PixelPinAuthenticationService(String apiKey, String appSecret) {
        super(new PixelPinConnectionFactory(apiKey, appSecret));
    }
}
