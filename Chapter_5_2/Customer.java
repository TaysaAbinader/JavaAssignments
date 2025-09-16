package Chapter_5_2;

public class Customer implements Runnable {
    private int id;
    private static int idCounter = 0;
    private int ticketsToBuy = 0;
    private Tickets tickets;

    public Customer(int ticketsToBuy, Tickets tickets) {
        this.ticketsToBuy = ticketsToBuy;
        this.tickets = tickets;
        this.id = ++idCounter;
    }

    public int getId () {
        return this.id;
    }

    public int getTicketsToBuy () {
        return this.ticketsToBuy;
    }

    @Override
    public void run() {
        try {
            tickets.tryToPurchaseTickets(ticketsToBuy);
            System.out.println("Customer " + this.id + " reserved " + ticketsToBuy + " tickets.");
        }
        catch (ArithmeticException e) {
            System.err.println("Customer " + this.id + " couldn't reserve " + ticketsToBuy + " tickets.");
        }
    }
}
