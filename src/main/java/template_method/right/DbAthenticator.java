package template_method.right;

/**
 * Created by koseungbin on 2019-08-03
 */

public class DbAthenticator extends Authenticator {
    private UserDao userDao;

    public DbAthenticator(UserDao userDao) {
        this.userDao = userDao;

    }

    @Override
    protected boolean doAuthenticate(String id, String pw) {
        User user = userDao.selectById(id);
        return user.equalPassword(pw);

    }

    @Override
    protected Auth createAuth(String id, String pw) {
        return new Auth(id, pw);

    }

    @Override
    protected boolean validate(String id, String pw) {
        return id.startsWith("_") && pw.endsWith("_");

    }

}
