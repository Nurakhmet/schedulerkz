package kz.matanov.schedulerkz.entities;



import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_tasks")

public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "taskText")
    private String taskText;

    @Column(name = "toDate")
    private Date toDate;

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

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
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
