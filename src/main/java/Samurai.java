import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

public class Samurai {
    private String name;
    private Weapon weapon;

    public Samurai(){

    }

    public Samurai(String name, Weapon weapon) {
        this.name = name;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    @Autowired
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void hello(){
        System.out.println("Samurai " + name + " killed you with " + weapon);
    }

    public void sepuku(){
        System.out.println("Samurai " + name + " have cut through his stomach");
    }
}
