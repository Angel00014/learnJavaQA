import java.text.DecimalFormat;

public class Account {

    private String number;
    private String owner;
    private Double summa;
    private final Integer statusCode = 1;

    public Account(String number, String owner, Double summa) {
        this.number = number;
        this.owner = owner;
        this.summa = summa;
    }

    public Account() {
    }

    public void checkStatus(){
        System.out.println("Статус счёта");
    }

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

    private Boolean enoughMoney(Double moneySum){
        String accountNumber = getNumber();
        return (getSumma() - moneySum) >= 0;
    }

    public String withdrawMoney(Double moneySum){
        boolean enoughMoney = enoughMoney(moneySum);

        if (enoughMoney){
            setSumma(getSumma() - moneySum);
            return "С вашего счёта успешно снята сумма " + moneySum + ". Текущий баланс счёта: " + getSumma();
        }else{
            return "Недостаточно средств для снятия наличности с вашего счёта";
        }
    }
}
