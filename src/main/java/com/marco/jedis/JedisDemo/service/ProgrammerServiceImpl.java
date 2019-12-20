package com.marco.jedis.JedisDemo.service;

import com.marco.jedis.JedisDemo.dao.ProgrammerRepository;
import com.marco.jedis.JedisDemo.model.Programmer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class ProgrammerServiceImpl implements ProgrammerService {

    @Autowired
    ProgrammerRepository repository;

    // string -----------------------------------------------------------
    @Override
    public void setProgrammerAsString(String idKey, String programmer) {
        repository.setPragrammerAsString(idKey, programmer);
    }

    @Override
    public String getProgrammerAsString(String idKey) {
        return repository.getProgrammerAsString(idKey);
    }

    // list -------------------------------------------------------------
    @Override
    public void addToList(Programmer programmer) {
        repository.addToList(programmer);
    }

    @Override
    public List<Programmer> getListMembers() {
        return repository.getListMembers();
    }

    @Override
    public Long getListCount() {
        return repository.getListCount();
    }

    // set --------------------------------------------------------------
    @Override
    public void addToSet(Programmer... programmers) {
        repository.addToSet(programmers);
    }

    @Override
    public Set<Programmer> getSetMembers() {
        return repository.getSetMembers();
    }

    @Override
    public boolean isSetMember(Programmer programmer) {
        return repository.isSetMember(programmer);
    }

    // hash -------------------------------------------------------------
    @Override
    public void saveHash(Programmer programmer) {
        repository.saveHash(programmer);
    }

    @Override
    public void updateHash(Programmer programmer) {
        repository.updateHash(programmer);
    }

    @Override
    public Map<Integer, Programmer> findAllHash() {
        return repository.findAllHash();
    }

    @Override
    public Programmer findInHash(int id) {
        return repository.findInHash(id);
    }

    @Override
    public void deleteHash(int id) {
        repository.deleteHash(id);
    }
}
