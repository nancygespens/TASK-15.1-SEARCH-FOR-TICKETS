import java.util.Arrays;

public class TicketManager {

    private final TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] result = new Ticket[0];
        TicketRepository tmp = new TicketRepository();
        for (Ticket ticket : repository.getTickets()) {
            if (matches(ticket, from, to)) {
                tmp.addTicket(ticket);
                result = tmp.getTickets();
            }
        }
        Arrays.sort(result);
        return result;
    }

    private boolean matches(Ticket ticket, String from, String to) {
        return ticket.matches(from, to);
    }
}
