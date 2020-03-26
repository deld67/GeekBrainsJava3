package lesson1;

import lesson1.tasks.Apple;
import lesson1.tasks.Box;
import lesson1.tasks.Orange;
import lesson1.tasks.tasks;

import java.util.Random;

public class homework {
    public static void main(String[] args) {
        System.out.println("======================Задание 1======================");
        tasks<Integer> nums = new tasks<>(new  Integer[]{1,2,3,4,5,6,7,8,9,0});
        nums.printArray();
        nums.changeEl(3,7);
        nums.printArray();
        nums.changeEl(-1,100);
        tasks<String> str = new tasks<>(new  String[]{"первый", "второй","третий","четвертый","пятый"});
        str.printArray();
        str.changeEl(3,0 );
        str.printArray();
        str.changeEl(-1,100);
        System.out.println("======================Задание 2======================");
        System.out.println(nums.arrayToArrayList());
        System.out.println(str.arrayToArrayList());
        System.out.println("======================Задание 3======================");
        Box<Orange> orangeBox1 = new Box<Orange>();
        Orange orange = new Orange();
        orangeBox1.addFruit(orange);
        System.out.printf("Current weight Box (orangeBox1) %s%n", orangeBox1.getWeight());
        System.out.println("Add random orange into new Box (orangeBox2)");
        Box<Orange> orangeBox2 = new Box<Orange>();
        for (int i = 0; i < new Random().nextInt(10); i++) {
            orangeBox2.addFruit(orange);
        }
        System.out.printf("Current weight orangeBox2 %s%n", orangeBox2.getWeight());
        Box<Apple> appleBox1 = new Box<Apple>();
        Apple apple = new Apple();
        appleBox1.addFruit(apple);
        System.out.printf("Current weight Box(appleBox1) %s%n", appleBox1.getWeight());
        System.out.println("Add random apple into new Box (appleBox2)");
        Box<Apple> appleBox2 = new Box<Apple>();
        for (int i = 0; i < new Random().nextInt(10); i++) {
            appleBox2.addFruit(apple);
        }
        System.out.printf("Current weight appleBox2 %s%n", appleBox2.getWeight());
        System.out.printf("Is weight orangeBox1 == orangeBox2? %s%n ", orangeBox1.compare(orangeBox2));
        System.out.printf("Is weight orangeBox1 == appleBox1? %s%n ", orangeBox1.compare(appleBox1));
        System.out.printf("Is weight orangeBox2 == appleBox2? %s%n ", orangeBox2.compare(appleBox2));
        System.out.println("Put apple from appleBox1 to appleBox2");
        System.out.printf("Weight appleBox2 before %s%n", appleBox2.getWeight());
        appleBox1.putFruitToNewBox(appleBox2);
        System.out.printf("Weight appleBox2 after %s%n", appleBox2.getWeight());
        System.out.println("Put orange from orangeBox1 to orangeBox2");
        System.out.printf("Weight orangeBox2 before %s%n", orangeBox2.getWeight());
        orangeBox1.putFruitToNewBox(orangeBox2);
        System.out.printf("Weight orangeBox2 after %s%n", orangeBox2.getWeight());
    }
}
