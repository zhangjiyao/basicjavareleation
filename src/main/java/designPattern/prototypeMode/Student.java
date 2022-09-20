package designPattern.prototypeMode;

import java.io.Serializable;

/**
 * @program: basicjavareleation
 * @description:
 * @author: jiyao
 * @create: 2022-09-18 20:14
 **/
public class Student implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
