package org.springframework.social.pixelpin.config.xml;

import org.springframework.social.config.xml.AbstractProviderConfigBeanDefinitionParser;
import org.springframework.social.config.xml.AbstractProviderConfigNamespaceHandler;

/**
 * Created by Adrian on 31/08/2015.
 */
public class PixelPinNamespaceHandler extends AbstractProviderConfigNamespaceHandler {
    @Override
    protected AbstractProviderConfigBeanDefinitionParser getProviderConfigBeanDefinitionParser() {
        return new PixelPinConfigBeanDefinitionParser();
    }
}
