package org.apereo.cas.authentication.surrogate;

import org.apereo.cas.util.CollectionUtils;

import lombok.Getter;

/**
 * This is {@link SimpleSurrogateAuthenticationServiceTests}.
 *
 * @author Misagh Moayyed
 * @since 5.3.0
 */
@Getter
public class SimpleSurrogateAuthenticationServiceTests extends BaseSurrogateAuthenticationServiceTests {
    private final SurrogateAuthenticationService service = new SimpleSurrogateAuthenticationService(
            CollectionUtils.wrap("casuser", CollectionUtils.wrapList("banderson")));
}
