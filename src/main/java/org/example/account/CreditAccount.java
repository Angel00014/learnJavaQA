package org.example.account;

public class CreditAccount extends Account implements CheckFunctionality {

    private Double creditLimit = 0.00;

    public CreditAccount(String number, String owner, Double summa, StatusAccount statusAccountWithEnum, Double creditLimit) {
        super(number, owner, summa, statusAccountWithEnum);
        this.creditLimit = creditLimit;
    }

    public CreditAccount() {
    }

    @Override
    public void checkStatus() {
        System.out.println("Показать статус кредитного счёта");
    }

    public Double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public void checkLimit(){
        System.out.println("Ваш лимит: " + creditLimit);
    }


    @Override
    public void checkFunctionality() {
        System.out.println("Счёт функционирует. Проблем не обнаружено.");
    }
}
