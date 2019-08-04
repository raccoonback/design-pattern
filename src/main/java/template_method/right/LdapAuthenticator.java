package template_method.right;

/**
 * Created by koseungbin on 2019-08-03
 */

public class LdapAuthenticator extends Authenticator {
    private LdapClient ldapClient;

    public LdapAuthenticator(LdapClient ldapClient) {
        this.ldapClient = ldapClient;

    }

    @Override
    protected boolean doAuthenticate(String id, String pw) {
        return ldapClient.authenticate(id, pw);

    }

    @Override
    protected Auth createAuth(String id, String pw) {
        LdapContext context = ldapClient.find(id);
        return new Auth(context.getAttribute("id"), pw);

    }

}
