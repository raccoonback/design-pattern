package template_method;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import template_method.right.Auth;
import template_method.right.DbAthenticator;
import template_method.right.UserDao;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Created by koseungbin on 2019-08-04
 */

@DisplayName("Template Method Patten With DbAuthenticator Test")
class DbAuthClient {
    @Test
    void expect_exception_when_invalid_id() {
        // given
        DbAthenticator dbAthenticator = new DbAthenticator(new UserDao());

        // when then
        assertThrows(Exception.class, () -> {
            dbAthenticator.authenticate("temp_id", "temp_pw");
        }, "expect id that start with underscore(_)");

    }

    @Test
    void expect_exception_when_invalid_password() {
        // given
        DbAthenticator dbAthenticator = new DbAthenticator(new UserDao());

        // when then
        assertThrows(Exception.class, () -> {
            dbAthenticator.authenticate("temp_id", "temp_pw");
        }, "expect password that end with underscore(_)");

    }

    @Test
    void expect_exception_when_not_match_password() {
        // given
        DbAthenticator dbAthenticator = new DbAthenticator(new UserDao());

        // when then
        assertThrows(Exception.class, () -> {
            dbAthenticator.authenticate("_temp_id", "strange_pw_");
        }, "expect password is 'temp_pw_'");

    }

    @Test
    void should_not_generate_exception_when_match() {
        // given
        DbAthenticator dbAthenticator = new DbAthenticator(new UserDao());

        // when then
        assertDoesNotThrow(() -> {
            dbAthenticator.authenticate("_temp_id", "temp_pw_");
        }, "doesn't exception if match id and pw");

    }

    @Test
    void should_auth() throws Exception {
        // given
        DbAthenticator dbAthenticator = new DbAthenticator(new UserDao());

        // when
        Auth auth = dbAthenticator.authenticate("_temp_id", "temp_pw_");

        // then
        assertEquals("_temp_id", auth.getId(), "should match id with '_temp_id'");
        assertEquals("temp_pw_", auth.getPw(), "should match pw with 'temp_pw_'");

    }

}
