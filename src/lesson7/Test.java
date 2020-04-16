package lesson7;

import java.lang.annotation.*;

@Retention( RetentionPolicy.RUNTIME )
@Target( ElementType.METHOD )
public @interface Test {
    int priority() default 0;
    int[] args();
    int result() default 0;

}

