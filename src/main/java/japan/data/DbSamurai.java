package japan.data;

public class DbSamurai {
    private int samuraiId;
    private String name;
    private int weapon;

    public DbSamurai() {
    }

    public DbSamurai(String name, int weapon) {
        this.name = name;
        this.weapon = weapon;
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

    public int getWeapon() {
        return weapon;
    }

    public void setWeapon(int weapon) {
        this.weapon = weapon;
    }
}
