public class UserDto {
    private String login;
    private int age;
    private String email;

    public UserDto(String login, int age, String email) {
        this.login = login;
        this.age = age;
        this.email = email;
    }

    public UserDto(User user){
        this.login = user.getLogin();
        this.age = user.getAge();
        this.email = user.getEmail();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "login='" + login + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
