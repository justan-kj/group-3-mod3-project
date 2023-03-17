package sg.edu.ntu.m3project.m3project.entity;

public class User {
    private String email;
    private String password;
    private int age;
    private int gender;

    public User(String email, String password, int age, int gender) {
        this.email = email;
        this.password = password;
        this.age = age;
        this.gender = gender;
    }
     
    // getters and setters

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}    