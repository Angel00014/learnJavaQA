package org.example.account;

import lombok.*;

@Data
@NoArgsConstructor
public class CreditAccount extends Account implements CheckFunctionality {

    private Double creditLimit = 0.00;

    public CreditAccount(Double summa, String number, String owner,  StatusAccount statusAccountWithEnum, Double creditLimit) {
        super(number, owner, summa, statusAccountWithEnum);
        this.creditLimit = creditLimit;
    }

    @Override
    public void checkStatus() {
        System.out.println("Показать статус кредитного счёта");
    }

    public void checkLimit(){
        System.out.println("Ваш лимит: " + creditLimit);
    }


    @Override
    public void checkFunctionality() {
        System.out.println("Счёт функционирует. Проблем не обнаружено.");
    }
}
