import static java.lang.System.exit;

import java.util.*;

public class App {
    private Scanner in;
    private Empresa empresa;
    private Funcionario login;
    private Suporte equipeDeSuporte;
    private int countIdFuncionario;
    private int countIdDepartamento;
    private int countIdEquipamento;

    public App() {
        in = new Scanner(System.in);
        empresa = new Empresa();
    }

    public void prenche() {
        empresa.adicionaDepartamento(new Departamento("departamento de financas", 1));
        empresa.adicionaDepartamento(new Suporte(2));
        empresa.adicionaDepartamento(new Departamento("departamento de ciencias", 3));
        Funcionario aux = new Funcionario(1, "fulano", empresa.procuraDepartamentoId(1));
        empresa.procuraDepartamentoId(1).addFuncionario(aux);
        aux = new Funcionario(2, "fulana", empresa.procuraDepartamentoId(1));
        empresa.procuraDepartamentoId(1).addFuncionario(aux);
        aux = new Funcionario(3, "ciclano", empresa.procuraDepartamentoId(1));
        empresa.procuraDepartamentoId(1).addFuncionario(aux);
        aux = new Funcionario(4, "ciclana", empresa.procuraDepartamentoId(1));
        empresa.procuraDepartamentoId(1).addFuncionario(aux);
        aux = new Funcionario(5, "antonio", empresa.procuraDepartamentoId(2)); 
        empresa.procuraDepartamentoId(2).addFuncionario(aux);
        aux = new Funcionario(6, "roberto", empresa.procuraDepartamentoId(2));
        empresa.procuraDepartamentoId(2).addFuncionario(aux);
        aux = new Funcionario(7, "alberto", empresa.procuraDepartamentoId(2));
        empresa.procuraDepartamentoId(2).addFuncionario(aux);
        aux = new Funcionario(8, "joserto", empresa.procuraDepartamentoId(2));
        empresa.procuraDepartamentoId(2).addFuncionario(aux);
        aux = new Funcionario(9, "beltrano", empresa.procuraDepartamentoId(2));
        empresa.procuraDepartamentoId(2).addFuncionario(aux);
        aux = new Funcionario(10, "newton", empresa.procuraDepartamentoId(3));
        empresa.procuraDepartamentoId(3).addFuncionario(aux);
        aux = new Funcionario(11, "einstein", empresa.procuraDepartamentoId(3));
        empresa.procuraDepartamentoId(3).addFuncionario(aux);
        aux = new Funcionario(12, "celcius", empresa.procuraDepartamentoId(3));
        empresa.procuraDepartamentoId(3).addFuncionario(aux);
        aux = new Funcionario(13, "fahrenheit", empresa.procuraDepartamentoId(3));
        empresa.procuraDepartamentoId(3).addFuncionario(aux);
        aux = new Funcionario(14, "volta", empresa.procuraDepartamentoId(3));
        empresa.procuraDepartamentoId(3).addFuncionario(aux);
        aux = new Funcionario(15, "lavoisier", empresa.procuraDepartamentoId(3));
        empresa.procuraDepartamentoId(3).addFuncionario(aux);
        aux = new Funcionario(16, "mendel", empresa.procuraDepartamentoId(3));
        empresa.procuraDepartamentoId(3).addFuncionario(aux);
        aux = new Funcionario(17, "darwin", empresa.procuraDepartamentoId(3));
        empresa.procuraDepartamentoId(3).addFuncionario(aux);
        equipeDeSuporte = (Suporte) empresa.procuraDepartamentoId(2);
        countIdFuncionario = 18;
        countIdDepartamento = 3;

        Equipamento auxEquipe = new Equipamento(1, "telefone", empresa.procuraDepartamentoId(1), "telefone do departamento",
            new GregorianCalendar(2023, Calendar.APRIL, 29));
        empresa.procuraDepartamentoId(1).addEquipamento(auxEquipe);
        auxEquipe = new Equipamento(2, "telefone", empresa.procuraDepartamentoId(1), "telefone do departamento",
            new GregorianCalendar(2023, Calendar.APRIL, 29));
        empresa.procuraDepartamentoId(2).addEquipamento(auxEquipe);
        auxEquipe = new Equipamento(3, "telefone", empresa.procuraDepartamentoId(1), "telefone do departamento",
            new GregorianCalendar(2023, Calendar.APRIL, 29));
        empresa.procuraDepartamentoId(3).addEquipamento(auxEquipe);
        auxEquipe = new Equipamento(4, "impressora", empresa.procuraDepartamentoId(1), "telefone do departamento",
            new GregorianCalendar(2023, Calendar.APRIL, 29));
        empresa.procuraDepartamentoId(1).addEquipamento(auxEquipe);
        auxEquipe = new Equipamento(5, "impressora", empresa.procuraDepartamentoId(1), "telefone do departamento",
                new GregorianCalendar(2023, Calendar.APRIL, 29));
        empresa.procuraDepartamentoId(2).addEquipamento(auxEquipe);
        auxEquipe = new Equipamento(6, "monitor", empresa.procuraDepartamentoId(1), "telefone do departamento",
                new GregorianCalendar(2023, Calendar.APRIL, 29));
        empresa.procuraDepartamentoId(1).addEquipamento(auxEquipe);
        auxEquipe = new Equipamento(7, "monitor", empresa.procuraDepartamentoId(1), "telefone do departamento",
            new GregorianCalendar(2023, Calendar.APRIL, 29));
        empresa.procuraDepartamentoId(2).addEquipamento(auxEquipe);
        countIdEquipamento = 8;
    }

    public void executa() {
        boolean auxBoolean;
        do {
            auxBoolean = loginFuncionario();
        } while (!auxBoolean);
        while (true) {
            menu(0);
            int menuOption = in.nextInt();
            switch (menuOption) {
                case 1:
                    do {
                        auxBoolean = loginFuncionario();
                    } while (!auxBoolean);
                    break;
                case 2:
                    if (equipeDeSuporte == null) {
                        System.out.println("ERRO: nao ha um departamento de suporte");
                        break;
                    }
                    do {
                        auxBoolean = abrirChamado();
                    } while (!auxBoolean);
                    System.out.println("chamado aberto");
                    break;
                case 3:
                    if (equipeDeSuporte == null) {
                        System.out.println("ERRO: nao ha um departamento de suporte");
                        break;
                    }
                    if (login.getDepartamento() instanceof Suporte) {
                        equipeDeSuporte.printChamados();
                        System.out.println("Informe o codigo do chamado");
                        int idChamado = in.nextInt();
                        equipeDeSuporte.statusChamado(idChamado);
                        Chamado c = equipeDeSuporte.procuraChamadoID(idChamado);
                        if(c.getStatus().equals("Concluido")){
                            System.out.println("informe o texto de resolucao");
                            Scanner auxScanner = new Scanner(System.in);
                            String auxString = in.nextLine();
                            c.setResolucao(auxString);
                        }
                        System.out.println(c.toString());
                    } else {
                        System.out.println("O usuario precisa fazer parte da equipe de suporte");
                    }
                    break;
                case 4:
                    if (equipeDeSuporte == null) {
                        System.out.println("ERRO: nao ha um departamento de suporte");
                        break;
                    }
                    if (login.getDepartamento() instanceof Suporte) {
                        empresa.printEquipamentos();
                        System.out.println("Informe o codigo do equipamento");
                        int auxCodigoEquipamento = in.nextInt();
                        Equipamento auxEquipe = empresa.procuraEquipamentoId(auxCodigoEquipamento);
                        System.out.println("Informe o codigo do departamento");
                        int auxCodigoDepartamento = in.nextInt();
                        Departamento auxDepartamento = empresa.procuraDepartamentoId(auxCodigoDepartamento);
                        auxBoolean = equipeDeSuporte.moverEquipamento(auxEquipe, auxDepartamento, login);
                        if (auxBoolean) {
                            System.out.println("Movido com sucesso");
                        } else {
                            System.out.println("Nao foi possivel mover");
                        }
                    } else {
                        System.out.println("O usuario precisa fazer parte da equipe de suporte");
                    }
                    break;
                case 5:
                    System.out.println("Informe a descriçao");
                    String auxDesc = in.nextLine();
                    in.next();
                    
                    if (!empresa.equipamentoDescricao(auxDesc).isEmpty()) {
                        for (Equipamento e : empresa.equipamentoDescricao(auxDesc)) {
                            System.out.println(e.toString());
                        }
                    }
                    break;
                case 6:
                    if (equipeDeSuporte == null) {
                        System.out.println("ERRO: nao ha um departamento de suporte");
                        break;
                    }
                    empresa.printEquipamentos();
                    System.out.println("Informe o codigo do equipamento: ");
                    int auxCodigoEquipamento = in.nextInt();
                    ArrayList<Chamado> auxChamados = equipeDeSuporte.listaChamadosPorEquipamentoId(auxCodigoEquipamento);
                    if(auxChamados.isEmpty()){
                        System.out.println("nao ha chamados desse equipamento");
                    }
                    else {
                        for (Chamado c : auxChamados) {
                            System.out.println(c.toString());
                        }
                    }
                    break;
                case 7:
                    System.out.println("Informe a palavra-chave");
                    String palavraChave = in.next();
                    auxChamados = equipeDeSuporte.listaChamado(palavraChave);
                    if(auxChamados.isEmpty()){
                        System.out.println("nao ha chamados com essa palavra chave");
                    }
                    else {
                        for (Chamado c : auxChamados) {
                            System.out.println(c.toString());
                        }
                    }
                    break;
                case 8:
                    if (equipeDeSuporte == null) {
                        System.out.println("ERRO: nao ha um departamento de suporte");
                        break;
                    }
                    printPainelDados();
                    break;
                case 9:
                    if (equipeDeSuporte == null) {
                        System.out.println("ERRO: nao ha um departamento de suporte");
                        break;
                    }
                    System.out.println("Informe o dia de hoje");
                    int dia = in.nextInt();
                    System.out.println("Informe o mês");
                    int mes = in.nextInt();
                    System.out.println("Informe o ano");
                    int ano = in.nextInt();
                    GregorianCalendar data = new GregorianCalendar(ano, mes, dia);
                    ArrayList<Chamado> chamados = equipeDeSuporte.getChamadosDate(data);
                    if(chamados.isEmpty()) System.out.println("nao ha chamados nesse dia");
                    for (Chamado c : chamados) {
                        System.out.println(c.toString());
                    }

                    break;

                case 10:
                    if (equipeDeSuporte == null) {
                        System.out.println("ERRO: nao ha um departamento de suporte");
                        break;
                    }
                    chamados = equipeDeSuporte.getChamados();
                    empresa.printEquipSemSuporte(chamados);
                    break;
                case 11:
                    if (equipeDeSuporte == null) {
                        System.out.println("ERRO: nao ha um departamento de suporte");
                        break;
                    }
                    ArrayList<Funcionario> funcionarios = equipeDeSuporte.funcionariosComChamados();
                    if(funcionarios.isEmpty()){
                        System.out.println("nao ha funcionarios com chamados");
                    }
                    else {
                        for (Funcionario f : funcionarios) {
                            System.out.println(f.toString());
                        }
                    }
                    break;
                case 12:
                    if (equipeDeSuporte == null) {
                        System.out.println("ERRO: nao ha um departamento de suporte");
                        break;
                    }
                    ArrayList<Funcionario> auxFuncionarios = equipeDeSuporte.maisChamados();
                    if(auxFuncionarios.isEmpty()) System.out.println("erro nao ha chamados");
                    else {
                        for(Funcionario f : auxFuncionarios){
                            System.out.println(f.toString());
                        }
                    }
                    break;
                case 13:
                    menu(1);
                    int menuOption2 = in.nextInt();
                    switch (menuOption2) {
                        case 1:
                            abrirChamado();
                            break;
                        case 2:
                            System.out.println("Informe o codigo do departamento");
                            int auxCodigoDepartamento = in.nextInt();
                            Departamento auxDepartamento = empresa.procuraDepartamentoId(auxCodigoDepartamento);
                            System.out.println("Informe o nome do funcionario");
                            String auxNome = in.nextLine();
                            in.next();
                            Funcionario aux = new Funcionario(countIdFuncionario, auxNome, auxDepartamento);
                            aux.getDepartamento().addFuncionario(aux);
                            countIdFuncionario++;
                            break;
                        case 3:
                            System.out.println("Informe o nome do departamento");
                            auxNome = in.nextLine();
                            auxDepartamento = new Departamento(auxNome, countIdDepartamento);
                            empresa.adicionaDepartamento(auxDepartamento);
                            countIdDepartamento++;
                            break;
                        case 4:
                            System.out.println("Informe o nome do equipamento");
                            String nomeEquipamento = in.nextLine();
                            in.next();
                            System.out.println("Informe o codigo do departamento");
                            auxCodigoDepartamento = in.nextInt();
                            auxDepartamento = empresa.procuraDepartamentoId(auxCodigoDepartamento);
                            System.out.println("Informe a descriçao do equipamento");
                            String auxDescricao = in.next();
                            in.next();
                            System.out.println("Informe o dia de hoje");
                            dia = in.nextInt();
                            System.out.println("Informe o mês");
                            mes = in.nextInt();
                            System.out.println("Informe o ano");
                            ano = in.nextInt();
                            data = new GregorianCalendar(ano, mes, dia);
                            Equipamento auxEquipe = new Equipamento(countIdEquipamento, nomeEquipamento,
                                    auxDepartamento, auxDescricao, data);
                            auxEquipe.getDepartamento().addEquipamento(auxEquipe);
                            break;
                        case 5:
                            if (equipeDeSuporte != null) {
                                System.out.println("Ja existe uma equipe de suporte registrada");
                                break;
                            }
                            Suporte sup = new Suporte(countIdDepartamento);
                            empresa.adicionaDepartamento(sup);
                            break;
                        case 6:
                            equipeDeSuporte.printChamados();
                            System.out.println("Informe o codigo do chamado");
                            int auxCodigoChamado = in.nextInt();
                            equipeDeSuporte.removeChamado(auxCodigoChamado);
                            break;
                        case 7:
                            empresa.printFuncionarios();
                            System.out.println("Informe o codigo do funcionario");
                            int auxCodigoFuncionario = in.nextInt();
                            Funcionario auxFuncionario = empresa.procuraFuncionarioId(auxCodigoFuncionario);
                            auxDepartamento = auxFuncionario.getDepartamento();
                            if (auxDepartamento.removeFuncionario(auxFuncionario)) {
                                System.out.println("funcionario removido");
                            } else {
                                System.out.println("Nao foi possivel remover o funcionario");
                            }
                            break;
                        case 8:
                            empresa.printDepartamentos();
                            System.out.println("Informe o codigo do departamento");
                            auxCodigoDepartamento = in.nextInt();
                            auxDepartamento = empresa.procuraDepartamentoId(auxCodigoDepartamento);
                            if(empresa.removeDepartamento(auxDepartamento)) {
                                System.out.println("Departamento removido com sucesso!");
                            }else{
                                System.out.println("ERRO: remoçao nao realizada");
                            }
                            break;
                        case 9:
                            empresa.printEquipamentos();
                            System.out.println("Informe o codigo do equipamento");
                            auxCodigoEquipamento = in.nextInt();
                            Equipamento auxEquipamento = empresa.procuraEquipamentoId(auxCodigoEquipamento);
                            auxDepartamento = auxEquipamento.getDepartamento();
                            if (auxDepartamento.removeEquipamento(auxEquipamento)) {
                                System.out.println("Equipamento removido com sucesso");
                            } else {
                                System.out.println("Nao foi possivel remover o equipamento");
                            }
                            break;
                        case 10:
                            if(empresa.removerEquipeSuporte()) {
                                equipeDeSuporte = null;
                                System.out.println("Equipe de suporte removida com sucesso!");
                            }else{
                                System.out.println("ERRO: remoçao nao realizada");
                            }
                            break;
                        default:
                            System.out.println("Opçao invalida");
                    }
                    break;
                case 14:
                    exit(0);
                default:
                    System.out.println("Opçao invalida");
            }
        }
    }

    public boolean abrirChamado() {
        if (equipeDeSuporte == null) return false;
        empresa.printEquipamentos();
        System.out.println("Informe o codido do equipamento");
        int aux = in.nextInt();
        Equipamento auxEquipe = empresa.procuraEquipamentoId(aux);
        if (auxEquipe == null) return false;
        System.out.println("Informe o dia de hoje");
        int dia = in.nextInt();
        System.out.println("Informe o mês");
        int mes = in.nextInt();
        System.out.println("Informe o ano");
        int ano = in.nextInt();
        GregorianCalendar data = new GregorianCalendar(ano, mes, dia);
        System.out.println("Informe a descriçao do chamado");
        Scanner auxScanner = new Scanner(System.in);
        String descricao = auxScanner.nextLine();
        Chamado novoChamado = new Chamado(equipeDeSuporte.numeroDeChamados() + 1, auxEquipe, login, descricao, data);
        return equipeDeSuporte.addChamado(novoChamado);
    }

    public boolean loginFuncionario() {
        empresa.printFuncionarios();
        System.out.println("informe o seu codigo de funcionario");
        int aux = in.nextInt();

        if (empresa.funcionarioEstaNaEmpresa(aux)) {
            login = empresa.procuraFuncionarioId(aux);
            System.out.println("Login feito com sucesso");
            return true;
        } else {
            System.out.println("Nao foi possivel fazer login");
            return false;
        }
    }

    public void printPainelDados() {
        double[] aux = dadosChamados();
        if (aux == null) return;
        System.out.println("Número total de chamados: " + (int) aux[0]);
        System.out.println("Número de chamados em aberto: " + (int) aux[1] + " | percentual: " + aux[2]);
        System.out.println("Número de chamados em andamento: " + (int) aux[3] + " | percentual: " + aux[4]);
        System.out.println("Número de chamados concluidos: " + (int) aux[5] + " | percentual: " + aux[6]);
    }

    public double[] dadosChamados(){
        if(equipeDeSuporte==null) return null;
        int nChamados = equipeDeSuporte.numeroDeChamados();
        int nChamadosAbertos = equipeDeSuporte.numeroDeChamadosAberto();
        int nChamadosAndamento = equipeDeSuporte.numeroDeChamadosAndamento();
        int nChamadosConcluidos = equipeDeSuporte.numeroDeChamadosConcluido();
        double nChamadosAbertosPercentual = 0;
        double nChamadosAndamentoPercentual = 0;
        double nChamadosConcluidosPercentual = 0;
        if(nChamadosAbertos>0){
            nChamadosAbertosPercentual = nChamadosAbertos/nChamados*100.0;
        }
        if(nChamadosAndamento>0){
            nChamadosAndamentoPercentual = nChamadosAndamento/nChamados*100.0;
        }
        if(nChamadosConcluidos>0){
            nChamadosConcluidosPercentual = nChamadosConcluidos/nChamados*100.0;
        }
        return new double[]{nChamados,nChamadosAbertos,nChamadosAbertosPercentual,nChamadosAndamento,nChamadosAndamentoPercentual,nChamadosConcluidos,nChamadosConcluidosPercentual};
    }

    public void menu(int codigo) {
        switch (codigo) {
            case 0:
                System.out.println("1. Funcionalidade 1: login");
                System.out.println("2. Funcionalidade 2: abrir chamado");
                System.out.println("3. Funcionalidade 3: equipe de suporte altera o status do chamado");
                System.out.println("4. Funcionalidade 4: equipe de suporte altera o departamento de um equipamento");
                System.out.println("5. Funcionalidade 5: pesquisar equipamento pela descriçao");
                System.out.println("6. Funcionalidade 6: listar todos os chamados de um equipamento");
                System.out.println("7. Funcionalidade 7: localizar chamados por palavra chave");
                System.out.println("8. Funcionalidade 8: dados dos chamados");
                System.out.println("9. Funcionalidade 9: chamados de um determinado dia");
                System.out.println("10. Funcionalidade 10: equipamentos sem chamados");
                System.out.println("11. Funcionalidade 11: funcionarios com chamados");
                System.out.println("12. Funcionalidade 12: funcionarios com mais chamados");
                System.out.println("13. Alteraçoes");
                System.out.println("14. Sair do programa");
                break;
            case 1:
                System.out.println("1. Adicionar chamado");
                System.out.println("2. Adicionar funcionario");
                System.out.println("3. Adicionar departamento");
                System.out.println("4. Adicionar equipamento");
                System.out.println("5. Adicionar equipe de suporte");
                System.out.println("6. Remover chamado");
                System.out.println("7. Remover funcionario");
                System.out.println("8. Remover departamento");
                System.out.println("9. Remover equipamento");
                System.out.println("10. Remover equipe de suporte");
                break;
            default:
                System.out.println("Digito invalido");
        }
    }

}
