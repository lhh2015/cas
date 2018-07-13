package org.apereo.cas.authentication.surrogate;

import org.apereo.cas.authentication.principal.Principal;
import org.apereo.cas.authentication.principal.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * This is {@link BaseSurrogateAuthenticationService}.
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@Slf4j
@RequiredArgsConstructor
public abstract class BaseSurrogateAuthenticationService implements SurrogateAuthenticationService {
    @Override
    public final boolean canAuthenticateAs(final String surrogate, final Principal principal, final Service service) {
        return canAuthenticateAsInternal(surrogate, principal, service);
    }

    /**
     * Can principal authenticate as surrogate.
     *
     * @param surrogate the surrogate
     * @param principal the principal
     * @param service   the service
     * @return the boolean
     */
    protected abstract boolean canAuthenticateAsInternal(String surrogate, Principal principal, Service service);
}
