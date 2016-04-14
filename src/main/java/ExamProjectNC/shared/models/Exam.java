package ExamProjectNC.shared.models;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name="exams", uniqueConstraints = @UniqueConstraint(columnNames={"exam_id"}))

public class Exam implements java.io.Serializable {

    //used during deserialization for verifying class version and etc.
    private static final long serialVersionUID = 95293705767839389L;

    //mapping for 'users' table
    @ManyToOne
    @JoinColumn(name = "user_id",
            foreignKey = @ForeignKey(name = "EXAM_TO_USER_ID_FK")
    )
    private User user;

    //mapping for 'groups' table
    @ManyToOne
    @JoinColumn(name = "group_id",
            foreignKey = @ForeignKey(name = "EXAM_TO_GROUP_ID_FK")
    )
    private Group group;

    //mappings for 'exam' table columns
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="exam_id", nullable= false, unique=true)
    private int exam_id;

    @Column(name="teacher_id", nullable = false)
    private int teacher_id;

    @Column(name="exam_group_id", nullable = false)
    private int exam_group_id;

    @Column(name="exam_theme", nullable = false, length=355)
    private String exam_theme;

    @Column(name="exam_date", nullable = false)
    private Date exam_date;

    @Column(name="exam_subject", nullable = false, length = 355)
    private String exam_subject;

    //Constructors
    public Exam() {
    }

    public Exam(int teacher_id, int group_id, String exam_theme, Date exam_date, String exam_subject) {
        this.teacher_id = teacher_id;
        this.exam_group_id = group_id;
        this.exam_theme = exam_theme;
        this.exam_date = exam_date;
        this.exam_subject = exam_subject;
    }

    //Getters and Setters
    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public int getExam_id() {
        return exam_id;
    }

    public void setExam_id(int exam_id) {
        this.exam_id = exam_id;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getExam_theme() {
        return exam_theme;
    }

    public void setExam_theme(String exam_theme) {
        this.exam_theme = exam_theme;
    }

    public Date getExam_date() {
        return exam_date;
    }

    public void setExam_date(Date exam_date) {
        this.exam_date = exam_date;
    }

    public String getExam_subject() {
        return exam_subject;
    }

    public void setExam_subject(String exam_subject) {
        this.exam_subject = exam_subject;
    }

    public int getExam_group_id() { return exam_group_id; }

    public void setExam_group_id(int exam_group_id) { this.exam_group_id = exam_group_id; }

    public Group getGroup() { return group; }

    public void setGroup(Group group) { this.group = group; }

    //For testing
    @Override
    public String toString() {
        return "Exam{" +
                "exam_id=" + exam_id +
                ", teacher=" + teacher_id +
                ", group=" + exam_group_id +
                ", exam_theme='" + exam_theme + '\'' +
                ", exam_date=" + exam_date +
                ", exam_subject='" + exam_subject + '\'' +
                '}';
    }

}
