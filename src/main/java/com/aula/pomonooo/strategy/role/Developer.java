package com.aula.pomonooo.strategy.role;

public class Developer implements RoleStrategy {
    private String name = Developer.class.getSimpleName();

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String answerCustomer(String message, int clientId) {
        // TODO: implement answerCustomer
        return "Respondendo chamado";
    }

    @Override
    public String sendReport(String report, String email) {
        // TODO: implement sendReport
        return "Enviando relatório de correção de bugs";
    }
}

