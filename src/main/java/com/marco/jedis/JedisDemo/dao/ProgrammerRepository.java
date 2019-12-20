package com.marco.jedis.JedisDemo.dao;

import com.marco.jedis.JedisDemo.model.Programmer;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ProgrammerRepository {

    // string -------------------------------------------------------------
    void setPragrammerAsString(String idKey, String programmer);

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
