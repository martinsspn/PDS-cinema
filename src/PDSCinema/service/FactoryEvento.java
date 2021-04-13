package PDSCinema.service;

public class FactoryEvento {
    private EventoCinema cinema = new EventoCinema();
    private EventoCirco circo = new EventoCirco();
    private EventoEvMusical evMusical = new EventoEvMusical();

    public EventoCinema getCinema() {
        return cinema;
    }

    public void setCinema(EventoCinema cinema) {
        this.cinema = cinema;
    }

    public EventoCirco getCirco() {
        return circo;
    }

    public void setCirco(EventoCirco circo) {
        this.circo = circo;
    }

    public EventoEvMusical getEvMusical() {
        return evMusical;
    }

    public void setEvMusical(EventoEvMusical evMusical) {
        this.evMusical = evMusical;
    }
}
