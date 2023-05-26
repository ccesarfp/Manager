package com.aula.pomonooo.strategy.role;

public class CustomerService implements RoleStrategy {
    private String name = CustomerService.class.getSimpleName();

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
        return "Respondendo sobre proposta de Cliente";
    }

    @Override
    public String sendReport(String report, String email) {
        // TODO: implement sendReport
        return "Avisando sobre novidades";
    }
}
