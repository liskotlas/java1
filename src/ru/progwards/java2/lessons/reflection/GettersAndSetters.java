package ru.progwards.java2.lessons.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class GettersAndSetters {

    public static void check(String clazz) throws ClassNotFoundException {

        Class clazz1 = Class.forName(clazz);

        Field[] fields = clazz1.getDeclaredFields();

        Method[] methods = clazz1.getDeclaredMethods();

        for (Field field : fields) {
            boolean setter = false;
            boolean getter = false;
            for (Method method : methods) {

                if (method.getModifiers() == 1 && method.getName().toLowerCase().contains("set" + field.getName().toLowerCase()) && method.getParameterCount() == 1) {
                    Parameter[] methodParameters = method.getParameters();
                    for (Parameter parameter : methodParameters) {
                        if (parameter.getType() == field.getType()) {
                            setter = true;
                            break;
                        }
                    }
                }
                if (method.getModifiers() == 1 && method.getName().toLowerCase().contains("get" + field.getName().toLowerCase())) {
                    getter = true;
                }
            }
            if (!setter) {
                System.out.println("public void set" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1) + "(" + field.getType().getSimpleName() + " " + field.getName() + ")");
            }

            if (!getter) {
                System.out.println("public " + field.getType().getSimpleName() + " get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1) + "()");
            }

        }
    }
}