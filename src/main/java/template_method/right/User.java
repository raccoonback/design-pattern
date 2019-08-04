package template_method.right;

/**
 * Created by koseungbin on 2019-08-03
 */

public class User {
    private String id;
    private String pw;

    public User(String id, String pw) {
        this.id = id;
        this.pw = pw;

    }

    public boolean equalPassword(String pw) {
        return "temp_pw_".equals(pw);

    }

}
