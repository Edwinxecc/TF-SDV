package ec.edu.uce.dominio;

public class User {
    private String userName;
    private int age;
    private String password;

    public User(String userName, int age, String password){
        this.userName = userName;
        this.age = age;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public int getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return userName + ":" + age;
    }
}
