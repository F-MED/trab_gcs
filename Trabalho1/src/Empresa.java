import java.util.ArrayList;

public class Empresa {
	private ArrayList<Departamento> departamentos;
	private ArrayList<Funcionario> funcionarios; //ArrayList auxiliares
	private ArrayList<Equipamento> equipamentos;

	public Empresa() {
    	departamentos = new ArrayList<>();
  	}

  	public boolean adicionaDepartamento(Departamento d) {
    	return departamentos.add(d);
  	}

	public boolean removeDepartamento(Departamento d) {
		return departamentos.remove(d);
	}
	//Métodos de print
	public void printDepartamentos() {
		for(Departamento d : departamentos) {
			System.out.println(d.toString());
		}
	}

	public void printEquipamentos() {
		for(Departamento d : departamentos) {
			equipamentos = d.getEquipamentos();
			for(Equipamento e : equipamentos) {
				System.out.println(e.toString());
			}
		}
	}

	public void printFuncionarios() {
		for(Departamento d : departamentos) {
			funcionarios = d.getFuncionarios();
			for(Funcionario f : funcionarios) {
				System.out.println(f.toString());
			}
		}
	}
	//Métodos de busca - retorna objeto
	public Funcionario procuraFuncionarioId(int id) {
		for(Departamento d : departamentos) {
			funcionarios = d.getFuncionarios();
			for(Funcionario f : funcionarios) {
				if(id == f.getID()) return f;
			}
		}
		return null;
	}

	public Equipamento procuraEquipamentoId(int id) {
		for(Departamento d : departamentos) {
			equipamentos = d.getEquipamentos();
			for(Equipamento e : equipamentos) {
				if(id == e.getID()) return e;
			}
		}
		return null;
	}

	public Departamento procuraDepartamentoId(int id) {
		for(Departamento d : departamentos) {
			if(d.getID() == id) return d;
		}
		return null;
	}
	//Métodos de busca - retorna boolean
	public boolean funcionarioEstaNaEmpresa(int id) {
		for(Departamento d : departamentos) {
			funcionarios = d.getFuncionarios();
			for(Funcionario f : funcionarios) {
				if(id == f.getID()) return true;
			}
		}
		return false;
	}

	public boolean equipamentoEstaNaEmpresa(int id) {
		for(Departamento d : departamentos) {
			equipamentos = d.getEquipamentos();
			for(Equipamento e : equipamentos) {
				if(id == e.getID()) return true;
			}
		}
		return false;
	}
	//Método de busca equipamentos pela descrição
	public ArrayList<Equipamento> equipamentoDescricao(String auxDesc){
        ArrayList<Equipamento> auxArrayEquipamentos = new ArrayList<>();

        for(int i = 0; i < departamentos.size(); i++) {
            Departamento auxDepartamento = departamentos.get(i);
            ArrayList<Equipamento> auxArrayEquipamentosInterno = auxDepartamento.pesquisaEquipamento(auxDesc);
            for (int j = 0; j < auxArrayEquipamentosInterno.size(); i++) {
                auxArrayEquipamentos.add(auxArrayEquipamentosInterno.get(j));
            }
        }
        return auxArrayEquipamentos;
    }
	//Método de remoção do departamento de Suporte
	public boolean removerEquipeSuporte() {
		for(Departamento e : departamentos){
			if(e instanceof Suporte) {
				departamentos.remove(e);
				return true;
			}
		}
		return false;
	}
}