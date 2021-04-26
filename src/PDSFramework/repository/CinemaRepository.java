package PDSFramework.repository;

import PDSFramework.model.*;

import java.util.ArrayList;
import java.util.List;

public abstract class CinemaRepository extends EventoRepository{
    private static List<Integer> salas = new ArrayList<>();
    private static List<Filme> filmesEmCartaz = new ArrayList<>();
    private static List<String> horarios = new ArrayList<>();
    private static List<Integer> avaliacoesHorarios = new ArrayList<>();
    private static List<Integer> quantAvHorarios = new ArrayList<>();

    /*
    public CinemaRepository() {
        CinemaRepository.salas = new ArrayList<>();
        CinemaRepository.filmesEmCartaz = new ArrayList<>();
        CinemaRepository.horarios = new ArrayList<>();
        CinemaRepository.avaliacoesServico = 0;
        CinemaRepository.avaliacoesHorarios = new ArrayList<>();
        CinemaRepository.quantAvServico = 0;
        CinemaRepository.quantAvHorarios = new ArrayList<>();
        CinemaRepository.medias = new ArrayList<>();
        CinemaRepository.listaDeCupons = new HashMap<>();
        CinemaRepository.listaDePremios = new HashMap<>();
        horarios.add("12h30min");
        horarios.add("13h00min");
        horarios.add("13h30min");
        horarios.add("14h00min");
        horarios.add("14h30min");
        horarios.add("15h30min");
        horarios.add("17h00min");
        horarios.add("18h30min");
        horarios.add("20h00min");
        for(int i=0;i<10;i++){
            avaliacoesHorarios.add(0);
            quantAvHorarios.add(0);
        }

    }
*/
    public static List<Integer> getSalas() {
        return salas;
    }

    public static void setSalas(List<Integer> salas) {
        CinemaRepository.salas = salas;
    }

    public static List<Filme> getFilmesEmCartaz() {
        return filmesEmCartaz;
    }

    public static void setFilmesEmCartaz(List<Filme> filmesEmCartaz) {
        CinemaRepository.filmesEmCartaz = filmesEmCartaz;
    }

    public static List<Integer> getAvaliacoesHorarios() {
        return avaliacoesHorarios;
    }

    public static void setAvaliacoesHorarios(List<Integer> avaliacoesHorarios) {
        CinemaRepository.avaliacoesHorarios = avaliacoesHorarios;
    }

    public static List<String> getHorarios() {
        return horarios;
    }

    public static void setHorarios() {
        horarios.add("12h30min");
        horarios.add("13h00min");
        horarios.add("13h30min");
        horarios.add("14h00min");
        horarios.add("14h30min");
        horarios.add("15h30min");
        horarios.add("17h00min");
        horarios.add("18h30min");
        horarios.add("20h00min");
    }

    public static List<Integer> getQuantAvHorarios() {
        return quantAvHorarios;
    }

    public static void setQuantAvHorarios(List<Integer> quantAvHorarios) {
        CinemaRepository.quantAvHorarios = quantAvHorarios;
    }
}

