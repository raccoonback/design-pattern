package template_method.wrong;

/**
 * Created by koseungbin on 2019-08-03
 */

public class DbAthenticator {
    private UserDao userDao;

    public DbAthenticator(UserDao userDao) {
        this.userDao = userDao;

    }

    public Auth authenticate(String id, String pw) throws Exception {
        User user = userDao.selectById(id);
        boolean auth = user.equalPassword(pw);
        if (!auth) {
            throw new Exception("has not auth");

        }

        return new Auth(id, pw);

    }

}
