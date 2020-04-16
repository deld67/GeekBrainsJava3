package lesson7;


import java.lang.reflect.Method;

public class TestClass {
    private static myClass myClass = null;

    public TestClass() {
    }

    @BeforeSuite
    public void initProcess(){
       System.out.println("Init class myClass");
       myClass = new myClass();
    }

    @Test( priority = 10,   args = {1,2}, result = 3)
    public boolean test1(){
        return checkBody("test1");
    }


    @Test( priority = 1,   args = {3,4}, result = 7)
    public boolean  test2(){
        return checkBody("test2");
    }

    @AfterSuite
    public void finalProcess(){
        myClass = null;
        System.out.println("Class myClass is free");
    }


    private boolean checkBody(String methodName) {
        int[] args;
        int result;

        try {
            Method m = this.getClass().getMethod( methodName);
            Test annotation = m.getAnnotation( Test.class );
            args = annotation.args();
            result = annotation.result();
            if (args.length < 2) return false;
            return  result == myClass.sumInt( args[0],args[1]);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return false;
        }
    }
}
