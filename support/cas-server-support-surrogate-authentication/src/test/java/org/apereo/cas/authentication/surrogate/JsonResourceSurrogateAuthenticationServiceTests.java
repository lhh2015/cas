package org.apereo.cas.authentication.surrogate;

import org.apereo.cas.authentication.CoreAuthenticationTestUtils;

import lombok.Getter;
import lombok.SneakyThrows;
import lombok.val;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import static org.junit.Assert.*;

/**
 * This is {@link JsonResourceSurrogateAuthenticationServiceTests}.
 *
 * @author Misagh Moayyed
 * @since 5.3.0
 */
@Getter
public class JsonResourceSurrogateAuthenticationServiceTests extends BaseSurrogateAuthenticationServiceTests {
    private SurrogateAuthenticationService service;

    @BeforeClass
    @SneakyThrows
    public void initTests() {
        val resource = new ClassPathResource("surrogates.json");
        service = new JsonResourceSurrogateAuthenticationService(resource);
    }

    @Test
    public void verifyList() throws Exception {
        val resource = new ClassPathResource("surrogates.json");
        val r = new JsonResourceSurrogateAuthenticationService(resource);
        assertFalse(r.getEligibleAccountsForSurrogateToProxy("casuser").isEmpty());
    }

    @Test
    public void verifyProxying() throws Exception {
        val resource = new ClassPathResource("surrogates.json");
        val r = new JsonResourceSurrogateAuthenticationService(resource);
        assertTrue(r.canAuthenticateAs("banderson", CoreAuthenticationTestUtils.getPrincipal("casuser"),
            CoreAuthenticationTestUtils.getService()));
    }
}
