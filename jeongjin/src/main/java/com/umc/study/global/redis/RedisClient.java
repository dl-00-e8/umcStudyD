package com.umc.study.global.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
@RequiredArgsConstructor
public class RedisClient {

    private final RedisTemplate<String, String> redisTemplate;

    /**
     * Redis에 key-value 주입
     * @param key Redis에 저장될 key 값
     * @param value Redis에 저장될 value 값
     * @param timeout Redis에 저장된 상태에서의 유효 기간 설정
     */
    public void setValue(String key, String value, Long timeout) {
        ValueOperations<String, String> values = redisTemplate.opsForValue();
        values.set(key, value, Duration.ofMinutes(timeout));
    }

    /**
     * Redis에서 key로 value 조회 (nullable)
     * @param key Reids에서 조회할 Key 값
     * @return Redis에서 key로 조회한 value(String)
     */
    public String getValue(String key) {
        ValueOperations<String, String> values = redisTemplate.opsForValue();
        return values.get(key);
    }

    /**
     * Redis에서 해당 key의 정보 삭제
     * @param key Redis에서 삭제할 key 값
     */
    public void deleteValue(String key) {
        redisTemplate.delete(key);
    }
}
