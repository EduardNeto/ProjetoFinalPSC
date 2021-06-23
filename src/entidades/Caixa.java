package entidades;

public class Caixa extends Funcionario {
    
    public Caixa (int matricula,String nome, double salario){
        this.matricula= matricula;
        this.nome= nome;
        this.salario= salario;
    }
     
     public double calcularSalario(double proventos, double descontos){
         return salario = salario + proventos - descontos;
     }     
     
     @Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
                sb.append("-----------------------");
                sb.append("\n    DADOS DO CAIXA     ");
                sb.append("\n-----------------------");
                sb.append("\nMatricula: "+ matricula);
                sb.append("\nNome: "+ nome);
		sb.append("\nSalário base: " + String.format("%.2f", salario));
		return sb.toString();
	}

     

     
}
