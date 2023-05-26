package com.aula.pomonooo.strategy.role;

public class Analyst implements RoleStrategy {
    private String name = Analyst.class.getSimpleName();

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
        return "Informando análise do banco de dados";
    }

    @Override
    public String sendReport(String report, String email) {
        // TODO: implement sendReport
        return "Reportando processo de modelagem de dados";
    }
}
