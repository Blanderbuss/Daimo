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

        // THIS IS NEW

        Ceremony ceremony = new Ceremony();
        ceremony.setName("Tea ceremony");
        ceremony.setImportance(9000);

        WorkWithCeremonies workerCeremonies = (WorkWithCeremonies) context.getBean("workerCeremonies");
        //Uncomment to check
        //workerCeremonies.addCeremony(ceremony);
        System.out.println("List of all ceremonies:");
        for(Ceremony c:workerCeremonies.getAllCeremonies()){
            System.out.println(c);
            System.out.println(c.getVisitors());
        };

        //END OF NEW

        WorkWithSamurais workerSamurai =
                (WorkWithSamurais) context.getBean("workerSamurai");
        new WorkWithSamurais();
        DbSamurai testSamurai = new DbSamurai("Vitaliy Wut");
        //Uncomment to check
        //.saveSamuraiToDb(testSamurai);
        WorkWithWeapon workWithWeapon =
                (WorkWithWeapon) context.getBean("weaponWorker");
        DbWeapon weapon = new DbWeapon();
        weapon.setName("Dretsu");
        weapon.setStrength(5);
        weapon.setCreation_date(new Date(1,1,1));
        //Uncomment to check
        //weapon = workWithWeapon.addWeapon(weapon);
        weapon.setCreation_date(new Date(2,2,2));
        //Uncomment to check
        //workWithWeapon.saveWeapon(weapon);
    }
}
