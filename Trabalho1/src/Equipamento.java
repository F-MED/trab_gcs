import java.util.Date;
//api do Date: https://docs.oracle.com/javase/8/docs/api/java/util/Date.html

public class Equipamento{
    private final int IDEQUIP;
    private Date data; // pensei em usar final, mas deixei sem por que imaginei que a data seria informada pelo usuario
    private String nome;
    private Departamento departamento;
    private String descricao;


    public Equipamento(int IDEQUIP, String nome, Departamento departamento, String descricao, Date data) {
        this.IDEQUIP = IDEQUIP;
        this.nome = nome;
        this.departamento = departamento;
        this.descricao = descricao;
        this.data = data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public int getID() {
        return IDEQUIP;
    }

    public String getNome() {
        return nome;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public Date getData() {
        return data;
    }
    
}
