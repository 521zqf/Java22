import java.util.List;

public class TicketService {
    private TicketDAO ticketDAO = new TicketDAO();

    public List<Ticket> getAllTickets() {
        return ticketDAO.getAllTickets();
    }

    public Ticket getTicketById(Long id) {
        return ticketDAO.getTicketById(id);
    }

    public void saveTicket(Ticket ticket) {
        ticketDAO.saveTicket(ticket);
    }

    public void deleteTicket(Long id) {
        ticketDAO.deleteTicket(id);
    }
}