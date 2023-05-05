

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.EnumMap;

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
			ArrayList<Equipamento> auxEquip = d.getEquipamentos();
			for(Equipamento e : auxEquip) {
				System.out.println(e.toString());
			}
		}
	}

	public void printFuncionarios() {
		for(Departamento d : departamentos) {
			ArrayList<Funcionario> auxFunc = d.getFuncionarios();
			for(Funcionario f : auxFunc) {
				System.out.println(f.toString());
			}
		}
	}
	//Métodos de busca - retorna objeto
	public Funcionario procuraFuncionarioId(int id) {
		for(Departamento d : departamentos) {
			ArrayList<Funcionario> auxFunc = d.getFuncionarios();
			for(Funcionario f : auxFunc) {
				if(id == f.getID()) return f;
			}
		}
		return null;
	}

	public Equipamento procuraEquipamentoId(int id) {
		for(Departamento d : departamentos) {
			ArrayList<Equipamento> auxEquip = d.getEquipamentos();
			for(Equipamento e : auxEquip) {
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
			ArrayList<Funcionario> auxFunc = d.getFuncionarios();
			for(Funcionario f : auxFunc) {
				if(id == f.getID()) return true;
			}
		}
		return false;
	}

	public boolean equipamentoEstaNaEmpresa(int id) {
		for(Departamento d : departamentos) {
			ArrayList<Equipamento> auxEquip = d.getEquipamentos();
			for(Equipamento e : auxEquip) {
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
	public void printEquipSemSuporte(ArrayList<Chamado> chamados){
		Suporte auxSup = null;
		for(Departamento d : departamentos){
			if(d instanceof Suporte) auxSup =(Suporte) d;
		}
		if(auxSup==null){
			System.out.println("erro, nao ha equipe de suporte");
			return;
		}
		for(Departamento d : departamentos){
			ArrayList<Equipamento> equip = d.getEquipamentos();
			for(Equipamento e : equip){
				if(!auxSup.equipamentosTemSup(e)) System.out.println(e.toString());
			}
		}
	}
}