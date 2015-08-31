package org.springframework.social.pixelpin.api.impl.json;

import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.social.pixelpin.api.PixelPinUserProfile;

/**
 * Created by Adrian on 08/08/2015.
 */
public class PixelPinModule extends SimpleModule {

    public PixelPinModule() {
        super("PixelPinModule");
    }

    @Override
    public void setupModule(SetupContext context) {
        context.setMixInAnnotations(PixelPinUserProfile.class, PixelPinUserProfileMixin.class);
    }
}
