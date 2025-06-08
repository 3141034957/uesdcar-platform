package com.example.recommend.service;

import com.example.common.dto.VehicleDTO;
import com.example.recommend.feign.VehicleFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecommendService {

    private final String HOT_VEHICLE_KEY = "hot:vehicle:zset";
    private final StringRedisTemplate redisTemplate;
    private final VehicleFeignClient vehicleFeignClient;

    public List<VehicleDTO> getHotVehicles() {
        Set<String> topIds = redisTemplate.opsForZSet()
                .reverseRange(HOT_VEHICLE_KEY, 0, 9);

        if (topIds == null || topIds.isEmpty()) return Collections.emptyList();

        List<Long> idList = topIds.stream().map(Long::parseLong).collect(Collectors.toList());

        return vehicleFeignClient.getVehicleByIds(idList);
    }
}
