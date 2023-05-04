import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Suporte extends Departamento {
    private ArrayList<Chamado> chamados;

    public Suporte(int idDepart) {
        super("Departamento de Suporte", idDepart);
        chamados = new ArrayList<Chamado>();
    }

    public ArrayList<Chamado> getChamados() {
        return chamados;
    }

    public ArrayList<Chamado> listaChamadosPorEquipamentoId(int equipamentoId) {
        ArrayList<Chamado> chamados = new ArrayList<>();
        for (Chamado x : this.getChamados()) {
            if (x.getEquipamentoSuporte().getID() == equipamentoId)
                chamados.add(x);
        }
        ordenaLista(chamados);
        return chamados;
    }

    private boolean chamadoContemTermo(Chamado chamado, String termoDeBusca) {
        if (chamado.getFuncionarioQueAbriu().getNome().contains(termoDeBusca) ||
                chamado.getDesc().contains(termoDeBusca) ||
                chamado.getEquipamentoSuporte().getDepartamento().getNome().contains(termoDeBusca) ||
                chamado.getDesc().contains(termoDeBusca) ||
                chamado.getResolucao().contains(termoDeBusca)) {
            return true;
        }
        return false;
    }

    public ArrayList<Chamado> listaChamado(String termoDeBusca) {
        ArrayList<Chamado> resultado = new ArrayList<Chamado>();

        for (Chamado chamado : this.getChamados()) {
            if (chamadoContemTermo(chamado, termoDeBusca)) {
                resultado.add(chamado);
            }
        }

        return resultado;
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
