package japan.data.entities;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="WEAPON")
public class DbWeapon {
    @Id
    @GeneratedValue
    private int idWeapon;

    @Column(name="name")
    private String name;

    @Column(name="strength")
    private int strength;

    @Column(name="creation_date")
    private Date creation_date;

    public DbWeapon() {
    }

    public DbWeapon(String name, int strength, Date creation_date) {
        this.name = name;
        this.strength = strength;
        this.creation_date = creation_date;
    }

    public int getIdWeapon() {
        return idWeapon;
    }

    public void setIdWeapon(int idWeapon) {
        this.idWeapon = idWeapon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    @Override
    public String toString() {
        return "{Weapon " + name +
                " with strength=" + strength + " }";
    }
}
