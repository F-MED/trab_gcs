import java.util.ArrayList;

public class Departamento {
    private final int IDDEPART; // atributo final por ser o atributo identificador e nao devera ser mudado
    private ArrayList<Funcionario> funcionarios; // a "lista" dos funcionrios do departamento
    private ArrayList<Equipamento> equipamentos; // a "lista" dos equipamentos do departamento
    private String nome; // o nome do departamento

    //Método construtor
    public Departamento(String nome, int idDepart) {
        funcionarios = new ArrayList<Funcionario>(); 
        equipamentos = new ArrayList<Equipamento>();
        this.nome = nome;
        this.IDDEPART = idDepart;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public ArrayList<Equipamento> getEquipamentos() {
        return equipamentos;
    }

    public String getNome() {
        return nome;
    }

    public int getID() {
        return IDDEPART;
    }

    public boolean addFuncionario(Funcionario funcionario) { // adiciona funcionarios na "lista" de funcionarios
        boolean adicionado = funcionarios.add(funcionario);
        if (adicionado) { 
            funcionario.setDepartamento(this);
            return true;
        } else {
            return false;
        }
    }

    public boolean addEquipamento(Equipamento equipamento) {// adiciona equipamentos na "lista" de equipamentos
        boolean adicionado = equipamentos.add(equipamento);
        if (adicionado) { 
            equipamento.setDepartamento(this); 
            return true;
        } else {
            return false;
        }
    }

    public boolean funcionarioEstaDepartamento(int id) {
        for(Funcionario f : funcionarios) {
            if(id == f.getID()) return true;
        }
        return false;
    }

    public boolean equipamentoEstaDepartamento(int id) {
        for(Equipamento e : equipamentos) {
            if(id == e.getID()) return true;
        }
        return false;
    }

    public ArrayList<Equipamento> pesquisaEquipamento(String descricao) {
        ArrayList<Equipamento> auxiliar = new ArrayList<>();

        for(int i = 0; i < equipamentos.size(); i++) {
            if(descricao.equals(equipamentos.get(i).getDescricao())) {
                auxiliar.add(equipamentos.get(i));
            }
        }
        return auxiliar;
    }

    public boolean removeEquipamento(Equipamento equipamento) {
        return equipamentos.remove(equipamento);
    }

    public boolean removeFuncionario(Funcionario funcionario) {
        return funcionarios.remove(funcionario);
    }
}
