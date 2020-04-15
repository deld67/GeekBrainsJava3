package lesson1.tasks;

import java.util.ArrayList;
import java.util.Collection;

public class Box <T extends Fruit> {
    ArrayList<T> fruitPlace = new ArrayList<T>();

    public void addFruit(T obj){
        fruitPlace.add(obj);
    }

    public void addFruits(ArrayList<T> fruits){
        fruitPlace.addAll(fruits);
    }

    public double getWeight(){
        for (T objFruit: fruitPlace) {
            return  fruitPlace.size()*objFruit.getOneFruitWeight();
        }
        return 0;
    }

    public boolean compare(Box<?> xBox){
        if (this.getWeight() == xBox.getWeight()) return  true;
        return false;
    }

    public void putFruitToNewBox(Box<T> xBox){
        if (fruitPlace.size() == 0){
            System.out.println("Sorry, this box is empty.");
            return;
        }
        if (this.getClass() != xBox.getClass()) {
            System.out.printf("I do`nt put %s into the %s box.%n",this.fruitPlace.getClass(), xBox.getClass());
            return;
        }
        xBox.addFruits(fruitPlace);
        fruitPlace.clear();
    }
}
