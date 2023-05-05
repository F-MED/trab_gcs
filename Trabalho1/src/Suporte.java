import java.util.*;

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

    public void printChamados() {
        for (Chamado c : chamados) {
            System.out.println(c.toString());
        }
    }

    public boolean statusChamado(int idChamdo) {
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
        if(chamado.getResolucao() != null){
            if(chamado.getResolucao().contains(termoDeBusca)){
                return true;
            }
        }
        if (chamado.getFuncionarioQueAbriu().getNome().contains(termoDeBusca) ||
                chamado.getDesc().contains(termoDeBusca) ||
                chamado.getEquipamentoSuporte().getDepartamento().getNome().contains(termoDeBusca) ||
                chamado.getDesc().contains(termoDeBusca)) {
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
            if (c.getStatus().equals("Aberto")) {
                count++;
            }
        }
        return count;
    }

    public int numeroDeChamadosAndamento() {
        int count = 0;
        for (Chamado c : chamados) {
            if (c.getStatus().equals("Em andamento")) {
                count++;
            }
        }
        return count;
    }

    public int numeroDeChamadosConcluido() {
        int count = 0;
        for (Chamado c : chamados) {
            if (c.getStatus().equals("Concluido")) {
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

    public ArrayList<Funcionario> maisChamados() {
        ArrayList<Funcionario> maisC = new ArrayList<>();
        int maior = 0;

        for (int j = 0; j < chamados.size(); j++) {
            int chamds = 0;
            Funcionario auxFuncionario = chamados.get(j).getFuncionarioQueAbriu() ;
            for (int i = 0; i < chamados.size(); i++) {
                if (chamados.get(i).getFuncionarioQueAbriu().getID() == auxFuncionario.getID()) {
                    chamds++;
                }
            }
            if (chamds >= maior) {
                maior = chamds;
                maisC.add(auxFuncionario);
            }
        }
        return maisC;
    }

    public ArrayList<Chamado> getChamadosDate(GregorianCalendar data) {
        ArrayList<Chamado> chamadosdata = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < chamados.size(); i++) {
            if (chamados.get(i).getDataAberto().equals(data)) {
                chamadosdata.add(chamados.get(i));
            }
        }
        return chamadosdata;
    }

    public boolean equipamentosTemSup(Equipamento equipamento) {
        for(int i = 0; i < chamados.size(); i++){
            if(equipamento.getID()==chamados.get(i).getEquipamentoSuporte().getID()){
                return true;
            }
        }
        return false;
    }
}
