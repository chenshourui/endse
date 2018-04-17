/**
 * Created by Administrator on 2018/4/17.
 */
public class HelloWorld {
    public String name;

    public void say(){
        System.out.println(this.getName()+": hello spring");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
