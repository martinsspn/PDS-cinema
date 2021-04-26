package PDSFramework.service;

import PDSFramework.model.*;

public interface iAdministradorService {
    int cadastrarCupons(String _Cupom, double tipoDeCupom);
    int cadastrarPremios(String descricao, int id, int condicao);

    Cupom buscarCupons(String codigo);
    Premio buscarPremio(int codigo);

    int removerCupons(Cupom cupom);
    int removerPremios(Premio premio);
}
