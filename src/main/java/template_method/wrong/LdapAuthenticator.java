package template_method.wrong;

/**
 * Created by koseungbin on 2019-08-03
 */

public class LdapAuthenticator {
    private LdapClient ldapClient;

    public LdapAuthenticator(LdapClient ldapClient) {
        this.ldapClient = ldapClient;

    }

    public Auth authenticate(String id, String pw) throws Exception {
        boolean auth = ldapClient.authenticate(id, pw);
        if (!auth) {
            throw new Exception("has not auth");

        }

        LdapContext context = ldapClient.find(id);
        return new Auth(context.getAttribute("id"), pw);

    }

}
