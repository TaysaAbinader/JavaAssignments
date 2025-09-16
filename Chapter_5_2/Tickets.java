package Chapter_5_2;

public class Tickets {
    private int totalAvailableTickets;

    public Tickets (int totalAvailableTickets){
        this.totalAvailableTickets = totalAvailableTickets;
    }

    public synchronized int getAvailableTickets () {
        return totalAvailableTickets;
    }

    public synchronized int removeTicketfromTotal (int ticketsquantity) {
        if (ticketsquantity > totalAvailableTickets) {
            System.err.println("There aren't " + ticketsquantity + " available.");
            throw new ArithmeticException("Out of tickets.");

        }
        return totalAvailableTickets -= ticketsquantity;

    }

}

