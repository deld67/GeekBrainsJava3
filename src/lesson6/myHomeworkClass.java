package lesson6;

public class myHomeworkClass {
    private static final int fndInt = 4;
    private static final int[] checkInt = new int[]{1,4};
    public int[] task1(int[] inputArray){
        int lastpos = inputArray.length;
        for (int i = 0; i < inputArray.length ; i++) {
            if (inputArray[i] == fndInt) lastpos = i;
        }
        int newArrLength = lastpos < inputArray.length ?  inputArray.length - lastpos-1 : 0;
        int[] retArray = new int[newArrLength];
        if (lastpos < inputArray.length){
            int j = 0;
            for (int i = lastpos+1; i < inputArray.length; i++) {
                retArray[j] = inputArray[i];
                j++;
            }

        }else{
            throw new RuntimeException();
        }
        return retArray;
    }

    public boolean testArray1or4(int[] inputArray){

        for (int i = 0; i < inputArray.length ; i++) {
            for (int j = 0; j < checkInt.length ; j++) {
                if (inputArray[i] == checkInt[j]) return true;
            }
        }
        return false;
    }

}
