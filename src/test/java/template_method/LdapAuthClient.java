package template_method;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import template_method.right.Auth;
import template_method.right.LdapAuthenticator;
import template_method.right.LdapClient;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by koseungbin on 2019-08-04
 */

@DisplayName("Template Method Patten With LdapAuthenticator Test")
class LdapAuthClient {
    @Test
    void expect_exception_when_not_match_id() {
        // given
        LdapAuthenticator ldapAuthenticator = new LdapAuthenticator(new LdapClient());

        // when then
        assertThrows(Exception.class, () -> {
            ldapAuthenticator.authenticate("strange_id", "temp_pw");
        }, "expect id is 'temp_id'");

    }

    @Test
    void expect_exception_when_not_match_password() {
        // given
        LdapAuthenticator ldapAuthenticator = new LdapAuthenticator(new LdapClient());

        // when then
        assertThrows(Exception.class, () -> {
            ldapAuthenticator.authenticate("temp_id", "strange_pw");
        }, "expect pw is 'temp_pw'");

    }

    @Test
    void should_not_generate_exception_when_match() {
        // given
        LdapAuthenticator ldapAuthenticator = new LdapAuthenticator(new LdapClient());

        // when then
        assertDoesNotThrow(() -> {
            ldapAuthenticator.authenticate("temp_id", "temp_pw");
        }, "doesn't exception if match id and pw");

    }

    @Test
    void should_auth() throws Exception {
        // given
        LdapAuthenticator ldapAuthenticator = new LdapAuthenticator(new LdapClient());

        // when
        Auth auth = ldapAuthenticator.authenticate("temp_id", "temp_pw");

        // then
        assertEquals("temp_id", auth.getId(), "should match id with 'temp_id'");
        assertEquals("temp_pw", auth.getPw(), "should match pw with 'temp_pw'");

    }

}
