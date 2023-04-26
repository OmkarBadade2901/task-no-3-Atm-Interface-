import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Account {
   private long accountNo;
   private String user_id;
   private int pin;
   private long balance;
   private TransHistory transHistory;
   private String pattern ="yyyy-MM-dd hh:mm:ss";

   public Account(String user_id,int pin,long accountNo, long balance){
    this.user_id=user_id;
    this.pin=pin;
    this.accountNo=accountNo;
    this.balance=balance;
    transHistory = new TransHistory();
   }

   public long getBalance(){
    return this.balance;
   }

    public long getAccount_no() {
    return accountNo;
    }

    public String getUser_id() {
    return user_id;
    }

    public boolean withdraw(long amount){
        if(this.balance>=amount) {
            this.balance-=amount;
            transHistory.add(LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern)), "withdraw", amount);
           return true;
        }

        return false;
    }

    public void deposit(long amount){
        this.balance+=amount;
        transHistory.add(LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern)), "deposit", amount);
    }

    public boolean verify(String user_id,int pin){
        if(this.pin== pin && this.user_id.equals(user_id)) return true;
        return false;
    }

    public void printTransHistory(){
        System.out.println();
        transHistory.print();
        System.out.println("Total balance: "+getBalance());
    }


   
}
