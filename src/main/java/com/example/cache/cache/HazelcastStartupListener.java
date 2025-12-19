package com.example.cache.cache;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class HazelcastStartupListener {

    private final HazelcastInstance hazelcastInstance;

    public HazelcastStartupListener(HazelcastInstance hazelcastInstance){
        this.hazelcastInstance=hazelcastInstance;
    }
    @EventListener(ApplicationReadyEvent.class)
    public void onStart(){
        IMap<String,String> map = hazelcastInstance.getMap(hazelcastInstance.getName());
        Set<String> keys = map.keySet();
        keys.forEach(System.out::println);
    }
}
