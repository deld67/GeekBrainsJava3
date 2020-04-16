package lesson7;

import org.junit.experimental.categories.Category;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RunTests {




    public static void start(Class classForTest){
        Object obj = null;
        try {
            obj = classForTest.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        List<Method> BeforeSuiteMethods = getMethodsByAnnotation(BeforeSuite.class, classForTest);;
        List<Method> AfterSuiteMethods = getMethodsByAnnotation(AfterSuite.class, classForTest);;
        List<Method> TestMethods = getMethodsByAnnotation(Test.class, classForTest);;


        if (BeforeSuiteMethods.size() == 1 & AfterSuiteMethods.size() == 1){
            TestMethods = sortTestMethodsByPriority(TestMethods);

            try {
                BeforeSuiteMethods.get(0).invoke(obj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            for (Method m: TestMethods) {
                try {
                    System.out.printf(" Test %s is return %s%n", m.getName(), m.invoke(obj));

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            try {
                AfterSuiteMethods.get(0).invoke(obj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        }else{
            throw new RuntimeException("Error TestClass Structure");
        }



    }

    private static List<Method> sortTestMethodsByPriority(List<Method> testMethods) {

        for (int i = 0; i < testMethods.size() ; i++) {
            for (int j = i+1; j < testMethods.size() ; j++) {
                if (getMethodPriority(testMethods.get(i)) > getMethodPriority(testMethods.get(j))) {
                    Method m = testMethods.get(i);
                    testMethods.set(i, testMethods.get(j));
                    testMethods.set(j, m);
                }
            }
        }
        return testMethods;
    }

    private static int getMethodPriority(Method method) {
        return method.getAnnotation( Test.class ).priority();

    }

    private static List<Method> getMethodsByAnnotation(Class annotationClass, Class classForTest) {

        List<Method> retMethods = new ArrayList<Method>();
        Method[] methods = classForTest.getDeclaredMethods();

        for (Method m: methods) {
            if (m.getAnnotationsByType(annotationClass).length > 0 )
                retMethods.add(m);

        }
        return retMethods;
    }

    public static void main(String[] args) {
        System.out.println("Start Test by class ");
        start(TestClass.class);
        System.out.println("====================================");
    }
}
