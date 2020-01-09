package ru.progwards.java1.lessons.Training;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Java_14 {

    HashMap<Integer, String> a2map(int[] akey, String[] aval) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        for (int i = 0; i < akey.length; i++) {
            hashMap.put(akey[i], aval[i]);
        }
        return  hashMap;
    }

//    Создайте метод с сигнатурой int fillHoles(Map<Integer, String> map, int size), который вставляет в HashMap пару <n> "Число n", если она там отсутствует,
//    Проверить от 1 до максимального числа size включительно. Метод возвращает количество добавленных элементов. Пример пары: 1 "Число 1"
    int fillHoles(Map<Integer, String> map, int size){
        int res = 0;
        for (int i = 1; i <= size; i++){
           if (map.putIfAbsent(i, "Число" + i) == null){
               res ++;
           }
        }
        return res;
    }

//    Реализуйте метод с сигнатурой void checkAndAdd(TreeMap<Integer, String> map, Integer key, String value), который добавляет пару key-value в map при выполнении следующих условий:
//
//    значение с таким key должно отсутствовать
//    значение key долно быть больше головы TreeMap
//    значение key долно быть меньше хвоста TreeMap

    void checkAndAdd(TreeMap<Integer, String> map, Integer key, String value){
        if (map.isEmpty() == false && key < map.lastKey() && key > map.firstKey()){
            map.putIfAbsent(key, value);
        }
    }

    public static void main(String[] args) {

        Java_14 java_14 = new Java_14();
        Map<Integer, String> map1 = new HashMap<>();
        System.out.print(java_14.fillHoles(map1, 4)+":");
        System.out.print(map1);
    }
}
