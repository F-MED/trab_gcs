import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class App {
    private Scanner in;
    private ArrayList<Departamento> empresa;
    private Funcionario login;
    private Suporte equipeDeSuporte;

    private int countIdFuncionario;

    private int countIdDepartamento;

    private int countIdEquipamento;

    public App() {
        in = new Scanner(System.in);
        empresa = new ArrayList<>();
    }

    public void prenche() {
        empresa.add(new Departamento("departamento de financas", 1));
        empresa.add(new Suporte(2));
        empresa.add(new Departamento("departamento de ciencias", 3));
        Funcionario aux = new Funcionario(1, "fulano", empresa.get(1));
        empresa.get(1).addFuncionario(aux);
        aux = new Funcionario(2, "fulana", empresa.get(0));
        empresa.get(0).addFuncionario(aux);
        aux = new Funcionario(3, "ciclano", empresa.get(0));
        empresa.get(0).addFuncionario(aux);
        aux = new Funcionario(4, "ciclana", empresa.get(0));
        empresa.get(1).addFuncionario(aux);
        aux = new Funcionario(5, "antonio", empresa.get(1));
        empresa.get(1).addFuncionario(aux);
        aux = new Funcionario(6, "roberto", empresa.get(1));
        empresa.get(1).addFuncionario(aux);
        aux = new Funcionario(7, "alberto", empresa.get(1));
        empresa.get(1).addFuncionario(aux);
        aux = new Funcionario(8, "joserto", empresa.get(1));
        empresa.get(1).addFuncionario(aux);
        aux = new Funcionario(9, "beltrano", empresa.get(1));
        empresa.get(1).addFuncionario(aux);
        aux = new Funcionario(10, "newton", empresa.get(2));
        empresa.get(2).addFuncionario(aux);
        aux = new Funcionario(11, "einstein", empresa.get(2));
        empresa.get(2).addFuncionario(aux);
        aux = new Funcionario(12, "celcius", empresa.get(2));
        empresa.get(2).addFuncionario(aux);
        aux = new Funcionario(13, "fahrenheit", empresa.get(2));
        empresa.get(2).addFuncionario(aux);
        aux = new Funcionario(14, "volta", empresa.get(2));
        empresa.get(2).addFuncionario(aux);
        aux = new Funcionario(15, "lavoisier", empresa.get(2));
        empresa.get(2).addFuncionario(aux);
        aux = new Funcionario(16, "mendel", empresa.get(2));
        empresa.get(2).addFuncionario(aux);
        aux = new Funcionario(17, "darwin", empresa.get(2));
        empresa.get(2).addFuncionario(aux);
        equipeDeSuporte = (Suporte) empresa.get(1);
        countIdFuncionario = 18;
        countIdDepartamento = 3;
        Equipamento auxEquipe = new Equipamento(1, "telefone", empresa.get(0), "telefone do departamento",
                GregorianCalendar(2023, Calendar.APRIL, 29));
        empresa.get(0).addEquipamento(auxEquipe);
        auxEquipe = new Equipamento(2, "telefone", empresa.get(0), "telefone do departamento",
                GregorianCalendar(2023, Calendar.APRIL, 29));
        empresa.get(1).addEquipamento(auxEquipe);
        auxEquipe = new Equipamento(3, "telefone", empresa.get(0), "telefone do departamento",
                GregorianCalendar(2023, Calendar.APRIL, 29));
        empresa.get(2).addEquipamento(auxEquipe);
        auxEquipe = new Equipamento(4, "impressora", empresa.get(0), "telefone do departamento",
                GregorianCalendar(2023, Calendar.APRIL, 29));
        empresa.get(0).addEquipamento(auxEquipe);
        auxEquipe = new Equipamento(5, "impressora", empresa.get(0), "telefone do departamento",
                GregorianCalendar(2023, Calendar.APRIL, 29));
        empresa.get(1).addEquipamento(auxEquipe);
        auxEquipe = new Equipamento(6, "monitor", empresa.get(0), "telefone do departamento",
                GregorianCalendar(2023, Calendar.APRIL, 29));
        empresa.get(0).addEquipamento(auxEquipe);
        auxEquipe = new Equipamento(7, "monitor", empresa.get(0), "telefone do departamento",
                GregorianCalendar(2023, Calendar.APRIL, 29));
        empresa.get(1).addEquipamento(auxEquipe);
        countIdEquipamento = 8;

    }

    private Date GregorianCalendar(int i, int april, int j) {
        return null;
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
                        System.out.println("erro, não ha um departamento de suporte");
                        break;
                    }
                    do {
                        auxBoolean = abrirChamado();
                    } while (!auxBoolean);
                    break;
                case 3:
                    if (equipeDeSuporte == null) {
                        System.out.println("erro, não ha um departamento de suporte");
                        break;
                    }
                    if (login.getDepartamento() instanceof Suporte) {
                        printChamados();
                        System.out.println("informe o codigo do chamado");
                        int idChamado = in.nextInt();
                        equipeDeSuporte.statusChamado(login.getID(), idChamado);
                        Chamado c = equipeDeSuporte.procuraChamadoID(idChamado);
                        System.out.println(c.toString());
                    } else {
                        System.out.println("o usuario precisa fazer parte da equipe de suporte");
                    }
                    break;
                case 4:
                    if (equipeDeSuporte == null) {
                        System.out.println("erro, não ha um departamento de suporte");
                        break;
                    }
                    if (login.getDepartamento() instanceof Suporte) {
                        printEquipamentos();
                        System.out.println("informe o codigo do equipamento");
                        int auxCodigoEquipamento = in.nextInt();
                        Equipamento auxEquipe = procuraEquipamentoId(auxCodigoEquipamento);
                        System.out.println("informe o codigo do departamento");
                        int auxCodigoDepartamento = in.nextInt();
                        Departamento auxDepartamento = procuraDepartamentoId(auxCodigoDepartamento);
                        auxBoolean = equipeDeSuporte.moverEquipamento(auxEquipe, auxDepartamento, login);
                        if (auxBoolean) {
                            System.out.println("movido com sucesso");
                        } else {
                            System.out.println("nao foi possivel mover");
                        }
                    } else {
                        System.out.println("o usuario precisa fazer parte da equipe de suporte");
                    }
                    break;
                case 5:

                    System.out.println("informe a descricao");
                    String auxDesc = in.nextLine();
                    in.next();
                    ArrayList<Equipamento> auxArrayEquipamentos = new ArrayList<>();
                    for (int i = 0; i < empresa.size(); i++) {
                        Departamento auxDepartamento = empresa.get(i);
                        ArrayList<Equipamento> auxArrayEquipamentosInterno = auxDepartamento
                                .pesquisaEquipamento(auxDesc);
                        for (int j = 0; j < auxArrayEquipamentosInterno.size(); i++) {
                            auxArrayEquipamentos.add(auxArrayEquipamentosInterno.get(j));
                        }
                    }
                    if (!auxArrayEquipamentos.isEmpty()) {
                        for (Equipamento e : auxArrayEquipamentos) {
                            System.out.println(e.toString());
                        }
                    }
                    break;
                case 6:
                    if (equipeDeSuporte == null) {
                        System.out.println("erro, não ha um departamento de suporte");
                        break;
                    }
                    printEquipamentos();
                    System.out.println("informe o codigo do equipamento: ");
                    int auxCodigoEquipamento = in.nextInt();
                    ArrayList<Chamado> auxChamados = equipeDeSuporte.listaChamados(auxCodigoEquipamento);
                    for (Chamado c : auxChamados) {
                        System.out.println(c.toString());
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (equipeDeSuporte == null) {
                        System.out.println("erro, não ha um departamento de suporte");
                        break;
                    }
                    printPainelDados();
                    break;
                case 9:
                    if (equipeDeSuporte == null) {
                        System.out.println("erro, não ha um departamento de suporte");
                        break;
                    }
                    System.out.println("informe o dia de hoje");
                    int dia = in.nextInt();
                    System.out.println("informe o mes");
                    int mes = in.nextInt();
                    System.out.println("informe o ano");
                    int ano = in.nextInt();
                    Date data = GregorianCalendar(ano, mes, dia);
                    Chamado[] chamados = equipeDeSuporte.getChamadosDate(data);
                    for (Chamado c : chamados) {
                        System.out.println(c.toString());
                    }
                    break;

                case 10:
                    if (equipeDeSuporte == null) {
                        System.out.println("erro, não ha um departamento de suporte");
                        break;
                    }
                    ArrayList<Equipamento> equipamentos = equipeDeSuporte.equipamentosSemSup();
                    for (Equipamento e : equipamentos) {
                        System.out.println(e.toString());
                    }
                    break;
                case 11:
                    if (equipeDeSuporte == null) {
                        System.out.println("erro, não ha um departamento de suporte");
                        break;
                    }
                    ArrayList<Funcionario> funcionarios = equipeDeSuporte.funcionariosComChamados();
                    for (Funcionario f : funcionarios) {
                        System.out.println(f.toString());
                    }
                    break;
                case 12:
                    if (equipeDeSuporte == null) {
                        System.out.println("erro, não ha um departamento de suporte");
                        break;
                    }
                    Funcionario aux = equipeDeSuporte.maisChamados();
                    System.out.println(aux.toString());
                case 13:
                    menu(1);
                    int menuOption2 = in.nextInt();
                    switch (menuOption2) {
                        case 1:
                            abrirChamado();
                            break;
                        case 2:
                            System.out.println("informe o codigo do departamento");
                            int auxCodigoDepartamento = in.nextInt();
                            Departamento auxDepartamento = procuraDepartamentoId(auxCodigoDepartamento);
                            System.out.println("informe o nome do funcionario");
                            String auxNome = in.nextLine();
                            in.next();
                            aux = new Funcionario(countIdFuncionario, auxNome, auxDepartamento);
                            aux.getDepartamento().addFuncionario(aux);
                            countIdFuncionario++;
                            break;
                        case 3:
                            System.out.println("informe o nome do departamento");
                            auxNome = in.nextLine();
                            auxDepartamento = new Departamento(auxNome, countIdDepartamento);
                            empresa.add(auxDepartamento);
                            countIdDepartamento++;
                            break;
                        case 4:
                            System.out.println("informe o nome do equipamento");
                            String nomeEquipamento = in.nextLine();
                            in.next();
                            System.out.println("informe o codigo do departamento");
                            auxCodigoDepartamento = in.nextInt();
                            auxDepartamento = procuraDepartamentoId(auxCodigoDepartamento);
                            System.out.println("informe a descricao do equipamento");
                            String auxDescricao = in.next();
                            in.next();
                            System.out.println("informe o dia de hoje");
                            dia = in.nextInt();
                            System.out.println("informe o mes");
                            mes = in.nextInt();
                            System.out.println("informe o ano");
                            ano = in.nextInt();
                            data = GregorianCalendar(ano, mes, dia);
                            Equipamento auxEquipe = new Equipamento(countIdEquipamento, nomeEquipamento,
                                    auxDepartamento, auxDescricao, data);
                            auxEquipe.getDepartamento().addEquipamento(auxEquipe);
                            break;
                        case 5:
                            if (equipeDeSuporte != null) {
                                System.out.println("já existe uma equipe de suporte registrada");
                                break;
                            }
                            Suporte sup = new Suporte(countIdDepartamento);
                            empresa.add(sup);
                            break;
                        case 6:
                            printChamados();
                            System.out.println("informe o codigo do chamado");
                            int auxCodigoChamado = in.nextInt();
                            equipeDeSuporte.removeChamado(auxCodigoChamado);
                            break;
                        case 7:
                            printFuncionarios();
                            System.out.println("informe o codigo do funcionario");
                            int auxCodigoFuncionario = in.nextInt();
                            Funcionario auxFuncionario = procuraFuncionarioId(auxCodigoFuncionario);
                            auxDepartamento = auxFuncionario.getDepartamento();
                            if (auxDepartamento.removeFuncionario(auxFuncionario)) {
                                System.out.println("funcionario removido");
                            } else {
                                System.out.println("nao foi possivel remover o funcionario");
                            }
                            break;
                        case 8:
                            printDepartamentos();
                            System.out.println("informe o codigo do departamento");
                            auxCodigoDepartamento = in.nextInt();
                            auxDepartamento = procuraDepartamentoId(auxCodigoDepartamento);
                            empresa.remove(auxDepartamento);
                            break;
                        case 9:
                            printEquipamentos();
                            System.out.println("informe o codigo do equipamento");
                            auxCodigoEquipamento = in.nextInt();
                            Equipamento auxEquipamento = procuraEquipamentoId(auxCodigoEquipamento);
                            auxDepartamento = auxEquipamento.getDepartamento();
                            if (auxDepartamento.removeEquipamento(auxEquipamento)) {
                                System.out.println("equipamento removido com sucesso");
                            } else {
                                System.out.println("nao foi possivel remover o equipamento");
                            }
                            break;
                        case 10:
                            empresa.removeIf(d -> d instanceof Suporte);
                            equipeDeSuporte = null;
                            System.out.println("equipe de suporte excluida");
                            break;
                        default:
                            System.out.println("opcao invalida");
                    }
                    break;
                case 14:
                    exit(0);
                default:
                    System.out.println("opcao invalida");
            }
        }
    }

    public boolean abrirChamado() {
        if (equipeDeSuporte == null)
            return false;
        printEquipamentos();
        System.out.println("informe o codido do equipamento");
        int aux = in.nextInt();
        Equipamento auxEquipe = procuraEquipamentoId(aux);
        if (auxEquipe == null)
            return false;
        System.out.println("informe o dia de hoje");
        int dia = in.nextInt();
        System.out.println("informe o mes");
        int mes = in.nextInt();
        System.out.println("informe o ano");
        int ano = in.nextInt();
        Date data = GregorianCalendar(ano, mes, dia);
        System.out.println("informe a descricao do chamado");
        String descricao = in.nextLine();
        in.next();
        Chamado novoChamado = new Chamado(equipeDeSuporte.numeroDeChamados() + 1, auxEquipe, login, descricao, data);
        return equipeDeSuporte.addChamado(novoChamado);
    }

    public boolean loginFuncionario() {
        printFuncionarios();
        System.out.println("informe o seu codigo de funcionario");
        int aux = in.nextInt();
        if (funcionarioEstaNaEmpresa(aux)) {
            login = procuraFuncionarioId(aux);
            System.out.println("login feito com sucesso");
            return true;
        } else {
            System.out.println("não foi possivel fazer login");
            return false;
        }
    }

    public void printFuncionarios() {
        for (Departamento d : empresa) {
            ArrayList<Funcionario> aux = d.getFuncionarios();
            for (Funcionario f : aux) {
                System.out.println(f.toString());
            }
        }
    }

    public void printEquipamentos() {
        for (Departamento d : empresa) {
            ArrayList<Equipamento> aux = d.getEquipamentos();
            for (Equipamento e : aux) {
                System.out.println(e.toString());
            }
        }
    }

    public void printPainelDados() {
        double[] aux = dadosChamados();
        if (aux == null)
            return;
        System.out.println("numero total de chamados: " + (int) aux[0]);
        System.out.println("numero de chamados em aberto: " + (int) aux[1] + "percentual: " + aux[2]);
        System.out.println("numero de chamados em andamento: " + (int) aux[3] + "percentual: " + aux[4]);
        System.out.println("numero de chamados concluidos: " + (int) aux[4] + "percentual: " + aux[5]);

    }

    public void printChamados() {
        ArrayList<Chamado> aux = equipeDeSuporte.getChamados();
        for (Chamado c : aux) {
            System.out.println(c.toString());
        }
    }

    public void printDepartamentos() {
        for (Departamento d : empresa) {
            System.out.println(d.toString());
        }
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

    public Funcionario procuraFuncionarioId(int id) {
        for (Departamento d : empresa) {
            ArrayList<Funcionario> aux = d.getFuncionarios();
            for (Funcionario f : aux) {
                if (id == f.getID())
                    return f;
            }
        }
        return null;
    }

    public boolean funcionarioEstaNaEmpresa(int id) {
        for (Departamento d : empresa) {
            ArrayList<Funcionario> aux = d.getFuncionarios();
            for (Funcionario f : aux) {
                if (id == f.getID())
                    return true;
            }
        }
        return false;
    }

    public boolean equipamentoEstaNaEmpresa(int id) {
        for (Departamento d : empresa) {
            ArrayList<Equipamento> aux = d.getEquipamentos();
            for (Equipamento e : aux) {
                if (id == e.getID())
                    return true;
            }
        }
        return false;
    }

    public Equipamento procuraEquipamentoId(int id) {
        for (Departamento d : empresa) {
            ArrayList<Equipamento> aux = d.getEquipamentos();
            for (Equipamento e : aux) {
                if (id == e.getID())
                    return e;
            }
        }
        return null;
    }

    public Departamento procuraDepartamentoId(int id) {
        for (Departamento d : empresa) {
            if (d.getID() == id) {
                return d;
            }
        }
        return null;
    }

    public void menu(int codigo) {
        switch (codigo) {
            case 0:
                System.out.println("1------funcionalidade 1: login");
                System.out.println("2------funcionalidade 2: abrir chamado");
                System.out.println(
                        "3------funcionalidade 3: funcionario da equipe de suporte alterar o status do chamado");
                System.out.println(
                        "4------funcionalidade 4: funcionario da equipe de suporte alterar o departamento de um equipamento");
                System.out.println("5------funcionalidade 5: pesquisar equipamento pela descrição");
                System.out.println("6------funcionalidade 6: listar todos os chamados de um equipamento");
                System.out.println("7------funcionalidade 7: localizar chamados por palavra chave");
                System.out.println("8------funcionalidade 8: dados dos chamados");
                System.out.println("9------funcionalidade 9: chamados de um determinado dia");
                System.out.println("10-----funcionalidade 10: equipamentos sem chamados");
                System.out.println("11-----funcionalidade 11: funcionarios com chamados");
                System.out.println("12-----funcionalidade 12: funcionarios com mais chamados");
                System.out.println("13-----alteracoes");
                System.out.println("14-----sair do programa");
                break;
            case 1:
                System.out.println("1------adicionar chamado");
                System.out.println("2------adicionar funcionario");
                System.out.println("3------adicionar departamento");
                System.out.println("4------adicionar equipamento");
                System.out.println("5------adicionar equipe de suporte");
                System.out.println("6------remover chamado");
                System.out.println("7------remover funcionario");
                System.out.println("8------remover departamento");
                System.out.println("9------remover equipamento");
                System.out.println("10-----remover equipe de suporte");
        }
    }

}
