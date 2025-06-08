package com.example.recommend.controller;

import com.usedcar.common.result.Result;
import com.usedcar.common.dto.VehicleDTO;
import com.example.recommend.service.RecommendService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommend")
@RequiredArgsConstructor
public class RecommendController {

    private final RecommendService recommendService;

    @GetMapping("/hot")
    public Result<List<VehicleDTO>> getHotVehicles() {
        return Result.success(recommendService.getHotVehicles());
    }
}
