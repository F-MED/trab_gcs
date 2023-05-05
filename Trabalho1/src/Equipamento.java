import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
//api do Date: https://docs.oracle.com/javase/8/docs/api/java/util/Date.html

public class Equipamento {
    private final int IDEQUIP;
    private GregorianCalendar data; // pensei em usar final, mas deixei sem por que imaginei que a data seria
                       // informada pelo usuario
    private String nome;
    private Departamento departamento;
    private String descricao;

    public Equipamento(int IDEQUIP, String nome, Departamento departamento, String descricao, GregorianCalendar data) {
        this.IDEQUIP = IDEQUIP;
        this.nome = nome;
        this.departamento = departamento;
        this.descricao = descricao;
        this.data = data;
    }

    public void setData(GregorianCalendar data) {
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

    public GregorianCalendar getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Equipamento{" +
                "IDEQUIP=" + IDEQUIP +
                ", data=" + data .get(Calendar.DAY_OF_MONTH)+ "/" + ((int) data.get(Calendar.MONTH)+1) + "/" + data.get(Calendar.YEAR) +
                ", nome=" + nome + '\'' +
                ", departamento=" + departamento.getNome() +
                ", descricao=" + descricao + '\'' +
                '}';
    }
}
