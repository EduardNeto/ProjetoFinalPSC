package entidades;

public class Gerente extends Funcionario{
    
    public Gerente(int matricula,String nome, double salario){
        this.matricula= matricula;
        this.nome= nome;
        this.salario= salario;
    }

     public double calcularSalario(double proventos, double comissao, double descontos){
         return salario = salario + proventos + comissao - descontos;
     }     
     
     @Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
                sb.append("----------------------");
                sb.append("\n   DADOS DO GERENTE   ");
                sb.append("\n----------------------");
                sb.append("\nMatricula: "+ matricula);
                sb.append("\nNome: "+ nome);
		sb.append("\nSalário base: " + String.format("%.2f",salario));
		return sb.toString();
	}
}
