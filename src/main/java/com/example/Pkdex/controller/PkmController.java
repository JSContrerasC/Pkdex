package com.example.Pkdex.controller;

import com.example.Pkdex.domain.Pkm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URL;

@RestController
public class PkmController {
 public void  hola (){
    }
    @Autowired
    private RestTemplate restTemplate;
//    String result = restTemplate.getForObject(newUrl, String.class);
//
//    private String oldUrl = new String("https://pokeapi.co/api/v2/pokemon/id");
//    private String newUrlString = oldUrl.toString().replaceFirst("^id", id);
//    private String newUrl = new String(newUrlString);

    @GetMapping("/Pkm")
    public Pkm pkm(@RequestParam(value = "id", defaultValue = "133") int id) {

        String oldUrl = new String("https://pokeapi.co/api/v2/pokemon/id");
        String newUrlString = oldUrl.toString().replaceFirst("^id", String.valueOf(id));
        String newUrl = new String(newUrlString);

        Pkm pokemon = restTemplate.getForObject(newUrl, Pkm.class);

        return pokemon;
    }
}
