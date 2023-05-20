package com.dynamo.dynamoapp.repository;

import com.dynamo.dynamoapp.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Long> {
    List<Orders> getOrderByAssignedAgentId(Long assignedAgentId);
}
