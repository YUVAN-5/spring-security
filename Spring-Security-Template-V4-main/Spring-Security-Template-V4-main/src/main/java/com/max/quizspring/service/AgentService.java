package com.max.quizspring.service;

import com.max.quizspring.auth.AgentRequest;
import com.max.quizspring.model.Agent;
import com.max.quizspring.repo.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgentService {
    @Autowired
    private AgentRepository agentRepository;

    public Agent saveAgent(AgentRequest agentRequest) {
        Agent agent = new Agent();
        agent.setName(agentRequest.getName());
        agent.setPhone(agentRequest.getPhone());
        agent.setEmail(agentRequest.getEmail());
        return agentRepository.save(agent);
    }

    public List<Agent> getAllAgents() {
        return agentRepository.findAll();
    }

    public Optional<Agent> getAgentById(Long id) {
        return agentRepository.findById(id);
    }

    public void deleteAgent(Long id) {
        agentRepository.deleteById(id);
    }
}
