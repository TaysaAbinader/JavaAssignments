package Chapter_5_2;

public class TicketBuyingSystem {

    public static void main(String[] args) {
        Tickets theater = new Tickets(70);

        

        Thread[] customerList = new Thread[10];
        for (int i = 0; i < customerList.length; i++) {
            int ticketsToBuy = (int) (Math.random() * 10);
            customerList[i] = new Thread(new Customer(ticketsToBuy, theater));
            System.out.println("Costumer " + (i+1) + " bought: " + ticketsToBuy);
            customerList[i].start();
        }
        

        for (int i = 0; i < customerList.length; i++) {
            try {
                customerList[i].join();
            } catch (InterruptedException e) {
                System.err.println(e);
            } 
            
        }
        System.out.println("Tickets left: " + theater.getAvailableTickets());  
    }
}
