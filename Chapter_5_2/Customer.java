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

    @Override
    public void run() {
        try {
        for (int i = 0; i < tickets.getAvailableTickets(); i = ticketsToBuy) {
            tickets.removeTicketfromTotal(i);
            }
        } 
        catch (ArithmeticException e) {
            System.err.println(e);
        }
    }
}
