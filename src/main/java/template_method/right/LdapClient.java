package template_method.right;

/**
 * Created by koseungbin on 2019-08-03
 */

public class LdapClient {
    public LdapContext find(String id) {
        return new LdapContext(id);

    }

    public boolean authenticate(String id, String pw) {
        return "temp_id".equals(id) && "temp_pw".equals(pw);

    }

}
