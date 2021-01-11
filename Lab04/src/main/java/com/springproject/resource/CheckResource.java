package com.springproject.resource;

import com.springproject.dto.CheckDTO;
import com.springproject.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CheckResource {

    @Autowired
    private CheckService checkService;


    @GetMapping("/check/{id}")
    public CheckDTO getCheckById(final @PathVariable Long id) {
        return checkService.getCheckById(id);
    }

    @GetMapping("/all_checks")
    public List<CheckDTO> getAllChecks() {
        return checkService.getAllChecks();
    }

    @PostMapping("/create_check")
    public CheckDTO createCheck(final @Valid @RequestBody CheckDTO checkDTO) {
        return checkService.createCheck(checkDTO);
    }

    @PutMapping("/update_check")
    public CheckDTO updateCheck(final @Valid @RequestBody CheckDTO checkDTO) {
        return checkService.updateCheck(checkDTO);
    }

    @DeleteMapping("/delete_check/{id}")
    public void deleteCheckById(final @PathVariable Long id) {
        checkService.deleteCheckById(id);
    }
}
