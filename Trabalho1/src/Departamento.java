import java.util.ArrayList;

public class Departamento {
    private final int IDDEPART; // atributo final por ser o atributo identificador e nao devera ser mudado
    private ArrayList<Funcionario> funcionarios; // a "lista" dos funcionrios do departamento
    private ArrayList<Equipamento> equipamentos; // a "lista" dos equipamentos do departamento
    private String nome; // o nome do departamento

    // metodo construtor
    public Departamento(String nome, int idDepart) {
        funcionarios = new ArrayList<Funcionario>(); // inicializando o ArrayList
        equipamentos = new ArrayList<Equipamento>(); // inicializando o ArrayList
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

    /*
     * se algumem tiver duvida sobre funcionario.setDepartamento(this);
     * basicamente usar o this(só this, nao this.algumaCoisa) tu referencia o
     * proprio objeto que o metodo esta sendo executado
     * se tivesse um objeto departamento com o nome do objeto de
     * departamentoDeCiencias
     * se tu rodasse -> departamentoDeCiencias.add(funcionario)
     * o que ia acontecer era
     * if(adicionado){
     * funcionario.setDepartamento(departamentoDeCiencias);
     * return true;
     * }
     * else{
     * return false;
     * }
     */

    public boolean addFuncionario(Funcionario funcionario) { // adiciona funcionarios na "lista" de funcionarios
        boolean adicionado = funcionarios.add(funcionario);
        if (adicionado) { // usa o valor de adicionado para validar o if, não precisando usar
                          // adiconado==true
            funcionario.setDepartamento(this); // autoreferencia para o departamento que o funcionario esta sendo
                                               // adicionado
            return true;
        } else {
            return false;
        }
    }

    public boolean addEquipamento(Equipamento equipamento) {// adiciona equipamentos na "lista" de equipamentos
        boolean adicionado = equipamentos.add(equipamento);
        if (adicionado) { // usa o valor de adicionado para validar o if, não precisando usar
                          // adiconado==true
            equipamento.setDepartamento(this); // autoreferencia para o departamento que o funcionario esta sendo
                                               // adicionado
            return true;
        } else {
            return false;
        }
    }

    public boolean funcionarioEstaDepartamento(int id) {
        // se acharem mais apropriado, penso que seria bem de boa de mudar o id por um
        // objeto funcionario
        for (Funcionario f : funcionarios) {
            if (id == f.getID()) {
                return true;
            }
        }
        return false;
        /*
         * dai seria mais ou menos assim
         * public boolean funcionarioEstaDepartamento(Funcionario func){
         * for (Funcionario f : funcionarios){
         * if(func==f.getID()){
         * return true;
         * }
         * }
         * return false;
         * }
         */
    }

    public boolean equipamentoEstaDepartamento(int id) {
        for (Equipamento e : equipamentos) {
            if (id == e.getID()) {
                return true;
            }
        }
        return false;

    }

    public ArrayList<Equipamento> pesquisaEquipamento(String descricao) {
        ArrayList<Equipamento> auxiliar = new ArrayList<>();

        for (int i = 0; i < equipamentos.size(); i++) {
            if (descricao.equals(equipamentos.get(i).getDescricao())) {
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
