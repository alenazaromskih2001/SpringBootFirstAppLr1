package ru.zaromskih.SpringBootFirstApp.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController {

    //метод приветствия
    @GetMapping("/hello")
    public String hello(@RequestParam(value =  "name",
    defaultValue = "World") String name) {
        return  String.format("Hello %s!", name);
    }

    //метод для добавления элементов в список ArrayList
    public List<String> stringList;
    @GetMapping("/update-array")
    public String updateArrayList(@RequestParam(value = "value") String s) {
        if (stringList == null) {
            stringList = new ArrayList<>();
        }

        stringList.add(s);
        return "В список ArrayList добавлены элементы.";
    }

    //метод для отображения списка  ArrayList
    @GetMapping("/show-array")
    public String showArrayList() {
        if (stringList == null||stringList.isEmpty()) {
            return "Список пуст.";
        } else return stringList.toString();

    }
    //метод для добавления элементов в список HashMap
    public Map<Integer, String> hashMap;
    public  Integer key = 1;

    @GetMapping("/update-map")
    public String updateHashMap(@RequestParam(value = "value") String s) {
        if(hashMap == null){
            hashMap = new HashMap<>();
        }
        hashMap.put(key, s);
        key++; //увеличиваем ключ для следующего элемента

        return "В список HashMap добавлены элементы.";
    }

    //метод для отображения списка  HashMap
    @GetMapping("/show-map")
    public String showHashMap() {
        if (hashMap == null||hashMap.isEmpty()) {
            return "Список пуст.";
        } else return hashMap.toString();

    }
    //метод для отображения кол-ва элементов в HashMap и ArrayList
    @GetMapping("/show-all-length")
    public String showAllLength (){
        int arraySize = (stringList != null)? stringList.size() : 0;
        int mapSize = (hashMap != null)? hashMap.size() : 0;
        return  String.format("В ArrayList: %d элементов, а в HashMap %d элементов.", arraySize, mapSize);
    }
}




