package com.springproject.mapper;

import com.springproject.dto.BikeDTO;
import com.springproject.entity.Bike;
import com.springproject.entity.User;
import org.springframework.stereotype.Component;

@Component
public class BikeToBikeDTOMapper {
    public Bike toEntity(final BikeDTO bikeDTO){
        final Bike bike = new Bike();

        bike.setId(bikeDTO.getId());
        bike.setType(bikeDTO.getType());
        bike.setFrameSize(bikeDTO.getFrameSize());
        bike.setWheelSize(bikeDTO.getWheelSize());
        bike.setWheelWidth(bikeDTO.getWheelWidth());
        bike.setNumberOfSpeeds(bikeDTO.getNumberOfSpeeds());
        bike.setTypeOfBrakes(bikeDTO.getTypeOfBrakes());

        return bike;
    }

    public BikeDTO toDTO(final Bike bike){
        final BikeDTO bikeDTO = new BikeDTO();

        bikeDTO.setId(bike.getId());
        bikeDTO.setType(bike.getType());
        bikeDTO.setFrameSize(bike.getFrameSize());
        bikeDTO.setWheelSize(bike.getWheelSize());
        bikeDTO.setWheelWidth(bike.getWheelWidth());
        bikeDTO.setNumberOfSpeeds(bike.getNumberOfSpeeds());
        bikeDTO.setTypeOfBrakes(bike.getTypeOfBrakes());


        return bikeDTO;
    }
}
