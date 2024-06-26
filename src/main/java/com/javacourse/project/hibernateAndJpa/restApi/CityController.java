package com.javacourse.project.hibernateAndJpa.restApi;

import com.javacourse.project.hibernateAndJpa.Business.ICityService;
import com.javacourse.project.hibernateAndJpa.Entities.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/*
 * Bir sınıf @RestController annotasyonu ile işaretlendiğinde,
 * içerdiği metotlar HTTP isteklerini işleyebilir ve cevapları HTTP yanıtları olarak döndürebilir.
 * Bu metotlar, @RequestMapping, @GetMapping, @PostMapping, @PutMapping, @DeleteMapping
 * gibi diğer annotasyonlarla belirtilen URL'ler altında çağrılabilir ve
 * bu URL'lerin yanıtlarını oluşturabilir.
 * */
@RestController //RESTful web servisi olduğunu belirtir.
@RequestMapping("/api") //Controller sınıfındaki metotlar /api URL'si altında erişilebilir olacaktır
public class CityController {

    private ICityService iCityService;



    @Autowired
    public CityController(ICityService iCityService) {
        this.iCityService = iCityService;
    }


    @GetMapping("/cities")
    public List<City> get() {
        return iCityService.getAll();  //Citymanager'a gelen city verileri.
    }


    @PostMapping("/add") //Gönderim durumu söz konusu PostMapping olmalı
    public void add(@RequestBody City city)
    {
        iCityService.add(city);
    }

    @PostMapping("/update")
    public void update(@RequestBody City city)
    {
        iCityService.add(city);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody City city)
    {
        iCityService.add(city);
    }

    @GetMapping("/cities/{id}")
    public City getById(@PathVariable int id) {
         return iCityService.getById(id);
    }

}
