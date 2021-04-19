package PDSCinema.service;

import PDSCinema.model.*;
import PDSCinema.repository.CinemaRepository;


import java.io.IOException;
import java.util.ArrayList;

public interface iAdministradorService {
    int cadastrarCupons(String _Cupom, double tipoDeCupom);
    int cadastrarPremios(String descricao, int id, int condicao);

    Cupom buscarCupons(String codigo);
    Premio buscarPremio(int codigo);

    int removerCupons(Cupom cupom);
    int removerPremios(Premio premio);
}
