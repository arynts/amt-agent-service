package com.amtailors.service;

import com.amtailors.model.AgentModel;

public interface AgentService {

    boolean isAgentExist(AgentModel agentModel);

    void saveAgent(AgentModel user);

    String isUserExist(AgentModel agentModel);

}
