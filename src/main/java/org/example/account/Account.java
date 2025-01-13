package org.example.account;

import java.util.Objects;

public abstract class Account {

    private String number;
    private String owner;
    private Double summa;
    private final Integer statusCode = 1;
    private StatusAccount statusAccountWithEnum;

    public Account(String number, String owner, Double summa, StatusAccount statusAccountWithEnum) {
        this.number = number;
        this.owner = owner;
        this.summa = summa;
        this.statusAccountWithEnum = statusAccountWithEnum;
    }

    public Account() {
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(number, account.number) && Objects.equals(owner, account.owner) && Objects.equals(summa, account.summa) && Objects.equals(statusCode, account.statusCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, owner, summa, statusCode);
    }

    @Override
    public String toString() {
        return "account.Account{" +
                "number='" + number + '\'' +
                ", owner='" + owner + '\'' +
                ", summa=" + summa +
                ", statusCode=" + statusCode +
                ", statusAccountWithEnum=" + statusAccountWithEnum +
                '}';
    }

    public abstract void checkStatus();

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Double getSumma() {
        return summa;
    }

    public void setSumma(double summa) {
        this.summa = summa;
    }

    public StatusAccount getStatusAccountWithEnum() {
        return statusAccountWithEnum;
    }

    public void setStatusAccountWithEnum(StatusAccount statusAccountWithEnum) {
        this.statusAccountWithEnum = statusAccountWithEnum;
    }

    private Boolean enoughMoney(Double moneySum){
        String accountNumber = getNumber();
        return (getSumma() - moneySum) >= 0;
    }

    public final String withdrawMoney(Double moneySum){
        boolean enoughMoney = enoughMoney(moneySum);

        if (enoughMoney){
            setSumma(getSumma() - moneySum);
            return "С вашего счёта успешно снята сумма " + moneySum + ". Текущий баланс счёта: " + getSumma();
        }else{
            return "Недостаточно средств для снятия наличности с вашего счёта";
        }
    }
}
