package template_method.wrong;

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
        return pw.equals("temp_pw");

    }

}
