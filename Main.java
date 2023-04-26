import java.util.Scanner;

public class Main{   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String user_id="";
        int pin=0;
        boolean externalExit=false;
        boolean internalExit=false;
        Account currAccount=null;
        Account account1= new Account("omkar29", 1234, 1234567, 2000);
        Account account2= new Account("suyesh34",2345,987654321,300);
        do{

        System.out.print("Enter your user id: ");
        user_id=sc.next();
        System.out.print("Enter your pin: ");
        pin=sc.nextInt();
        if(account1.verify(user_id,pin))
            currAccount=account1;
        else if(account2.verify(user_id,pin))
            currAccount=account2;
        else{
            System.out.println("you enter wrong credentials!!!");
            continue;
        }
        do{
            int choice=0;
            System.out.println("\n1.Transaction History\n2.Deposit\n3.Withdraw\n4.Transfer\n5.Exit");
            System.out.println("Enter your choice: ");
            choice=sc.nextInt();
            switch(choice){
                case 1 -> {
                    currAccount.printTransHistory();
                    
                }
                case 2 -> {
                    System.out.println("Enter the the amount: ");
                    currAccount.deposit(sc.nextLong());
                    System.out.println("You have successfully deposited the amount!!");
                    
                }
                case 3 -> {
                    System.out.println("Enter the the amount: ");
                    if(!currAccount.withdraw(sc.nextLong()))
                    System.out.println("You have less balance than withdraw amount");
                    
                }
                case 4 -> {
                    System.out.println("enter the account no: ");
                    long accountNo = sc.nextLong();
                    System.out.println("enter the amount: ");
                    long amount = sc.nextLong();
                    if(account2.getAccount_no()==accountNo && currAccount.withdraw(amount)){
                        account2.deposit(amount);
                        System.out.println("You have successfully transfer the amount of "+amount+" to account no. " +accountNo);
                    }
                    else
                        System.out.println("Something wrong!!!");
                    
                }
                case 5 -> internalExit=true;
            }
            
        }while(!internalExit);
            internalExit=false;
            System.out.println("Do you want to continue(Y|N): ");
            char ch=sc.next().charAt(0);
            if(ch=='N'||ch=='n') externalExit= true;
        }while(!externalExit);
        sc.close();
    }
    
}