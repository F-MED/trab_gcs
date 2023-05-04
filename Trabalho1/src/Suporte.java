import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class Suporte extends Departamento {
    private ArrayList<Chamado> chamados;

    public Suporte(int idDepart) {
        super("Departamento de Suporte", idDepart);
        chamados = new ArrayList<Chamado>();
    }

    public ArrayList<Chamado> getChamados() {
        return chamados;
    }

    public Chamado pesquisaChamado(int id) {
        for (Chamado e : chamados) {
            if (id == e.getIDCHAMADO()) {
                return e;
            }
        }
        return null;
    }

    public boolean statusChamado(int idFunc, int idChamdo) {
        if (funcionarioEstaDepartamento(idFunc)) {
            Chamado aux = pesquisaChamado(idChamdo);
            if (aux != null) {
                if (aux.getStatus().equals("Aberto")) {
                    aux.setStatus("Em andamento");
                    return true;
                } else if (aux.getStatus().equals("Em andamento")) {
                    aux.setStatus("Concluido");
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
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

    public Chamado procuraChamadoID(int id) {
        for (Chamado c : chamados) {
            if (c.getIDCHAMADO() == id)
                return c;
        }
        return null;
    }

    public boolean addChamado(Chamado chamado) {
        return chamados.add(chamado);
    }

    public int numeroDeChamados() {
        return chamados.size();
    }

    public int numeroDeChamadosAberto() {
        int count = 0;
        for (Chamado c : chamados) {
            if (c.getStatus().equals("aberto")) {
                count++;
            }
        }
        return count;
    }

    public int numeroDeChamadosAndamento() {
        int count = 0;
        for (Chamado c : chamados) {
            if (c.getStatus().equals("em andamento")) {
                count++;
            }
        }
        return count;
    }

    public int numeroDeChamadosConcluido() {
        int count = 0;
        for (Chamado c : chamados) {
            if (c.getStatus().equals("concluido")) {
                count++;
            }
        }
        return count;
    }

    public boolean moverEquipamento(Equipamento equipamento, Departamento departamentoDestino,
            Funcionario funcionario) {
        if (funcionario.getDepartamento() instanceof Suporte) {
            equipamento.getDepartamento().removeEquipamento(equipamento);
            equipamento.setDepartamento(departamentoDestino);
            departamentoDestino.addEquipamento(equipamento);
            return true;
        }
        return false;
    }

    public ArrayList<Funcionario> funcionariosComChamados() {
        ArrayList<Funcionario> list = new ArrayList<>();
        ArrayList<Chamado> chamados = getChamados();

        for (int i = 0; i < chamados.size(); i++) {
            if (!(list.contains(chamados.get(i).getFuncionarioQueAbriu()))) {
                list.add(chamados.get(i).getFuncionarioQueAbriu());
            }
        }
        return list;
    }

    public boolean removeChamado(int id) {
        for (Chamado c : chamados) {
            if (c.getIDCHAMADO() == id) {
                chamados.remove(c);
                return true;
            }
        }
        return false;
    }

    public Funcionario maisChamados() {
        Funcionario maisC = null;
        int maior = 0;

        for (int j = 0; j < getFuncionarios().size(); j++) {
            int chamds = 0;
            for (int i = 0; i < chamados.size(); i++) {
                if (chamados.get(i).getFuncionarioQueAbriu() == getFuncionarios().get(j)) {
                    chamds++;
                }
            }
            if (chamds > maior) {
                maior = chamds;
                maisC = getFuncionarios().get(j);
            }
        }
        return maisC;
    }

    public Chamado[] getChamadosDate(Date data) {
        Chamado chamadosdata[] = new Chamado[chamados.size()];
        int j = 0;
        for (int i = 0; i < chamados.size(); i++) {
            if (chamados.get(i).getDataAberto() == data) {
                chamadosdata[j] = chamados.get(i);
                j++;
            }
        }
        return chamadosdata;
    }

    public ArrayList<Equipamento> equipamentosSemSup() {
        ArrayList<Equipamento> aux = new ArrayList<>();
        int equip = 0;
        int k = 0;

        for (int j = 0; j < getEquipamentos().size(); j++) {
            for (int i = 0; i < chamados.size(); i++) {
                if (chamados.get(i).getEquipamentoSuporte() != getEquipamentos().get(j)) {
                    equip++;
                    if (equip == chamados.size()) {
                        aux.add(k, getEquipamentos().get(j));
                        k++;
                    }
                }

            }
        }
        return aux;
    }
}
