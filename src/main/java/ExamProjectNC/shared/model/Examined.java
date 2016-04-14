package ExamProjectNC.shared.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="examined", uniqueConstraints = @UniqueConstraint(columnNames={"examined_id"}))

public class Examined implements java.io.Serializable {

    //used during deserialization for verifying class version and etc.
    private static final long serialVersionUID = 6337148546446600161L;

    //mapping for 'users' table
    @ManyToOne
    @JoinColumn(name = "user_id",
            foreignKey = @ForeignKey(name = "EXAMINED_TO_USER_ID_FK"))
    private User user;

    //mapping for 'groups' table
    @ManyToOne
    @JoinColumn(name = "group_id",
            foreignKey = @ForeignKey(name = "EXAMINED_TO_GROUP_ID_FK"))
    private Group group;

    //mappings for 'examined' table columns
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="examined_id", nullable= false, unique=true)
    private int examined_id;

    @Column(name="examined_group_id", nullable = false)
    private int examined_group_id;

    @Column(name="student_id", nullable = false)
    private int student_id;

    @Column(name="examined_mark", nullable = false)
    private float examined_mark;

    @Column(name="examined_answer_time", nullable = false)
    private Timestamp examined_answer_time;

    //Constructors
    public Examined() {
    }

    public Examined(int student_id, int examined_group_id, float examined_mark, Timestamp examined_answer_time) {
        this.student_id = student_id;
        this.examined_group_id = examined_group_id;
        this.examined_mark = examined_mark;
        this.examined_answer_time = examined_answer_time;
    }

    //Getters and Setters
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

    public void setExamined_answer_time(Timestamp examined_answer_time) { this.examined_answer_time = examined_answer_time; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public Group getGroup() { return group; }

    public void setGroup(Group group) { this.group = group; }

    //For testing
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
