package com.dynamo.dynamoapp.service;

import com.dynamo.dynamoapp.dto.AgentOrderDto;
import com.dynamo.dynamoapp.entity.Orders;
import com.dynamo.dynamoapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private static final String CREATED = "CREATED";
    private static final String IN_PROGRESS = "IN_PROGRESS";
    private static final String ASSIGNED_TO_AGENT = "ASSIGNED_TO_AGENT";
    private static final String COMPLETED = "COMPLETED";

    @Autowired
    private OrderRepository orderRepository;
    public Orders saveOrder(Orders orders) {
        orders.setStatus(CREATED);
        return orderRepository.save(orders);
    }


    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    public boolean assignToAgent(AgentOrderDto agentOrderDto) {
        try {
            Orders orders = orderRepository.findById(agentOrderDto.getOrderId()).orElseThrow(()->new RuntimeException("Order not found"));
            orders.setAssignedAgentId(agentOrderDto.getAgentId());
            orders.setStatus(ASSIGNED_TO_AGENT);
            orderRepository.save(orders);
            return true;
        }
        catch(Exception e){

        }
        return false;
    }

    public List<Orders> getAgentOrders(Long agentId) {
        return orderRepository.getOrderByAssignedAgentId(agentId);
    }

    public void assignToAdmin(Orders orders) {
        orders.setAssignedAgentId(null);
        orders.setStatus(COMPLETED);
        this.orderRepository.save(orders);
    }
}
