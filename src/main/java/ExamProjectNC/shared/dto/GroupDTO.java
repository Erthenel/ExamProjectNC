package ExamProjectNC.shared.dto;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="groups", uniqueConstraints = @UniqueConstraint(columnNames={"group_id"}))

public class GroupDTO implements java.io.Serializable{

    //used during deserialization for verifying class version and etc.
    private static final long serialVersionUID = -7881815318423610722L;

    //mapping for 'exams' table
    @OneToMany(mappedBy = "group")
    private Set<ExamDTO> exams;

    //mapping for 'examined' table
    @OneToMany(mappedBy = "group")
    private Set<ExaminedDTO> examinees;

    //mappings for 'groups' table columns
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="group_id", nullable= false, unique=true)
    private int group_id;

    @Column(name="group_name", nullable = false, length=355)
    private String group_name;

    //Constructors
    public GroupDTO() {
    }

    public GroupDTO(String group_name) {
        this.group_name = group_name;
    }

    //Getters and Setters
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

    public Set<ExamDTO> getExams() { return exams; }

    public void setExams(Set<ExamDTO> exams) { this.exams = exams; }

    public Set<ExaminedDTO> getExaminees() { return examinees; }

    public void setExaminees(Set<ExaminedDTO> examinees) { this.examinees = examinees; }

    //For testing
    @Override
    public String toString() {
        return "GroupDTO{" +
                "group_id=" + group_id +
                ", group_name='" + group_name + '\'' +
                '}';
    }
}
