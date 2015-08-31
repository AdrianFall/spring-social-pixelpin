package org.springframework.social.pixelpin.connect;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.pixelpin.api.PixelPin;
import org.springframework.social.pixelpin.api.PixelPinUserProfile;
import org.springframework.social.pixelpin.api.UserOperations;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Adrian on 31/08/2015.
 */
public class PixelPinAdapterTest {

    PixelPinAdapter pixelPinAdapter = new PixelPinAdapter();
    private PixelPin pixelPin = Mockito.mock(PixelPin.class);

    @Test
    public void fetchProfile() throws Exception {

        // Mock UserOperations
        UserOperations userOperations = Mockito.mock(UserOperations.class);
        Mockito.when(pixelPin.userOperations()).thenReturn(userOperations);
        Mockito.when(userOperations.getUserProfile())
                .thenReturn(new PixelPinUserProfile(10, "first_name","email@em.ail"));


        UserProfile profile = pixelPinAdapter.fetchUserProfile(pixelPin);

        assertEquals("email@em.ail", profile.getEmail());
        assertEquals("first_name", profile.getFirstName());

    }

}
