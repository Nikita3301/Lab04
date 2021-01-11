package com.springproject.resource;

import com.springproject.dto.BikeDTO;
import com.springproject.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BikeResource {

    @Autowired
    private BikeService bikeService;


    @GetMapping("/bike/{id}")
    public BikeDTO getBikeById(final @PathVariable Long id) {
        return bikeService.getBikeById(id);
    }

    @GetMapping("/all_bikes")
    public List<BikeDTO> getAllBikes() {
        return bikeService.getAllBikes();
    }

    @PostMapping("/create_bike")
    public BikeDTO createBike(final @Valid @RequestBody BikeDTO bikeDTO) {
        return bikeService.createBike(bikeDTO);
    }

    @PutMapping("/update_bike")
    public BikeDTO updateBike(final @Valid @RequestBody BikeDTO bikeDTO) {
        return bikeService.updateBike(bikeDTO);
    }

    @DeleteMapping("/delete_bike/{id}")
    public void deleteBikeById(final @PathVariable Long id) {
        bikeService.deleteBikeById(id);
    }
}
