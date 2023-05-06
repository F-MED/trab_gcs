public class Funcionario {
    private final int IDFUNC; // atributo final por ser o atributo identificador e nao devera ser mudado
    private String nome;
    private Departamento departamento;

    public Funcionario(int ID, String nome, Departamento departamento) {
        this.IDFUNC = ID;
        this.nome = nome;
        this.departamento = departamento;
    }

    public int getID() {
        return IDFUNC;
    }

    public String getNome() {
        return nome;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        String aux = "id:" + IDFUNC + " nome:" + nome + " departamento:" + departamento.getNome();
        return aux;
    }
}
