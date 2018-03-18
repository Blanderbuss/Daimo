import japan.Samurai;
import japan.data.DbSamurai;
import japan.data.entities.DbWeapon;
import japan.worker.WorkWithSamurais;
import japan.worker.WorkWithWeapon;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;
import java.time.LocalDate;

import static java.sql.Date.*;

public class Main {

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        Samurai hanzo = (Samurai)context.getBean("hanzo");
        hanzo.hello();
        hanzo.sepuku();

        WorkWithSamurais worker =
                (WorkWithSamurais) context.getBean("worker");
        //new WorkWithSamurais();
        DbSamurai testSamurai = new DbSamurai("Vitaliy Valt", 5);
        //worker.saveSamuraiToDb(testSamurai);
        WorkWithWeapon workWithWeapon =
                (WorkWithWeapon) context.getBean("weaponWorker");
        DbWeapon weapon = new DbWeapon();
        weapon.setName("Chetsu");
        weapon.setStrength(5);
        weapon.setCreation_date(new Date(1,1,1));
        weapon = workWithWeapon.addWeapon(weapon);
        weapon.setCreation_date(new Date(2,2,2));
        workWithWeapon.saveWeapon(weapon);
    }
}
