package model;

import javax.persistence.*;

@Entity
@Table(name="groups", uniqueConstraints = @UniqueConstraint(columnNames={"group_id"}))

public class Group {

    //Cвязь с таблицами exams и examined;
    /*
    @OneToMany
    @JoinColumns({
            @JoinColumn(name = "group_id"),
            @JoinColumn(name = "group_id")
    })
    private Exam exam; private Examined examined;
    */

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="group_id", nullable= false, unique=true)
    private int group_id;

    @Column(name="group_name", nullable = false, length=355)
    private String group_name;

    public Group() {
    }
    public Group(String group_name) {
        this.group_name = group_name;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }


    /*
    Для тестов на этапе работы консольного приложения
     */
    @Override
    public String toString() {
        return "Group{" +
                "group_id=" + group_id +
                ", group_name='" + group_name + '\'' +
                '}';
    }
}
