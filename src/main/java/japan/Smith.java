package japan;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Smith {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Smith(){}

    /*@Pointcut("execution(* japan.Samurai.hello(..))")
    public void hello(){}*/

    @Before("execution(* japan.Samurai.hello(..))")
    public void sharpenSword(){
        System.out.println("Smith have sharpened samurai`s sword");
    }
}
