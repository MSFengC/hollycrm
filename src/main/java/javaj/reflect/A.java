package javaj.reflect;

public class A {
    public String name;
    private int age;

    public A(){};

    public A(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    private void setPrivate(){}

    public void setName(String name){
        this.name = name;
    }
}
