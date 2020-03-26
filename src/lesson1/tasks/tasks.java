package lesson1.tasks;

import java.util.ArrayList;

public class tasks<T> {
    private T[] objList;

    public tasks(T[] objList){
        this.objList = objList;
    }

    public void changeEl(int from, int to){
        T obj;
        if (from > objList.length || from < 0){
            System.out.println("Начальный номер элемена массива для изменения выходит за границы массива");
            return;
        }
        if (to > objList.length || to < 0){
            System.out.println("Конечный номер элемена массива для изменения выходит за границы массива");
            return;
        }
        obj = objList[to];
        objList[to] = objList[from];
        objList[from] = obj;

    }
    public ArrayList<T> arrayToArrayList(){
        ArrayList<T> myArrayList = new ArrayList<T>();
        for (T elList: objList) {
           myArrayList.add(elList);
        }
        return myArrayList;
    }

    public void printArray(){
        for (T elList: objList) {
            System.out.printf("%s ", elList);
        }
        System.out.printf("%n");
    }

}
