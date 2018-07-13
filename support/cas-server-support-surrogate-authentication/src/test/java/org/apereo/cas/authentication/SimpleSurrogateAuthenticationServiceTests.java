package org.apereo.cas.authentication;

import org.apereo.cas.authentication.surrogate.SimpleSurrogateAuthenticationService;
import org.apereo.cas.authentication.surrogate.SurrogateAuthenticationService;
import org.apereo.cas.util.CollectionUtils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This is {@link SimpleSurrogateAuthenticationServiceTests}.
 *
 * @author Misagh Moayyed
 * @since 5.3.0
 */
public class SimpleSurrogateAuthenticationServiceTests {
    @Test
    public void verifyList() throws Exception {
        final SurrogateAuthenticationService r = new SimpleSurrogateAuthenticationService(
            CollectionUtils.wrap("casuser", CollectionUtils.wrapList("banderson")));
        assertFalse(r.getEligibleAccountsForSurrogateToProxy("casuser").isEmpty());
    }

    @Test
    public void verifyProxying() {
        final SurrogateAuthenticationService r = new SimpleSurrogateAuthenticationService(
            CollectionUtils.wrap("casuser", CollectionUtils.wrapList("banderson")));
        assertTrue(r.canAuthenticateAs("banderson", CoreAuthenticationTestUtils.getPrincipal("casuser"),
            CoreAuthenticationTestUtils.getService()));
    }
}
