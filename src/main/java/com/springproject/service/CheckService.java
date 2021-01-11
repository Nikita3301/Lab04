package com.springproject.service;

import com.springproject.dto.CheckDTO;

import java.util.List;

public interface CheckService {
    CheckDTO getCheckById(Long id);
    List<CheckDTO> getAllChecks();
    CheckDTO createCheck(CheckDTO checkDTO, Long userId);
    CheckDTO updateCheck(CheckDTO checkDTO, Long userId);
    void deleteCheckById(Long id);
}
