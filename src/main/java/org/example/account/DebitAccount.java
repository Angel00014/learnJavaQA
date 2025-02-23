package org.example.account;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DebitAccount extends Account{

    private Double cashbackLevel;

    public DebitAccount(String number, String owner, Double summa, StatusAccount statusAccountWithEnum) {
        super(number, owner, summa, statusAccountWithEnum);
    }

    @Override
    public Double getSumma() {
        return super.getSumma();
    }

    @Override
    public String getOwner() {
        return super.getOwner();
    }

    @Override
    public String getNumber() {
        return super.getNumber();
    }

    @Override
    public StatusAccount getStatusAccountWithEnum() {
        return super.getStatusAccountWithEnum();
    }

    @Override
    public void checkStatus() {
        System.out.println("Показать статус дебетового счёта");
    }

}
