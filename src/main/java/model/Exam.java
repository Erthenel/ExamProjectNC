package model;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name="exams", uniqueConstraints = @UniqueConstraint(columnNames={"exam_id"}))

public class Exam {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="exam_id", nullable= false, unique=true)
    private int exam_id;

    //Foreign Key candidate
    @Column(name="teacher_id", nullable = false)
    private int teacher_id;

    //Foreign Key candidate
    @Column(name="group_id", nullable = false)
    private int group_id;

    @Column(name="exam_theme", nullable = false, length=355)
    private String exam_theme;

    @Column(name="exam_date", nullable = false)
    private Date exam_date;

    @Column(name="exam_subject", nullable = false, length = 355)
    private String exam_subject;

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

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
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
}
