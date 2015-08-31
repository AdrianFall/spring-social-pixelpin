package org.springframework.social.pixelpin.connect;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.social.pixelpin.api.PixelPin;
import org.springframework.social.pixelpin.api.impl.PixelPinTemplate;

/**
 * Created by Adrian on 08/08/2015.
 */
public class PixelPinServiceProvider extends AbstractOAuth2ServiceProvider<PixelPin> {

    public PixelPinServiceProvider(String client_id, String client_secret) {
        super(createOAuth2Template(client_id, client_secret));
    }

    private static OAuth2Template createOAuth2Template(String client_id, String client_secret) {
        OAuth2Template oAuth2Template = new OAuth2Template(client_id, client_secret, "https://login.pixelpin.co.uk/OAuth2/Flogin.aspx", "https://ws3.pixelpin.co.uk/index.php/api/token");
        oAuth2Template.setUseParametersForClientAuthentication(true);
        return oAuth2Template;
    }

    @Override
    public PixelPin getApi(String accessToken) {
        System.out.println("Getting PixelPing API");
        return new PixelPinTemplate(accessToken);
    }
}
