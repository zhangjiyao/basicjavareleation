package designPattern.prototypeMode;

import java.io.*;

/**
 * @program: basicjavareleation
 * @description: prototype mode test cli
 * @author: jiyao
 * @create: 2022-09-18 20:12
 **/
public class Client {
    public static void main(String[] args)  {

        try {
//            shallowClone();
            deepClone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static void shallowClone() throws CloneNotSupportedException{
        Student student = new Student();
        student.setName("xiao");
        PrototypeTest pro = new PrototypeTest();
        pro.setStu(student);
        pro.setpName("frs");

        PrototypeTest clone = pro.clone();
        clone.getStu().setName("xiang");
        clone.setpName("ss");

        System.out.println(pro.toString());
        System.out.println(clone.toString());
    }

    public static void deepClone() throws Exception{
        Student student = new Student();
        student.setName("xiao");
        PrototypeTest pro = new PrototypeTest();
        pro.setStu(student);
        pro.setpName("frs");

        String path = "/Users/zhangjiyao/IdeaProjects/learn/basicjavareleation/basicjavareleation/write/prototype/test1.txt";
        ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream(path));
        outputStream.writeObject(pro);
        outputStream.flush();
        outputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
        PrototypeTest clone = (PrototypeTest) objectInputStream.readObject();
        objectInputStream.close();
        clone.getStu().setName("dfasd");
        clone.setpName("zcxv");

        System.out.println(pro.toString());
        System.out.println(clone.toString());
    }

}
