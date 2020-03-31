package ru.progwards.java2.lessons.Training.J2_7;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class I7 {


    void callSetName(Person person, String name){

        Class clazz = person.getClass();

        Method method = null;
        try {
            method = clazz.getDeclaredMethod("setName", String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        method.setAccessible(true);
        try {
            method.invoke(person,name);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    void setName(Person person, String name) {

        Class clazz = person.getClass();

        Field field = null;
        try {
            field = clazz.getDeclaredField("name");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        field.setAccessible(true);
        try {
            field.set(person, name);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    Person callConstructor(String name){

        Class<Person> personClass = Person.class;

        Person newPerson = null;

        Constructor<Person> personConstructor = null;
        try {
            personConstructor = personClass.getDeclaredConstructor(String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        personConstructor.setAccessible(true);

        try {
            newPerson = personConstructor.newInstance(name);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (java.lang.reflect.InvocationTargetException e) {
            e.printStackTrace();
        }
        return newPerson;
    }

    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Person person = new Person();
        new I7().callConstructor("Vasya");

    }
}
