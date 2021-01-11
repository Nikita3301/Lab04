package com.springproject.repository;

import com.springproject.entity.Bike;
import com.springproject.entity.Check;
import com.springproject.exception.ServiceException;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CheckRepository {

    @PostConstruct
    public void init() {
        savedChecks = new ArrayList<>();

    }

    private Long lastId = 1L;
    public List<Check> savedChecks;


    public Check getCheckById(final Long id) {
        return savedChecks.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "Check with id: " + id + " not found",null));
    }

    public List<Check> getAllChecks() {
        return savedChecks;
    }

    public Check createCheck(final Check check) {
        if (check.getId() != null) {
            throw new ServiceException(400, "Check shouldn't have an id ", null);
        }

        ++lastId;
        check.setId(lastId);
        savedChecks.add(check);
        if (check.getUser().getChecks() != null) {
            check.getUser().getChecks().add(check);
        } else {
            check.getUser().setChecks(new ArrayList<>(Collections.singletonList(check)));
        }


        return check;
    }

    public Check updateCheck(final Check check) {
        if (check.getId() == null) {
            throw new ServiceException(400, "Check must have an id ", null);
        }

        final Check savedCheck = getCheckById(check.getId());

        savedCheck.setPrice(check.getPrice());
        savedCheck.setLeaseStartTime(check.getLeaseStartTime());
        savedCheck.setLeaseEndTime(check.getLeaseEndTime());
        savedCheck.setUser(check.getUser());
        savedCheck.setBikes(check.getBikes());

        return savedCheck;
    }

    public void deleteCheckById(final Long id) {
        if (id == null) {
            throw new ServiceException(400, "Id isn't specified", null);
        }

        savedChecks.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "Check with id: " + id + " not found ",null));

        savedChecks = savedChecks.stream()
                .filter(e -> !e.getId().equals(id))
                .collect(Collectors.toList());

    }
}
