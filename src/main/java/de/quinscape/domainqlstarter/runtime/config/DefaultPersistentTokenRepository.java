package de.quinscape.domainqlstarter.runtime.config;

import de.quinscape.domainqlstarter.domain.tables.pojos.AppLogin;
import org.jooq.DSLContext;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import static de.quinscape.domainqlstarter.domain.Tables.*;

/**
 * Persistent Token repository based on the app_user table
 */
public class DefaultPersistentTokenRepository
    implements PersistentTokenRepository
{
    private final DSLContext dslContext;


    public DefaultPersistentTokenRepository(DSLContext dslContext)
    {
        this.dslContext = dslContext;
    }


    public void createNewToken(PersistentRememberMeToken token)
    {

        AppLogin login = new AppLogin();
        login.setUsername(token.getUsername());
        login.setToken(token.getTokenValue());
        login.setSeries(token.getSeries());
        login.setLastUsed(new Timestamp(token.getDate().getTime()));

        dslContext.executeUpdate(dslContext.newRecord(APP_LOGIN, login));
    }


    public void updateToken(String series, String tokenValue, Date lastUsed)
    {
        final AppLogin login = findLoginForSeries(series);

        if (login == null)
        {
            throw new IllegalStateException("No token found for series " + series);
        }
        
        login.setToken(tokenValue);
        login.setLastUsed(new Timestamp(lastUsed.getTime()));
    }


    private AppLogin findLoginForSeries(String series)
    {
        final List<AppLogin> logins = dslContext.select()
            .from(APP_LOGIN)
            .where(
                APP_LOGIN.SERIES.eq(series)
            )
            .fetchInto(AppLogin.class);

        if (logins.size() != 1)
        {
            return null;
        }

        return logins.get(0);
    }


    /**
     * Loads the token data for the supplied series identifier.
     * <p>
     * If an error occurs, it will be reported and null will be returned (since the result
     * should just be a failed persistent login).
     *
     * @param seriesId      unique series identifier
     * @return the token matching the series, or null if no match found or an exception
     * occurred.
     */
    public PersistentRememberMeToken getTokenForSeries(String seriesId)
    {

        final AppLogin login = findLoginForSeries(seriesId);
        if (login == null)
        {
            throw new IllegalStateException("No login for series " + seriesId);
        }
        
        return new PersistentRememberMeToken(
            login.getUsername(),
            login.getSeries(),
            login.getToken(),
            login.getLastUsed()
        );
    }


    public void removeUserTokens(String username)
    {
        dslContext.deleteFrom(APP_LOGIN).where(APP_LOGIN.USERNAME.eq(username));
    }
}
