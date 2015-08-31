package org.springframework.social.pixelpin.connect;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.pixelpin.api.PixelPin;

/**
 * Created by Adrian on 08/08/2015.
 */
public class PixelPinConnectionFactory extends OAuth2ConnectionFactory<PixelPin> {
    public PixelPinConnectionFactory(String client_id, String client_secret) {
        super("pixelpin", new PixelPinServiceProvider(client_id,client_secret), new PixelPinAdapter());
        System.out.println("PixelPinConnectionFactory");
    }
}
