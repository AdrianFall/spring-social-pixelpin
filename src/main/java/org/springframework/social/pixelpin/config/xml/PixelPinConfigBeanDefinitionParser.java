package org.springframework.social.pixelpin.config.xml;

import org.springframework.social.config.xml.AbstractProviderConfigBeanDefinitionParser;
import org.springframework.social.config.xml.ApiHelper;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.pixelpin.config.support.PixelPinApiHelper;
import org.springframework.social.pixelpin.connect.PixelPinConnectionFactory;
import org.springframework.social.pixelpin.security.PixelPinAuthenticationService;
import org.springframework.social.security.provider.SocialAuthenticationService;

/**
 * Created by Adrian on 31/08/2015.
 */
public class PixelPinConfigBeanDefinitionParser extends AbstractProviderConfigBeanDefinitionParser {

    /**
     * Constructs a connection factory-creating {@link PixelPinConfigBeanDefinitionParser}.
     *
     * @param connectionFactoryClass The type of {@link ConnectionFactory} to create. Must have a two-argument constructor taking an application's ID and secret as Strings.
     * @param apiHelperClass         the API helper class
     */
    public PixelPinConfigBeanDefinitionParser(Class<? extends ConnectionFactory<?>> connectionFactoryClass, Class<? extends ApiHelper<?>> apiHelperClass) {
        super(connectionFactoryClass, apiHelperClass);
    }

    public PixelPinConfigBeanDefinitionParser() {
        super(PixelPinConnectionFactory.class, PixelPinApiHelper.class);
    }

    @Override
    protected Class<? extends SocialAuthenticationService<?>> getAuthenticationServiceClass() {
        return PixelPinAuthenticationService.class;
    }
}
