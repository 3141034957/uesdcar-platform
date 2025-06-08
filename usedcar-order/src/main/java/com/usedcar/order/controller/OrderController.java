package com.usedcar.order.controller;

import com.usedcar.order.entity.Order;
import com.usedcar.order.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // 创建订单
    @PostMapping
    public boolean createOrder(@RequestBody Order order) {
        order.setStatus("PENDING");
        order.setCreateTime(LocalDateTime.now());
        order.setUpdateTime(LocalDateTime.now());
        return orderService.save(order);
    }

    // 查询所有订单
    @GetMapping
    public List<Order> list() {
        return orderService.list();
    }

    // 根据ID查询订单
    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        return orderService.getById(id);
    }

    // 更新订单状态
    @PutMapping("/{id}/status")
    public boolean updateStatus(@PathVariable Long id, @RequestParam String status) {
        Order order = orderService.getById(id);
        if (order == null) return false;
        order.setStatus(status);
        order.setUpdateTime(LocalDateTime.now());
        return orderService.updateById(order);
    }

    // 取消订单
    @DeleteMapping("/{id}")
    public boolean cancelOrder(@PathVariable Long id) {
        Order order = orderService.getById(id);
        if (order == null) return false;
        order.setStatus("CANCELED");
        order.setUpdateTime(LocalDateTime.now());
        return orderService.updateById(order);
    }
}
package com.usedcar.order.controller;

import com.usedcar.order.entity.Order;
import com.usedcar.order.service.OrderService;
import org.springframework.web.bind.annotation.*;

        import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // 创建订单
    @PostMapping
    public boolean createOrder(@RequestBody Order order) {
        order.setStatus("PENDING");
        order.setCreateTime(LocalDateTime.now());
        order.setUpdateTime(LocalDateTime.now());
        return orderService.save(order);
    }

    // 查询所有订单
    @GetMapping
    public List<Order> list() {
        return orderService.list();
    }

    // 根据ID查询订单
    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        return orderService.getById(id);
    }

    // 更新订单状态
    @PutMapping("/{id}/status")
    public boolean updateStatus(@PathVariable Long id, @RequestParam String status) {
        Order order = orderService.getById(id);
        if (order == null) return false;
        order.setStatus(status);
        order.setUpdateTime(LocalDateTime.now());
        return orderService.updateById(order);
    }

    // 取消订单
    @DeleteMapping("/{id}")
    public boolean cancelOrder(@PathVariable Long id) {
        Order order = orderService.getById(id);
        if (order == null) return false;
        order.setStatus("CANCELED");
        order.setUpdateTime(LocalDateTime.now());
        return orderService.updateById(order);
    }
}
