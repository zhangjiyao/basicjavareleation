package designPattern.prototypeMode;

import java.io.Serializable;

/**
 * @program: basicjavareleation
 * @description:
 * @author: jiyao
 * @create: 2022-09-18 20:16
 **/
public class PrototypeTest implements Cloneable , Serializable {
    private String pName;
    private Student stu;

    public PrototypeTest() {
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public void setStu(Student stu) {
        this.stu = stu;
    }

    public Student getStu() {
        return stu;
    }

    public String getpName() {
        return pName;
    }

    public PrototypeTest clone() throws CloneNotSupportedException {
        return (PrototypeTest) super.clone();
    }

    @Override
    public String toString() {
        return "PrototypeTest{" +
                "pName='" + pName + '\'' +
                ", stuName=" + stu.getName() +
                '}';
    }
}
