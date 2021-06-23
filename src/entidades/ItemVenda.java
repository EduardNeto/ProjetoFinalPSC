package entidades;

public class ItemVenda {
    
    private int numero;
    private String nome;
    private int quantidade;
    private double precounitario;
    
     public ItemVenda() {
         
     }
    
    
     public ItemVenda (int numero, String nome, int quantidade, Double precoUnitario){
        this.numero= numero;
        this.nome= nome;
        this.quantidade = quantidade;
        this.precounitario = precoUnitario;
 
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecounitario() {
        return precounitario;
    }

    public void setPrecounitario(double precounitario) {
        this.precounitario = precounitario;
    }
    
    public double subTotal (){
        return (precounitario * quantidade);
    }
    
    @Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("|"+numero+" ");
                sb.append(nome+" ");
                sb.append(precounitario+" * ");
                sb.append(quantidade+" ");
                sb.append(String.format("= %.2f", subTotal()));                
	    return sb.toString();
	}

}


