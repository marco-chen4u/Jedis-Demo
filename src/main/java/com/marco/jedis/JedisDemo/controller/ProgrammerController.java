package com.marco.jedis.JedisDemo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marco.jedis.JedisDemo.model.Programmer;
import com.marco.jedis.JedisDemo.service.ProgrammerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
public class ProgrammerController {

    @Autowired
    ProgrammerService programmerService;

    // string -----------------------------------------------------------
    @RequestMapping(value = "/programmer-string", method = RequestMethod.POST)
    public void add(@RequestBody Programmer programmer) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        programmerService.setProgrammerAsString(String.valueOf(programmer.getId()),
                                                mapper.writeValueAsString(programmer));
    }

    @RequestMapping("/programmer-string/{id}")
    public String get(@PathVariable String id) {
        return programmerService.getProgrammerAsString(id);
    }

    // list -------------------------------------------------------------
    @RequestMapping(value = "/programmer-list", method = RequestMethod.POST)
    public void addToList(@RequestBody Programmer programmer) {
        programmerService.addToList(programmer);
    }

    @RequestMapping(value = "/programmer-list", method = RequestMethod.GET)
    public List<Programmer> getListMembers() {
        return programmerService.getListMembers();
    }

    @RequestMapping(value = "/programmer-list/count", method = RequestMethod.GET)
    public Long getListCount() {
        return programmerService.getListCount();
    }

    // set --------------------------------------------------------------
    @RequestMapping(value = "/programmer-set", method = RequestMethod.POST)
    public void addToSet(@RequestBody Programmer ... programmers) {
        programmerService.addToSet(programmers);
    }

    @RequestMapping(value = "/programmer-set", method = RequestMethod.GET)
    public Set<Programmer> getSetMembers() {
        return programmerService.getSetMembers();
    }

    @RequestMapping(value = "programmer-set/member", method = RequestMethod.POST)
    public boolean isSetMember(@RequestBody Programmer programmer) {
        return programmerService.isSetMember(programmer);
    }

    // hash -------------------------------------------------------------
    @RequestMapping(value = "/programmer-hash", method = RequestMethod.POST)
    public void saveHash(@RequestBody Programmer programmer) {
        programmerService.saveHash(programmer);
    }

    @RequestMapping(value = "/programmer-hash", method = RequestMethod.PUT)
    public void updateHash(@RequestBody Programmer programmer) {
        programmerService.updateHash(programmer);
    }

    @RequestMapping(value = "/programmer-hash", method = RequestMethod.GET)
    public Map<Integer, Programmer> findAllHash() {
        return programmerService.findAllHash();
    }

    @RequestMapping(value = "/programmer-hash/{id}", method = RequestMethod.GET)
    public Programmer findInHash(@PathVariable int id) {
        return programmerService.findInHash(id);
    }

    @RequestMapping(value = "/programmer-hash/{id}", method = RequestMethod.DELETE)
    public void deleteHash(@PathVariable int id) {
        programmerService.deleteHash(id);
    }
}
