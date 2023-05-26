package com.aula.pomonooo.strategy.role;

public interface RoleStrategy {
    String getName();

    void setName(String name);

    String sendReport(String report, String email);

    String answerCustomer(String message, int clientId);
}
