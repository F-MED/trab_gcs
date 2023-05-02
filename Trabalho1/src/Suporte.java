import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Suporte extends Departamento{
    private ArrayList<Chamado> chamados;

    public Suporte(int idDepart) {
        super("Departamento de Suporte", idDepart);
        chamados = new ArrayList<Chamado>();
    }

    public ArrayList<Chamado> getChamados() {
        return chamados;
    }

    public Chamado pesquisaChamado(int id) {
        for(Chamado e : chamados){
            if(id==e.getIDCHAMADO()){
                return e;
            }
        }
        return null;
    }

    public boolean statusChamado(int idFunc, int idChamdo) {
        if(funcionarioEstaDepartamento(idFunc)){
            Chamado aux = pesquisaChamado(idChamdo);
            if(aux != null){
                if(aux.getStatus().equals("Aberto")){
                    aux.setStatus("Em andamento");
                    return true;
                }else if(aux.getStatus().equals("Em andamento")){
                    aux.setStatus("Concluido");
                    return true;
                }else{
                    return false;
                }
            }
        }
        return false;
    }

    public ArrayList<Chamado> listaChamados(int id) {
        ArrayList<Chamado> chamados = new ArrayList<>();
        for(Chamado x: this.getChamados()) {
            if (x.getEquipamentoSuporte().getID() == id)
                chamados.add(x);
        }
        ordenaLista(chamados);
        return chamados;
    }
    public void ordenaLista(ArrayList<Chamado> lista) {
        Collections.sort(lista, new Comparator<Chamado>() {
            public int compare(Chamado o1, Chamado o2) {
                if (o1.getDataAberto() == null || o2.getDataAberto() == null)
                    return 0;
                return o1.getDataAberto().compareTo(o2.getDataAberto());
            }
        });
    }

    public boolean moverEquipamento(Equipamento equipamento, Departamento departamentoDestino, Funcionario funcionario) {
        if (funcionario.getDepartamento() instanceof Suporte) {
            equipamento.getDepartamento().removeEquipamento(equipamento);
            equipamento.setDepartamento(departamentoDestino);
            departamentoDestino.addEquipamento(equipamento);
            return true;
        }
        return false;
    } 
}
