package com.amtailors.repository;

import com.amtailors.model.AgentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends JpaRepository<AgentModel, String> {

    AgentModel findByAgentLoginUsername(String name);

}
