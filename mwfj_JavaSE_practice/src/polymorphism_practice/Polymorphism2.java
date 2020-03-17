package polymorphism_practice;
class Parent{

    int x=10; 
    int k =20;
    public Parent(){ 
         add(2); 
    } 
    void add(int y){ 
         x+=y; 
    } 
}

class Child extends Parent{ 
    int x=9; 
    int k =19;
    void add(int y){ 
         x+=y; 
    } 

}
public class Polymorphism2 {
    public static void main(String[] args){ 
        Parent p=new Child(); 
        System.out.println(p.x); 
        System.out.println(p.k);
   }   
}
/*
 *      Child对象的初始化过程是： 
     首先    为父类的实例变量x分配内存空间，因为在定义变量x时为它赋了值(int x=10),所以会同时将这个值赋给x。 
     其次    调用父类的无参构造函数，Parent的构造函数中做的唯一的事情就是调用了add(2); 
     第三、由于子类的add(int y)方法覆盖了父类的方法，所以add(2)实际调用的是子类的方法，
     			在子类的add方法中做了如下操作x+=j;在这里由于子类的实例变量x隐藏了父类的实例变量x，
     			所以这条语句是针对子类本身的，但是这时还没有为子类的实力变量x分配空间，它的默认值是0，加2之后是2。 
     第四、父类初始化完毕后接着初始化子类，为子类的x分配内存空间并将它赋值为9，之前的add(2)操作白瞎了。 
     			再次注意Parent p=new Child();这条语句，它是用父类的引用指向子类的对象，
     			而前面已经说过变量只会被隐藏不会被覆盖，所以这时的p.x值应该是父类的10，而不是子类的9； 
     如果将输出语句换成下面的语句结果就是9了： 
     System.out..println(((Child)p).x); //首先将p转换成Child类型
*/
