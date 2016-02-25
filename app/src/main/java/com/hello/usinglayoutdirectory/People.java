package com.hello.usinglayoutdirectory;

/**
 * Created by iwan on 16/2/26.
 */
public class People {

    private String name;
    private int age;


    //简单的单例模式
    private static People people;
    //给外部使用
    public static People getPeopleIntance(){

        if (people == null){
            people = new People();
        }
        return people;
    }





    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
