package com.amtailors.service.impl;

import com.amtailors.model.AgentModel;
import com.amtailors.repository.AgentRepository;
import com.amtailors.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("agentService")
@Transactional
public class AgentServiceImpl implements AgentService {

    @Autowired
    AgentRepository agentRepository;

    public AgentModel findByName(String name) {
        return agentRepository.findByAgentLoginUsername(name);
    }

    public boolean isAgentExist(AgentModel agentModel) {
        return findByName(agentModel.getAgentLoginUsername()) != null;
    }

    public String isUserExist(AgentModel agentModel){
        AgentModel agentModel1 =  findByName(agentModel.getAgentLoginUsername());
        if(agentModel1 != null)
            return agentModel1.getAgentLoginPassword();
        return null;
    }

    public void saveAgent(AgentModel agentModel) {
        agentRepository.save(agentModel);
    }
}
