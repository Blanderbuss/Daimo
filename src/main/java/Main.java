import japan.data.entities.Ceremony;
import japan.data.entities.DbSamurai;
import japan.data.entities.DbWeapon;
import japan.worker.WorkWithCeremonies;
import japan.worker.WorkWithSamurais;
import japan.worker.WorkWithWeapon;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;

public class Main {

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        /*
        Samurai hanzo = (Samurai)context.getBean("hanzo");
        hanzo.hello();
        hanzo.sepuku();*/

        // THIS IS 6

        Ceremony ceremony = new Ceremony();
        ceremony.setName("Tea ceremony");
        ceremony.setImportance(9000);

        WorkWithCeremonies workerCeremonies = (WorkWithCeremonies) context.getBean("workerCeremonies");
        //Uncomment to check
        //workerCeremonies.addCeremony(ceremony);
        System.out.println("-----------------List of all ceremonies(with visitors and their weapons)[Named query]:-----------------");
        for(Ceremony c:workerCeremonies.getAllCeremonies()){
            System.out.print(c + " who has ");
            System.out.println(c.getVisitors());
        };

        //END OF 6

        System.out.println("-----------------List of popular ceremonies[JPQL]:-----------------");
        System.out.println(workerCeremonies.getPopular());

        WorkWithSamurais workerSamurai =
                (WorkWithSamurais) context.getBean("workerSamurai");
        DbSamurai testSamurai = new DbSamurai("Vitaliy Wut");
        //Uncomment to check
        //workerSamurai.saveSamuraiToDb(testSamurai);

        WorkWithWeapon workWithWeapon =
                (WorkWithWeapon) context.getBean("weaponWorker");
        DbWeapon weapon = new DbWeapon();
            weapon.setName("Dretsu");
            weapon.setStrength(5);
            weapon.setCreation_date(new Date(1,1,1));

        //CHECKING CACHE
        System.out.println("-----------------Cache check started-----------------");
        System.out.println(workWithWeapon.getWeaponById(1));
        System.out.println(workWithWeapon.getWeaponById(1));
        System.out.println("-----------------Cache check finished-----------------");
        //Uncomment to check
        //weapon = workWithWeapon.addWeapon(weapon);
        weapon.setCreation_date(new Date(2,2,2));
        //Uncomment to check
        //workWithWeapon.saveWeapon(weapon);
    }
}
