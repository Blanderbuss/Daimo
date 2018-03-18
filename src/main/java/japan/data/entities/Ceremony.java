package japan.data.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQuery(name="Ceremonies.findAll", query="SELECT e FROM Ceremony e")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name="ceremonies")
public class Ceremony {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;
    private String name;
    private double importance;
    @OrderBy("name DESC")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="visited",
        joinColumns = @JoinColumn(name="ceremony_id"),
            inverseJoinColumns = @JoinColumn(name="samurai_id"))
    private List<DbSamurai> visitors;

    public List<DbSamurai> getVisitors() {
        return visitors;
    }

    public void setVisitors(List<DbSamurai> visitors) {
        this.visitors = visitors;
    }
    //Getters and settings

    public Ceremony() {
    }

    @Override
    public String toString() {
        return "Ceremony{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", importance=" + importance +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getImportance() {
        return importance;
    }

    public void setImportance(double importance) {
        this.importance = importance;
    }
}
