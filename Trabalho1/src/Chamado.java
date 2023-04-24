import java.util.Date;

public class Chamado {
    private final int IDCHAMADO; // atributo final por ser o atributo identificador e nao devera ser mudado
    private Equipamento equipamentoSuporte; // o Equipamento(objeto) que precisa de suporte
    private Funcionario funcionarioQueAbriu; // o Funcionario(objeto) que pediu o de suporte
    private String desc; // a descricao do problema do equipamento
    private Date dataAberto; // a data que o suporte foi aberta
    private String status; // o status do suporte do equipamento(aberto -> em andamento ->concluído)


    // metodo construtor
    public Chamado(int IDCHAMADO, Equipamento equipamentoSuporte, Funcionario funcionarioQueAbriu, String desc, Date dataAberto, String status) {
        this.IDCHAMADO = IDCHAMADO;
        this.equipamentoSuporte = equipamentoSuporte;
        this.funcionarioQueAbriu = funcionarioQueAbriu;
        this.desc = desc;
        this.dataAberto = dataAberto;
        this.status = status;
    }

    // gettes-------v
    public int getIDCHAMADO() {
        return IDCHAMADO;
    }

    public Equipamento getEquipamentoSuporte() {
        return equipamentoSuporte;
    }

    public Funcionario getFuncionarioQueAbriu() {
        return funcionarioQueAbriu;
    }

    public String getDesc() {
        return desc;
    }

    public Date getDataAberto() {
        return dataAberto;
    }

    public String getStatus() {
        return status;
    }

    // setters-----
    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
