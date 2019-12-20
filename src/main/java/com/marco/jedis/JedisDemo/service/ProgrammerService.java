package com.marco.jedis.JedisDemo.service;

import com.marco.jedis.JedisDemo.model.Programmer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public interface ProgrammerService {

    // string -----------------------------------------------------------
    void setProgrammerAsString(String idKey, String programmer);

    String getProgrammerAsString(String idKey);

    // list -------------------------------------------------------------
    void addToList(Programmer programmer);

    List<Programmer> getListMembers();

    Long getListCount();

    // set --------------------------------------------------------------
    void addToSet(Programmer ... programmers);

    Set<Programmer> getSetMembers();

    boolean isSetMember(Programmer programmer);

    // hash -------------------------------------------------------------
    void saveHash(Programmer programmer);

    void updateHash(Programmer programmer);

    Map<Integer, Programmer> findAllHash();

    Programmer findInHash(int id);

    void deleteHash(int id);
}
