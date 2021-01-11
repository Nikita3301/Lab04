package com.springproject.service.impl;

import com.springproject.dto.CheckDTO;
import com.springproject.exception.ServiceException;
import com.springproject.mapper.CheckToCheckDTOMapper;
import com.springproject.repository.CheckRepository;
import com.springproject.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CheckServiceImpl implements CheckService {

    @Autowired
    private CheckRepository checkRepository;

    @Autowired
    private CheckToCheckDTOMapper checkMapper;


    @Override
    public CheckDTO getCheckById(final Long id) {
        return checkMapper.toDTO(checkRepository.getCheckById(id));
    }

    @Override
    public List<CheckDTO> getAllChecks() {
        return checkRepository.getAllChecks().stream()
                .map(e -> checkMapper.toDTO(e))
                .collect(Collectors.toList());
    }

    @Override
    public CheckDTO createCheck(final CheckDTO checkDTO) {
        if (checkDTO.getId() != null) {
            throw new ServiceException(400, "Check shouldn't have an id ");
        }

        return checkMapper.toDTO(checkRepository.createCheck(checkMapper.toEntity(checkDTO, null)));
    }

    @Override
    public CheckDTO updateCheck(final CheckDTO checkDTO) {
        if (checkDTO.getId() == null) {
            throw new ServiceException(400, "Check must have an id ");
        }

        if(checkRepository.getCheckById(checkDTO.getId()).getUser() == null) {
            return checkMapper.toDTO(checkRepository.updateCheck(checkMapper.toEntity(checkDTO, null)));
        } else {
            return checkMapper.toDTO(checkRepository.updateCheck(checkMapper.toEntity(checkDTO, checkRepository.getCheckById(checkDTO.getId()).getUser())));
        }
    }

    @Override
    public void deleteCheckById(final Long id) {
        checkRepository.deleteCheckById(id);
    }
}
