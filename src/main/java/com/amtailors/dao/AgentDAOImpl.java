package com.amtailors.dao;

import com.amtailors.model.AgentModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AgentDAOImpl {

    List<AgentModel> agentModelList = new ArrayList<>();

    public void saveRegistration(AgentModel agentModel){
        agentModelList.add(agentModel);
        System.out.println("Result :"+ agentModelList);
    }


}
