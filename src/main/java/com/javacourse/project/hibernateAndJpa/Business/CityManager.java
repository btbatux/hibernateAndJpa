package com.javacourse.project.hibernateAndJpa.Business;

import com.javacourse.project.hibernateAndJpa.DataAccess.ICityDal;
import com.javacourse.project.hibernateAndJpa.Entities.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityManager implements ICityService{
    private ICityDal iCityDal;


    @Autowired //Buraya uygun olan nesneyi enjete et.
    public CityManager(ICityDal iCityDal) {
        this.iCityDal = iCityDal;
    }



    @Override
    @Transactional
    public List<City> getAll() {
        return this.iCityDal.getAll();
    }



    @Override
    @Transactional
    public void add(City city) {

    }



    @Override
    @Transactional
    public void update(City city) {

    }


    @Override
    @Transactional
    public void delete(City city) {

    }


}
