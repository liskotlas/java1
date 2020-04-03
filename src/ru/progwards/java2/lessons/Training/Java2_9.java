package ru.progwards.java2.lessons.Training;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class Java2_9 {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface AnnotationTest {
        String text() default "Всегда говори привет";
    }



    class Greetings {
        void hello() {}
        void goodday() {}
        @AnnotationTest
        void goodnight() {}
        void hi(){};
    }

    void printAnnotation(){
        Class aClass = Greetings.class;
        Method[] method = aClass.getDeclaredMethods();
        for (Method m : method){
            if(m.getDeclaredAnnotation(AnnotationTest.class) != null) {
                System.out.println(m.getName() + " " + m.getDeclaredAnnotation(AnnotationTest.class).text());
            }
        }
    }

    public static void main(String[] args) {
        new Java2_9().printAnnotation();
    }
}
