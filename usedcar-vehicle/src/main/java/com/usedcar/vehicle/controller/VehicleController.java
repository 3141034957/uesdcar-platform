package com.usedcar.vehicle.controller;

import com.usedcar.vehicle.entity.Vehicle;
import com.usedcar.vehicle.service.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    // 查询所有车辆
    @GetMapping
    public List<Vehicle> list() {
        return vehicleService.list();
    }

    // 新增车辆
    @PostMapping
    public boolean save(@RequestBody Vehicle vehicle) {
        return vehicleService.save(vehicle);
    }

    // 根据id删除车辆
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return vehicleService.removeById(id);
    }

    // 更新车辆
    @PutMapping("/{id}")
    public boolean update(@PathVariable Long id, @RequestBody Vehicle vehicle) {
        vehicle.setId(id);
        return vehicleService.updateById(vehicle);
    }
}
