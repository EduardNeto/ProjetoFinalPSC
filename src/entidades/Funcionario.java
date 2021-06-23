package entidades;

public abstract class Funcionario {
    
    protected int matricula;
    protected String nome;
    protected double salario;
    
    public int getmatricula(){
        return matricula;
    }
    
    public void setmatricula(int matricula){
        this.matricula = matricula;
    }
    
    public String getnome() {
        return nome;
    }
    
    public void setnome(String nome){
        this.nome = nome;
    }
    
    public double getsalario(){
        return salario;
    }
    
    public void setsalario(double salario){
        this.salario = salario;
    }

    
}
