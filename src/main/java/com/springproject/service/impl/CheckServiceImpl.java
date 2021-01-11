package com.springproject.service.impl;

import com.springproject.dto.CheckDTO;
import com.springproject.exception.ServiceException;
import com.springproject.mapper.CheckToCheckDTOMapper;
import com.springproject.repository.CheckRepository;
import com.springproject.repository.UserRepository;
import com.springproject.service.CheckService;
import com.springproject.service.UserService;
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

    @Autowired
    private UserRepository userRepository;


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
    public CheckDTO createCheck(final CheckDTO checkDTO, final Long userId) {
        if (checkDTO.getId() != null) {
            throw new ServiceException(400, "Check shouldn't have an id ", null);
        }

        return checkMapper.toDTO(checkRepository.createCheck(checkMapper.toEntity(checkDTO, userRepository.getUserById(userId))));
    }

    @Override
    public CheckDTO updateCheck(final CheckDTO checkDTO, final Long userId) {
        if (checkDTO.getId() == null) {
            throw new ServiceException(400, "Check must have an id ", null);
        }

        if(checkRepository.getCheckById(checkDTO.getId()).getUser() == null) {
            return checkMapper.toDTO(checkRepository.updateCheck(checkMapper.toEntity(checkDTO, userRepository.getUserById(userId))));
        } else {
            return checkMapper.toDTO(checkRepository.updateCheck(checkMapper.toEntity(checkDTO, checkRepository.getCheckById(checkDTO.getId()).getUser())));
        }
    }

    @Override
    public void deleteCheckById(final Long id) {
        checkRepository.deleteCheckById(id);
    }
}
