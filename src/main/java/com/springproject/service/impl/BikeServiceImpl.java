package com.springproject.service.impl;

import com.springproject.exception.ServiceException;
import com.springproject.dto.BikeDTO;
import com.springproject.mapper.BikeToBikeDTOMapper;
import com.springproject.repository.BikeRepository;
import com.springproject.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BikeServiceImpl implements BikeService {

    @Autowired
    private BikeRepository bikeRepository;

    @Autowired
    private BikeToBikeDTOMapper bikeMapper;


    @Override
    public BikeDTO getBikeById(final Long id) {
        return bikeMapper.toDTO(bikeRepository.getBikeById(id));
    }

    @Override
    public List<BikeDTO> getAllBikes() {
        return bikeRepository.getAllBikes().stream()
                .map(e -> bikeMapper.toDTO(e))
                .collect(Collectors.toList());
    }

    @Override
    public BikeDTO createBike(final BikeDTO bikeDTO) {
        if (bikeDTO.getId() != null) {
            throw new ServiceException(400, "Bike shouldn't have an id ", null);
        }

        return bikeMapper.toDTO(bikeRepository.createBike(bikeMapper.toEntity(bikeDTO)));
    }

    @Override
    public BikeDTO updateBike(final BikeDTO bikeDTO) {
        if (bikeDTO.getId() == null) {
            throw new ServiceException(400, "Bike must have an id ", null);
        }

        return bikeMapper.toDTO(bikeRepository.updateBike(bikeMapper.toEntity(bikeDTO)));
    }

    @Override
    public void deleteBikeById(final Long id) {
        bikeRepository.deleteBikeById(id);
    }
}
