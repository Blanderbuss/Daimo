package japan.data.entities;

import japan.Weapon;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="samurai")
public class DbSamurai {
    @Id
    @GeneratedValue
    @Column(name = "idSamurai")
    private int samuraiId;
    private String name;
    @ManyToMany(mappedBy = "visitors")
    private List<Ceremony> visiting;
    @OrderBy("name DESC")
    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "weapon", nullable = false)
    private DbWeapon weapon;

    @Override
    public String toString() {
        return "{Samurai " + name +
                '}';
    }

    public List<Ceremony> getVisiting() {
        return visiting;
    }

    public void setVisiting(List<Ceremony> visiting) {
        this.visiting = visiting;
    }

    public DbWeapon getWeapon() {

        return weapon;
    }

    public void setWeapon(DbWeapon weapon) {
        this.weapon = weapon;
    }

    public DbSamurai(String name) {

        this.name = name;
    }

    public DbSamurai() {
    }


    public int getSamuraiId() {
        return samuraiId;
    }

    public void setSamuraiId(int samuraiId) {
        this.samuraiId = samuraiId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
