package com.marco.jedis.JedisDemo.dao;

import com.marco.jedis.JedisDemo.model.Programmer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Repository
public class ProgrammerRepositoryImpl implements ProgrammerRepository{
    private final String REDIS_LIST_KEY = "ProgrammerList";
    private final String REDIS_SET_KEY = "ProgrammerSet";
    private final String REDIS_HASH_KEY = "ProgrammerHash";

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // string -------------------------------------------------------------
    @Override
    public void setPragrammerAsString(String idKey, String programmer) {
        redisTemplate.opsForValue().set(idKey, programmer);
        redisTemplate.expire(idKey, 20, TimeUnit.SECONDS);
    }

    @Override
    public String getProgrammerAsString(String idKey) {
        return (String) redisTemplate.opsForValue().get(idKey);
    }

    // list -------------------------------------------------------------
    @Autowired
    @Qualifier("listOperations")
    private ListOperations<String, Programmer> listOps;

    @Override
    public void addToList(Programmer programmer) {
        redisTemplate.opsForList().leftPush(REDIS_LIST_KEY, programmer);
    }

    @Override
    public List<Programmer> getListMembers() {
        return listOps.range(REDIS_LIST_KEY, 0, -1);
    }

    @Override
    public Long getListCount() {
        return listOps.size(REDIS_LIST_KEY);
    }

    // set --------------------------------------------------------------
    @Autowired
    @Qualifier("setOperations")
    private SetOperations<String, Programmer> setOps;

    @Override
    public void addToSet(Programmer... programmers) {
        setOps.add(REDIS_SET_KEY, programmers);
    }

    @Override
    public Set<Programmer> getSetMembers() {
        return setOps.members(REDIS_SET_KEY);
    }

    @Override
    public boolean isSetMember(Programmer programmer) {
        return setOps.isMember(REDIS_SET_KEY, programmer);
    }

    // hash -------------------------------------------------------------
    @Autowired
    @Qualifier("hashOperations")
    private HashOperations<String, Integer, Programmer> hashOps;

    @Override
    public void saveHash(Programmer programmer) {
        hashOps.put(REDIS_HASH_KEY, programmer.getId(), programmer);
    }

    @Override
    public void updateHash(Programmer programmer) {
        hashOps.put(REDIS_HASH_KEY, programmer.getId(), programmer);
    }

    @Override
    public Map<Integer, Programmer> findAllHash() {
        return hashOps.entries(REDIS_HASH_KEY);
    }

    @Override
    public Programmer findInHash(int id) {
        return hashOps.get(REDIS_HASH_KEY, id);
    }

    @Override
    public void deleteHash(int id) {
        hashOps.delete(REDIS_HASH_KEY, id);
    }
}
