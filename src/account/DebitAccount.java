package account;

public class DebitAccount extends Account{

    private Double cashbackLevel;

    public DebitAccount(String number, String owner, Double summa, StatusAccount statusAccountWithEnum) {
        super(number, owner, summa, statusAccountWithEnum);
    }

    @Override
    public void checkStatus() {
        System.out.println("Показать статус дебетового счёта");
    }

    public Double getCashbackLevel() {
        return cashbackLevel;
    }

    public void setCashbackLevel(Double cashbackLevel) {
        this.cashbackLevel = cashbackLevel;
    }
}
