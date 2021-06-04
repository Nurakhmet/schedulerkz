package kz.matanov.schedulerkz.entities;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "t_tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "taskText")
    private String taskText;

    @Column(name = "toDateExp")
    @Temporal(TemporalType.DATE)
    private Date toDateExp;


    @Column(name = "done")
    private boolean done;

    @ManyToOne(fetch = FetchType.EAGER)
    private Users users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskText() {
        return taskText;
    }

    public void setTaskText(String taskText) {
        this.taskText = taskText;
    }

    public Date getToDateExp() {
        return toDateExp;
    }

    public void setToDateExp(Date toDateExp) {
        this.toDateExp = toDateExp;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
