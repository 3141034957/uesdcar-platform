package com.example.recommend.feign;

import com.usedcar.common.dto.VehicleDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("usedcar-vehicle")
public interface VehicleFeignClient {

    @PostMapping("/internal/vehicles/byIds")
    List<VehicleDTO> getVehicleByIds(@RequestBody List<Long> ids);
}
