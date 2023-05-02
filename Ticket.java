
/* 7) O sistema deverá permitir localizar chamados por uma palavra-chave. 
A busca deverá ocorrer sobre os campos de nome do funcionário, descrição do equipamento, nome do setor, texto da solicitação, texto da resolução. */

public class Ticket {
    private String nomeFuncionario;
    private String descricaoEquipamento;
    private String nomeSetor;
    private String textoSolicitacao;
    private String textoResolucao;
    
    public Ticket(String nomeFuncionario, String descricaoEquipamento, String nomeSetor, String textoSolicitacao, String textoResolucao) {
        this.nomeFuncionario = nomeFuncionario;
        this.descricaoEquipamento = descricaoEquipamento;
        this.nomeSetor = nomeSetor;
        this.textoSolicitacao = textoSolicitacao;
        this.textoResolucao = textoResolucao;
    }
    
    public String getNomeFuncionario() {
        return nomeFuncionario;
    }
    
    public String getDescricaoEquipamento() {
        return descricaoEquipamento;
    }
    
    public String getNomeSetor() {
        return nomeSetor;
    }
    
    public String getTextoSolicitacao() {
        return textoSolicitacao;
    }
    
    public String getTextoResolucao() {
        return textoResolucao;
    }
}



