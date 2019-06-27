package com.amtailors.model;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name="AGENT_DETAILS", schema = "AMTDB")
@ToString
public class AgentModel implements Serializable {

    @Id
    @Column(name="AGENT_ID")
    private String agentId;

    @Column(name="USER_NAME", nullable=false)
    private String agentLoginUsername;

    @Column(name="PASSWORD", insertable = false, updatable = false)
    private String agentLoginPassword;

    @Column(name="FIRST_NAME")
    private String agentName;

    @Column(name="EMAIL")
    private String agentEmail;

    @Column(name="MOBILE_NUMBER")
    private String agentPhoneNumber;

    @Column(name="PASSWORD")
    private String agentRegPassword;

    @ManyToMany(fetch=FetchType.LAZY,cascade = {CascadeType.PERSIST})
    @JoinTable(name="AGENT_ADDRESS",joinColumns = { @JoinColumn(name = "AGENT_ID")})
    private List<AgentAddressModel> agentAddressModel;
}
