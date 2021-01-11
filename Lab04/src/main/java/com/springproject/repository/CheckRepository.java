package com.springproject.repository;

import com.springproject.entity.Bike;
import com.springproject.entity.Check;
import com.springproject.exception.ServiceException;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
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


    public Check getCheckById(final Long id){
        return savedChecks.stream()
                .filter(e->e.getId().equals(id))
                .findFirst()
                .orElseThrow(()->new ServiceException(400, "Check with id: "+id + " not found"));
    }

    public List<Check> getAllChecks(){
        return savedChecks;
    }

    public Check createCheck(final Check check){
        if(check.getId() != null){
            throw new ServiceException(400, "Check shouldn't have an id ");
        }

        ++lastId;
        check.setId(lastId);
        savedChecks.add(check);

        return check;
    }

    public Check updateCheck(final Check check){
        if(check.getId() == null){
            throw new ServiceException(400, "Check must have an id ");
        }

        final Check savedCheck = getCheckById(check.getId());

        savedCheck.setPrice(check.getPrice());
        savedCheck.setLeaseStartTime(check.getLeaseStartTime());
        savedCheck.setLeaseEndTime(check.getLeaseEndTime());
        savedCheck.setUser(check.getUser());
        savedCheck.setBikes(check.getBikes());

        return savedCheck;
    }

    public void deleteCheckById(final Long id){
        if(id == null){
            throw new ServiceException(400, "Id isn't specified");
        }

        savedChecks.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "Check with id: " + id + " not found "));

        savedChecks = savedChecks.stream()
                .filter(e -> !e.getId().equals(id))
                .collect(Collectors.toList());

    }
}
