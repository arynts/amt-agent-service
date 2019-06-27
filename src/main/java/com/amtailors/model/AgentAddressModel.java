package com.amtailors.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name="AGENT_ADDRESS", schema = "AMTDB")
@ToString
public class AgentAddressModel {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="AGENT_ID")
    private String agentId;

    @Column(name="ADDR_1")
    private String addressLineOne;
    @Column(name="ADDR_2")
    private String addressLineTwo;
    @Column(name="CITY")
    private String city;
    @Column(name="STATE")
    private String state;
    @Column(name="POSTAL_CODE")
    private String postalCode;
    @Column(name="COUNTRY")
    private String country;

}
