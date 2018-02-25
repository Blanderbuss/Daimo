package japan;

import org.aspectj.lang.annotation.After;
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

    @Pointcut("execution(* japan.Samurai.hello(..))")
    public void hello(){}

    @Pointcut("execution(* japan.Samurai.sepuku(..))")
    public void sepuku() {}

    @Before("hello()")
    public void sharpenSword(){
        System.out.println("BORSCH BREAKPOINT. before hello method");
    }

    @After("sepuku()")
    public void afterSepuku() {
        System.out.println("BORSCH BREAKPOINT. after sepuku method");
    }
}
