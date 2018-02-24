import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        Samurai hanzo = (Samurai)context.getBean("hanzo");
        hanzo.hello();
        hanzo.sepuku();
    }
}
