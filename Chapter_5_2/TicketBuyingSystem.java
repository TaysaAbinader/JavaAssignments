package Chapter_5_2;

public class TicketBuyingSystem {

    public static void main(String[] args) {
        Tickets theater = new Tickets(30);

        System.out.println("Available tickets: " + theater.getAvailableTickets());

        Thread[] customerList = new Thread[10];
        for (int i = 0; i < customerList.length; i++) {

            //Test 2
            int ticketsToBuy = (int) (Math.random() * 10);
            customerList[i] = new Thread(new Customer(ticketsToBuy, theater));
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
