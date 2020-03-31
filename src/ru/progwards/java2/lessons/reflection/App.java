package ru.progwards.java2.lessons.reflection;

import reflection.Employee;

import java.lang.reflect.*;
import java.util.Arrays;
public class App {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {




        Employee employee = new Employee("Artem", 41);
        System.out.println(employee);

        Class<Employee> clazz = Employee.class;

        printMethods(clazz);

        Field f1 = clazz.getDeclaredField("name");
        f1.setAccessible(true);
        f1.set(employee, "Vova");
        System.out.println(employee);
        System.out.println(Employee.count);
        Method m1 = clazz.getDeclaredMethod("setCount", int.class);
        m1.setAccessible(true);
        m1.invoke(employee, 40);
        System.out.println(Employee.count);



//       Class<Employee> clazz = Employee.class;
//        System.out.println(clazz.getName());

       // printFields(clazz);

       // printMethods(clazz);

       // printConstructor(clazz);

      //  modifyField();

      //  instanceEmployee();

    }

    private static void instanceEmployee() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Employee> clazz = Employee.class;

        Constructor<Employee> constructor = clazz.getConstructor(String.class, int.class, int.class);

        Employee employee = constructor.newInstance("Artem", 30, 1000);

        System.out.println(employee);

        Method m1 = clazz.getMethod("increaseSalary");

        m1.invoke(employee);

        System.out.println(employee);

        Method m2 = clazz.getMethod("increaseSalary", int.class);

        m2.invoke(employee, 1000);

        System.out.println(employee);
    }

    private static void modifyField() throws NoSuchFieldException, IllegalAccessException {
        Employee employee = new Employee();
        employee.salary = 100;
        System.out.println(employee);

        Class<Employee> employeeClass = (Class<Employee>) employee.getClass();
        Field salary = employeeClass.getDeclaredField("salary");
        salary.set(employee, 300);
        System.out.println(employee);
    }

    private static void printConstructor(Class<Employee> clazz) {

        Constructor[] constructors = clazz.getConstructors();

        System.out.println(constructors.length);

    }

    private static void printMethods(Class<Employee> clazz) {
        Method[] methods = clazz.getDeclaredMethods();

        Arrays.stream(methods).forEach(m -> {
            String mod = Modifier.toString(m.getModifiers());
            Parameter[] parameters = m.getParameters();
            System.out.println(mod+" " +
                    ""+m.getReturnType().getSimpleName() +" " +
                    ""+m.getName());
        });
    }

    private static void printFields(Class<Employee> clazz) {

       Field[] fields =  clazz.getDeclaredFields();
        for (Field f:fields) {
            int mod = f.getModifiers();
            String modStr = Modifier.toString(mod);
            System.out.println(modStr+" "+f.getType().getSimpleName()+" "+f.getName());
        }
    }
}
