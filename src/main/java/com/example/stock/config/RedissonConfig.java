package com.example.stock.config;


import com.example.stock.property.RedisProperty;
import lombok.RequiredArgsConstructor;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class RedissonConfig {

    private final RedisProperty redisProperty;

    @Bean
    public RedissonClient redissionClient() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://" + this.redisProperty.getHost()+":"+ this.redisProperty.getPort());
        return Redisson.create(config);
    }
}
