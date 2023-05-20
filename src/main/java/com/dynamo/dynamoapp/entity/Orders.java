package com.dynamo.dynamoapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;
    @Column
    private String customerName;
    @Column
    private String customerContact;
    @Column
    private String customerAddress;
    @Column
    private Long assignedAgentId;
    @Column
    private String status;
}
