package model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="examined", uniqueConstraints = @UniqueConstraint(columnNames={"examined_id"}))

public class Examined {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="examined_id", nullable= false, unique=true)
    private int examined_id;


    //Cвязь с таблицей users
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name="student_id", nullable = false)
    private int student_id;


    //Связь с таблицей groups
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;


    @Column(name="examined_group_id", nullable = false)
    private int examined_group_id;

    @Column(name="examined_mark", nullable = false)
    private float examined_mark;

    @Column(name="examined_answer_time", nullable = false)
    private Timestamp examined_answer_time;

    public Examined() {
    }
    public Examined(int student_id, int examined_group_id, float examined_mark, Timestamp examined_answer_time) {
        this.student_id = student_id;
        this.examined_group_id = examined_group_id;
        this.examined_mark = examined_mark;
        this.examined_answer_time = examined_answer_time;
    }

    public int getExamined_id() {
        return examined_id;
    }

    public void setExamined_id(int examined_id) {
        this.examined_id = examined_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getExamined_group_id() {
        return examined_group_id;
    }

    public void setExamined_group_id(int examined_group_id) {
        this.examined_group_id = examined_group_id;
    }

    public float getExamined_mark() {
        return examined_mark;
    }

    public void setExamined_mark(float examined_mark) {
        this.examined_mark = examined_mark;
    }

    public Timestamp getExamined_answer_time() {
        return examined_answer_time;
    }

    public void setExamined_answer_time(Timestamp examined_answer_time) {
        this.examined_answer_time = examined_answer_time;
    }
    /*
    Для тестов на этапе работы консольного приложения
     */
    @Override
    public String toString() {
        return "Examined{" +
                "examined_id=" + examined_id +
                ", student_id=" + student_id +
                ", examined_group_id=" + examined_group_id +
                ", examined_mark='" + examined_mark + '\'' +
                ", examined_answer_time='" + examined_answer_time + '\'' +
                '}';
    }
}
