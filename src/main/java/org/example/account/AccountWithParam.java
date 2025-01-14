package org.example.account;

public class AccountWithParam<T> extends Account{


    private T accountParam;

    public static Integer counter = 0;

    public AccountWithParam(String number, String owner, Double summa, StatusAccount statusAccountWithEnum, T accountParam) {
        super(number, owner, summa, statusAccountWithEnum);
        this.accountParam = accountParam;
        counter++;
    }

    public static Integer getCounter() {
        return counter;
    }

    @Override
    public void checkStatus() {
        System.out.println("Параметр счёта: " + accountParam);
    }
}
