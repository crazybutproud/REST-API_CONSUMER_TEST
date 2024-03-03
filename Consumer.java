package ru.anna.RestApiConsumer;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class Consumer { //класс для запросов к стороннему rest api сервису
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate(); // с помощью этого объекта делаем запрос к удаленным сервисам

        String url = "https://reqres.in/api/users/2";
        String response = restTemplate.getForObject(url, String.class); //запрос на получение
        System.out.println(response);

        Map<String,String> jsonToSend = new HashMap<>();
        jsonToSend.put("name","Test name");
        jsonToSend.put("job","Test job");
        HttpEntity<Map<String,String>> request = new HttpEntity<>(jsonToSend); //формат для отправки
        String url2 = "https://reqres.in/api/users";
        String response2 = restTemplate.postForObject(url2,request, String.class); //запрос на отправку
        System.out.println(response2);
    }
}
