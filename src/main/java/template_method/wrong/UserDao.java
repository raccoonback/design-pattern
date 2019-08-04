package template_method.wrong;

/**
 * Created by koseungbin on 2019-08-03
 */

public class UserDao {
    public User selectById(String id) {
        return new User(id, "temp_pw");

    }

}
