package com.springproject.service;

import com.springproject.dto.CheckDTO;

import java.util.List;

public interface CheckService {
    CheckDTO getCheckById(Long id);
    List<CheckDTO> getAllChecks();
    CheckDTO createCheck(CheckDTO checkDTO);
    CheckDTO updateCheck(CheckDTO checkDTO);
    void deleteCheckById(Long id);
}
