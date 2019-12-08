package erth.lab._lab_boot.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
@Data
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="task_id")
    private int id;
    @Column(name = "task_name")
    private String name;
    @Column(name = "owner")
    private String ownerName;
    @Column(name = "executor")
    private String executorName;
    @Column(name = "description")
    private String description;
    @Enumerated(EnumType.STRING)
    private Statuses status = Statuses.NEW;

    public Task(String name, String ownerName, String executorName, String description) {
        this.id = id;
        this.name = name;
        this.ownerName = ownerName;
        this.executorName = executorName;
        this.description = description;
    }

}
