package ProjectAssignments;

public class Customer {
    private int id; //32 bits
    private long timeStart; //64 bits
    private long timeEnd; //64 bits
    private static int _id = 1;


    private Customer(){
        this.id = _id++;

    }
    public int getId() {
        return id;
    }

    public long getTimeStart() {
        return timeStart;
    }

    public void getTimeEnd() {
        return timeEnd;
    }

    public void setTimeStart(long timeStart) {
        this.timeStart = timeStart;
    }

    public void setTimeEnd(long timeEnd) {
        this.timeStart = timeStart;
    }

    //returns the time in seconds the customer has spent in the system
    public double timeSpend() {
        return timeEnd - timeStart;
    }

    public static void main(String[] args) {
        Customer customer = new Customer();
        Customer customer2 = new Customer();

        customer.setTimeStart(_id);
        customer2.setTimeStart(_id);

        //customer entering system
        System.currentTimeMillis();

        //waiting for 1 second
        try {
            Thread.sleep(1000);  // 1000 ms = 1s
          } catch (InterruptedException e) {
            e.printStackTrace();
          }

        //customer is ready
        customer.setTimeEnd(System.currentTimeMillis())

        System.out.println("Customer servicing time: " + );
        
    }

}
