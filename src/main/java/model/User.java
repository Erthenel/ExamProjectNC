package model;

import javax.persistence.*;

@Entity
@Table(name="users", uniqueConstraints={@UniqueConstraint(columnNames={"user_email","user_id"})})

public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="user_id", unique = true, nullable = false)
    private int user_id;

    //Связь с таблицами exams и examined

    /*@OneToMany
    @JoinColumn(name="teacher_id")
    private Exam exam;

    @OneToMany
    @JoinColumn(name="student_id")
    private User user;
    */

    @Column(name="user_email", length=355, nullable=false,unique = true)
    private String user_email;

    @Column(name="user_password", length=50, nullable=false)
    private String user_password;

    @Column(name="user_fullName", length=355, nullable=false)
    private String user_fullName;

    @Column(name="user_role", nullable=false)
    private int user_role;

    public User() {
    }
    public User(String user_email, String user_password, String user_fullName, int user_role) {
        this.user_email = user_email;
        this.user_password = user_password;
        this.user_fullName = user_fullName;
        this.user_role = user_role;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_fullName() {
        return user_fullName;
    }

    public void setUser_fullName(String user_fullName) {
        this.user_fullName = user_fullName;
    }

    public int getUser_role() {
        return user_role;
    }

    public void setUser_role(int user_role) {
        this.user_role = user_role;
    }

    /*
    Для тестов на этапе работы консольного приложения
     */
    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_email=" + user_email +
                ", user_password=" + user_password +
                ", user_fullName='" + user_fullName + '\'' +
                ", user_role='" + user_role + '\'' +
                '}';
    }
}
