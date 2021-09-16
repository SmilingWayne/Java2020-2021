package accountTest;
//面向对象练习1：
public class accounttest {
    public static void main(String[] args){

    }
}

/**
 * 这是面向对象编程的测试用例
 */
class Account{
    protected int  accountNumber;
    protected double balance;

    public Account(int number){
        this.accountNumber = number;
        balance = 0;
    }
    public Account(double balance){
        this.balance = balance;
        accountNumber = 0;
    }
    public void credit(int number){
        balance+=number;
    }
    public void setNumber(int number){
        accountNumber = number;
    }
    public void setBalance(double balances){
        balance = balances;
    }
    public void debit(int number){
        balance-=number;
        if(balance < 0){
            System.out.println("None");
        }
    }
    public void getBalance(){
        System.out.printf("%.2lf",balance);
    }
    public void getNumber(){
        System.out.printf("%d",accountNumber);
    }
    @Override
    public String toString(){
        return String.format("A/c:no%d, Balance =$%.2lf",accountNumber,balance);
    }
}




