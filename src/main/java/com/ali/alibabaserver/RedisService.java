package com.ali.alibabaserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    private RedisTemplate<String, Object> template;

    @Autowired
    public RedisService(RedisTemplate<String, Object> template) {
        this.template = template;
    }

    public void save(String key, Object value) {
        template.opsForValue().set(key, value);
    }

    public Object get(String key) {
        return template.opsForValue().get(key);
    }
}