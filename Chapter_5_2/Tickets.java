package Chapter_5_2;

public class Tickets {
    private int totalAvailableTickets;

    public Tickets (int totalAvailableTickets){
        this.totalAvailableTickets = totalAvailableTickets;
    }

    public synchronized int getAvailableTickets () {
        return totalAvailableTickets;
    }

    public synchronized void tryToPurchaseTickets (int ticketsQuantity) {
        if (ticketsQuantity > totalAvailableTickets) {
            throw new ArithmeticException("Out of tickets.");
        }
        totalAvailableTickets -= ticketsQuantity;
    }

}

