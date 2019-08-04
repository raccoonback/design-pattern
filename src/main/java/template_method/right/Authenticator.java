package template_method.right;

/**
 * Created by koseungbin on 2019-08-03
 */

public abstract class Authenticator {
    public Auth authenticate(String id, String pw) throws Exception {
        if (!validate(id, pw)) {
            throw new Exception("id, pw is Invalid");

        }

        if (!doAuthenticate(id, pw)) {
            throw new Exception("has not authentication");

        }

        return createAuth(id, pw);

    }

    protected abstract boolean doAuthenticate(String id, String pw);

    protected abstract Auth createAuth(String id, String pw);

    protected boolean validate(String id, String pw) {
        return true;

    }

}
