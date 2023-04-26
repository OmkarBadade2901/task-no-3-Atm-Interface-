import java.util.ArrayList;

public class TransHistory {
    private ArrayList <String> localDateTime;
    private ArrayList <String> operation;
    private ArrayList <Long> amount;
    private int count;

    public TransHistory() {
        localDateTime = new ArrayList<>();
        operation = new ArrayList<>();
        amount= new ArrayList<>();
        count = 0;
    }

    public void add(String string, String operation, long amount) {
        this.localDateTime.add(string) ;
        this.operation.add(operation);
        this.amount.add(amount);
        count++;
    }

    public void print(){
        System.out.printf("%-11s%-9s%-12s%-10s%n","Date","Time","Operation","Amount");
        for(int i=0;i<count;i++){
            System.out.printf("%-20s%-12s%-10d%n",localDateTime.get(i),operation.get(i),amount.get(i));
        }
    }

    

}
