package com.springproject.repository;

import com.springproject.entity.Bike;
import com.springproject.exception.ServiceException;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BikeRepository {

    @PostConstruct
    public void init() {
        savedBikes = new ArrayList<>();

    }

    private Long lastId = 1L;
    public List<Bike> savedBikes;


    public Bike getBikeById(final Long id){
        return savedBikes.stream()
                .filter(e->e.getId().equals(id))
                .findFirst()
                .orElseThrow(()->new ServiceException(400, "Bike with id: "+id + " not found"));
    }

    public List<Bike> getAllBikes(){
        return savedBikes;
    }

    public Bike createBike(final Bike bike){
        if(bike.getId() != null){
            throw new ServiceException(400, "Bike shouldn't have an id ");
        }

        ++lastId;
        bike.setId(lastId);
        savedBikes.add(bike);

        return bike;
    }

    public Bike updateBike(final Bike bike){
        if(bike.getId() == null){
            throw new ServiceException(400, "Bike must have an id ");
        }

        final Bike savedBike = getBikeById(bike.getId());

        savedBike.setType(bike.getType());
        savedBike.setFrameSize(bike.getFrameSize());
        savedBike.setWheelSize(bike.getWheelSize());
        savedBike.setWheelWidth(bike.getWheelWidth());
        savedBike.setNumberOfSpeeds(bike.getNumberOfSpeeds());
        savedBike.setTypeOfBrakes(bike.getTypeOfBrakes());
        savedBike.setUser(bike.getUser());

        return savedBike;
    }

    public void deleteBikeById(final Long id){
        if(id == null){
            throw new ServiceException(400, "Id isn't specified");
        }

        savedBikes.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "Bike with id: " + id + " not found "));

        savedBikes = savedBikes.stream()
                .filter(e -> !e.getId().equals(id))
                .collect(Collectors.toList());

    }
}
