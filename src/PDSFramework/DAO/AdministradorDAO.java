package PDSFramework.DAO;

import PDSFramework.model.Cupom;
import PDSFramework.model.Evento;
import PDSFramework.model.Premio;

public interface AdministradorDAO{

    void cadastrarCupons(String _Cupom, double tipoDeCupom);
    void cadastrarPremios(String descricao, int id, int condicao);

    Evento buscarEvento(String nome);
    Cupom buscarCupons(String codigo);
    Premio buscarPremio(int codigo);
    int removerEvento(Evento evento);
    int removerCupons(Cupom cupom);
    int removerPremios(Premio premio);
}
