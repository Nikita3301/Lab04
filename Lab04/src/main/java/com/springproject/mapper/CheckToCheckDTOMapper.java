package com.springproject.mapper;

import com.springproject.dto.BikeDTO;
import com.springproject.dto.CheckDTO;
import com.springproject.entity.Bike;
import com.springproject.entity.Check;
import com.springproject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CheckToCheckDTOMapper {

    @Autowired
    private BikeToBikeDTOMapper bikeToBikeDTOMapper;

    public Check toEntity(final CheckDTO checkDTO, final User user) {
        final Check check = new Check();

        check.setId(checkDTO.getId());
        check.setPrice(checkDTO.getPrice());
        check.setLeaseStartTime(checkDTO.getLeaseStartTime());
        check.setLeaseEndTime(checkDTO.getLeaseEndTime());

        check.setUser(user);

        if(checkDTO.getBikesDTO() == null) {
            check.setBikes(null);
        } else {
            final List<Bike> bikeList = new ArrayList<>();
            for (final BikeDTO bikeDTO : checkDTO.getBikesDTO()) {
                bikeList.add(bikeToBikeDTOMapper.toEntity(bikeDTO, user));
            }
            check.setBikes(bikeList);
        }

        return check;
    }

    public CheckDTO toDTO(final Check check) {
        final CheckDTO checkDTO = new CheckDTO();

        checkDTO.setId(check.getId());
        checkDTO.setPrice(check.getPrice());
        checkDTO.setLeaseStartTime(check.getLeaseStartTime());
        checkDTO.setLeaseEndTime(check.getLeaseEndTime());

        checkDTO.setUserFirstName(check.getUser().getFirstName());
        checkDTO.setUserLastName(check.getUser().getLastName());

        if(check.getBikes() == null) {
            checkDTO.setBikesDTO(null);
        } else {
            final List<BikeDTO> bikeDTOList = new ArrayList<>();
            for (final Bike bike : check.getBikes()) {
                bikeDTOList.add(bikeToBikeDTOMapper.toDTO(bike));
            }
            checkDTO.setBikesDTO(bikeDTOList);
        }

        return checkDTO;
    }
}
