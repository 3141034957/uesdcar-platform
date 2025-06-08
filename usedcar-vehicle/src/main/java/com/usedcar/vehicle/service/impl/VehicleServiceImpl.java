package com.usedcar.vehicle.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.usedcar.vehicle.entity.Vehicle;
import com.usedcar.vehicle.mapper.VehicleMapper;
import com.usedcar.vehicle.service.VehicleService;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl extends ServiceImpl<VehicleMapper, Vehicle> implements VehicleService {
}
