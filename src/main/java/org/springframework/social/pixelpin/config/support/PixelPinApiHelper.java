package org.springframework.social.pixelpin.config.support;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.xml.ApiHelper;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.pixelpin.api.PixelPin;

/**
 * Created by Adrian on 31/08/2015.
 */
public class PixelPinApiHelper implements ApiHelper<PixelPin> {

    private final static Log logger = LogFactory.getLog(PixelPinApiHelper.class);


    private final UsersConnectionRepository usersConnectionRepository;

    private final UserIdSource userIdSource;

    private PixelPinApiHelper(UsersConnectionRepository usersConnectionRepository, UserIdSource userIdSource) {
        this.usersConnectionRepository = usersConnectionRepository;
        this.userIdSource = userIdSource;
    }

    public PixelPin getApi() {
        if (logger.isDebugEnabled()) {
            logger.debug("Getting API binding instance for PixelPin");
        }

        Connection<PixelPin> connection = usersConnectionRepository.createConnectionRepository(userIdSource.getUserId()).findPrimaryConnection(PixelPin.class);
        if (logger.isDebugEnabled() && connection == null) {
            logger.debug("No current connection; Returning default PixelPinTemplate instance.");
        }
        return connection != null ? connection.getApi() : null;
    }
}
