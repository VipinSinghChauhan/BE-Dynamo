package com.dynamo.dynamoapp.controller;

import com.dynamo.dynamoapp.dto.AgentOrderDto;
import com.dynamo.dynamoapp.dto.AuthRequest;
import com.dynamo.dynamoapp.entity.Orders;
import com.dynamo.dynamoapp.entity.UserInfo;
import com.dynamo.dynamoapp.repository.UserInfoRepository;
import com.dynamo.dynamoapp.service.OrderService;
import com.dynamo.dynamoapp.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/order")
@RestController
public class OrderController {

    @Autowired
    UserInfoRepository userInfoRepository;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtUtil;

    @Autowired
    private OrderService orderService;

    @PostMapping("/authenticate")
    public String authenticate(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            UserInfo userInfo = this.userInfoRepository.findByName(authRequest.getUserName()).orElseThrow(() -> new RuntimeException("User not found"));
            String token = jwtUtil.generateToken(userInfo);
            return token;
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }

    @PostMapping("/")
    public Orders saveOrder(@RequestBody Orders orders) {
        return orderService.saveOrder(orders);
    }

    @GetMapping("/agent/{agentId}")
    public List<Orders> getAgentOrders(@PathVariable Long agentId) {
        return orderService.getAgentOrders(agentId);
    }

    @PutMapping("/assignToAgent")
    public boolean assignToAgent(@RequestBody AgentOrderDto agentOrderDto) {
        return orderService.assignToAgent(agentOrderDto);
    }

    @GetMapping("/admin")
    public List<Orders> getAdminOrders() {
        return orderService.getAllOrders();
    }

    @PutMapping("/assignToAdmin")
    public void assignToAdmin(@RequestBody Orders orders) {
        orderService.assignToAdmin(orders);
    }
}