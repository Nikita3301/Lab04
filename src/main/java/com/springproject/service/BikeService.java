package com.springproject.service;

import com.springproject.dto.BikeDTO;

import java.util.List;

public interface BikeService {
    BikeDTO getBikeById(Long id);
    List<BikeDTO> getAllBikes();
    BikeDTO createBike(BikeDTO bikeDTO);
    BikeDTO updateBike(BikeDTO bikeDTO);
    void deleteBikeById(Long id);
}
