import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2018/4/17.
 */
public class Test {
    @org.junit.Test
    public void test(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-context.xml");
        HelloWorld helloWorld = (HelloWorld)ac.getBean("helloWorld");
        helloWorld.say();
    }
}
