package ru.progwards.java2.lessons.reflection;


import java.lang.reflect.*;
import java.util.Arrays;

public class ClassInspector {

    public static void inspect(String clazz) throws ClassNotFoundException, NoSuchMethodException {


        Class clazz1 = Class.forName(clazz);
        String result = "";

        // Получение имени класса
        String resClass = "class " + clazz1.getSimpleName() + " {";
        System.out.println(resClass);

//Получение полей
        Field[] fields = clazz1.getDeclaredFields();

        Arrays.stream(fields).forEach(field -> {
            String resField = String.format("\t%s %s %s;", Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName());
            System.out.println(resField);

//Получение конструкторов
            Constructor[] constructors = clazz1.getDeclaredConstructors();

        for (Constructor constructor : constructors) {

            System.out.printf("\t%s %s (", Modifier.toString(constructor.getModifiers()), clazz1.getSimpleName());
            Parameter[] constructorsParameters = constructor.getParameters();
            Arrays.stream(constructorsParameters).forEach(parameter -> {
                System.out.printf("%s %s", parameter.getType().getSimpleName(), parameter.getName());
            });
            System.out.print("){}\n");
        }

       });

        Method[] method = clazz1.getDeclaredMethods();

        Arrays.stream(method).forEach(m -> {
            System.out.printf("\t%s %s %s(", Modifier.toString(m.getModifiers()), m.getReturnType().getSimpleName(), m.getName());
            Parameter[] parameter = m.getParameters();
            Arrays.stream(parameter).forEach(p ->{
                System.out.printf("%s %s", p.getType().getSimpleName(), p.getName());
            });

            System.out.print("){}\n");
        });
        System.out.println("}");


    }

    public static void main(String[] args) throws ClassNotFoundException {
        GettersAndSetters.check("ru.progwards.java2.lessons.reflection.Person");

    }
}
