package template_method.wrong;

/**
 * Created by koseungbin on 2019-08-04
 */

public class LdapContext {
    private String vmDir;

    public LdapContext(String id) {
        vmDir = id;

    }

    public String getAttribute(String id) {
        return vmDir;

    }

}
