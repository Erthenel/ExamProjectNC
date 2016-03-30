package model;

import javax.persistence.*;

@Entity
@Table(name="groups", uniqueConstraints = @UniqueConstraint(columnNames={"group_id"}))

public class Group {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="group_id", nullable= false, unique=true)
    private int group_id;

    @Column(name="group_name", nullable = false, length=355)
    private String group_name;

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
}
