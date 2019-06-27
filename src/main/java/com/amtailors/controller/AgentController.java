package com.amtailors.controller;


import amtailors.security.SecurityGuard;
import amtailors.security.impl.SecurityGuardImpl;
import com.amtailors.exception.UserAuthenticationException;
import com.amtailors.model.AgentModel;
import com.amtailors.service.AgentService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
//@RequestMapping(path = "/api")
@RequestMapping({"/api/amt-agent-service"})
public class AgentController {

    SecurityGuardImpl securityGuard = new SecurityGuardImpl();

    @Autowired
    AgentService agentService;

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> loginCheck(@RequestBody AgentModel agentModel, UriComponentsBuilder ucBuilder,
    @RequestHeader(value="secret", required=true) String secret){
        System.out.println("Checking user login :"+ agentModel.toString());
        String userStoredPswd = agentService.isUserExist(agentModel);
        if(userStoredPswd != null &&
                userStoredPswd.equals(securityGuard.getHashedPassword(agentModel.getAgentLoginPassword()))){
            System.out.println("Agent exist - And authenticated successfully");
            HttpHeaders headers = new HttpHeaders();
            return new ResponseEntity<String>(headers, HttpStatus.OK);
        }else{
            throw new UserAuthenticationException("Invalid credentials");
//            return new ResponseEntity<String>(headers, HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping(value = "/createAgent", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> registerAgent(@RequestBody AgentModel agentModel, UriComponentsBuilder ucBuilder){
        if(agentService.isAgentExist(agentModel)){
            throw new UserAuthenticationException("Agent already exists");
        }else{
            byte[] bytesEncoded = Base64.encodeBase64((agentModel.getAgentLoginUsername()).getBytes());
            agentModel.setAgentId(bytesEncoded.toString());
            agentModel.setAgentLoginPassword(securityGuard.getHashedPassword(agentModel.getAgentLoginPassword()));
            System.out.println("Agent Model while registering :"+agentModel.toString());
            agentService.saveAgent(agentModel);
            HttpHeaders headers = new HttpHeaders();
//            headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(user.getId()).toUri());
            return new ResponseEntity<String>(headers, HttpStatus.OK);
        }
    }
}
