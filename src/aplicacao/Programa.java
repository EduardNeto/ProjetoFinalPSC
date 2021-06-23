package aplicacao;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;


import entidades.Caixa;
import entidades.Gerente;
import entidades.ItemVenda;
import entidades.Venda;
import enumerados.StatusVenda;
import enumerados.TipoPagamento;
import interfaces.Visa;
import interfaces.MasterCard;


public class Programa {
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    static Scanner sc;
    static int matricula = 1;
    static String nome= "";
    static double salario = 0.0;
    static double proventos = 0.0;
    static double descontos = 0.0;
    static double comissao = 0.0;
    
    
    public static void main(String[] args) throws ParseException {
        sc = new Scanner(System.in);
        int op = 0;
        do{
            menu();
            System.out.println("Informe a opção: ");
            op = sc.nextInt();
            
            if(op < 1 || op > 6) {
                System.out.println("Opção Inválida!");
            }
            
            if(op == 1) {
                StatusVenda statusVenda = StatusVenda.valueOf("INICIANDO");
                int numeroVenda = 0;
                System.out.println("Numero da venda...: ");
                numeroVenda = sc.nextInt();
                System.out.println("Data da venda...: ");
                Date data = sdf.parse(sc.next());
                
                TipoPagamento tipoPagamento;
                System.out.println("Tipo Pgamento (1) DINHEIRO, (2) VISTA, (3) CREDITO, (4) DEBITO, (5) CHEQUE: ");
                int tipo = sc.nextInt();
                while (true) {
                    if(tipo == 1) {
                        tipoPagamento = TipoPagamento.DINHEIRO;
                        break;
                    } else if(tipo == 2) {
                        tipoPagamento = TipoPagamento.VISTA;
                        break;
                    } else if(tipo == 3) {
                        tipoPagamento = TipoPagamento.CREDITO;
                        break;
                    } else if(tipo == 4) {
                        tipoPagamento = TipoPagamento.DEBITO;
                        break;  
                    }  else if(tipo == 5) {
                        tipoPagamento = TipoPagamento.DEBITO;
                        break;    
                    } else {
                        System.out.println("Tipo inválido!");
                        continue;
                    }
                }

                Venda venda = new Venda(numeroVenda, data, statusVenda, tipoPagamento);
                
                System.out.println("Informe os itens (-1 para finalizar)");
                int numeroItem = 1;
                while (true){
                    System.out.println("Produto número: "+ numeroItem);
                    
                    System.out.println("Quantidade ");
                    int quantidade = sc.nextInt();
                    if (quantidade == -1){
                        break;
                    }
                    
                    System.out.println("Preço unitário: ");
                    double precoUnitario = sc.nextDouble();
                    
                    System.out.println("Nome do produto: ");
                    String nome = sc.next();
                    
                    ItemVenda itemVenda = new ItemVenda(numeroItem, nome, quantidade, precoUnitario);
                    venda.adicionarItem(itemVenda);
                    
                    statusVenda = StatusVenda.PROCESSANDO;
                    venda.setStatusVenda(statusVenda);

                    numeroItem++;
                    
                }
                System.out.println("-------------------");
                System.out.println(" DADOS DA VENDA:");
                System.out.println("-------------------");
                statusVenda = StatusVenda.IMPRIMINDO;
                System.out.println(venda.toString());
                statusVenda = StatusVenda.FINALIZADO;
            }
            if (op == 2){
                System.out.println("Informe a matricula do Caixa...:");
                matricula = sc.nextInt();
                System.out.println("Informe o nome do Caixa...:");
                nome = sc.next();
                System.out.println("Infome o salário base do Caixa: ");
                salario = sc.nextDouble();
                
                Caixa cx = new Caixa(matricula, nome, salario);
                System.out.println("Informe o valor dos proventos para o Caixa: ");
                proventos = sc.nextDouble();
                System.out.println("Informe o valor dos Descontos para o Caixa: ");
                descontos = sc.nextDouble();
                System.out.println(cx);
                System.out.println(String.format("Salário final: %.2f",cx.calcularSalario(proventos,descontos)));
                System.out.println("--------------------------------");;
                
                //Gerente
                System.out.println("Informe a matricula do Gerente...:");
                matricula = sc.nextInt();
                System.out.println("Informe o nome do Gerente...:");
                nome = sc.next();
                System.out.println("Informe o salário base do Gerente: ");
                salario = sc.nextDouble();
                
                Gerente ge = new Gerente(matricula, nome, salario);
                
                System.out.println("Informe o valor dos proventos para o Gerente: ");
                proventos = sc.nextDouble();
                System.out.println("Informe o valor dos descontos para o Gerente: ");
                descontos = sc.nextDouble();
                System.out.println("informe o valor da Comissão para o Gerente: ");
                comissao = sc.nextDouble();
                System.out.println(ge);
                System.out.println(String.format("Salário final: %.2f",ge.calcularSalario(proventos, comissao, descontos)));
                System.out.println("--------------------------------");;
                
            }   
            
            if(op ==3){                
                while(true) {
                    char opcao;
                    System.out.println("Informe o tipo de cartão: (v)Visa,(m)Mastercard,(f)Finalizar: ");
                    opcao = sc.next().toLowerCase().charAt(0);
                    if(opcao == 'v') {
                        Visa vi = new Visa();
                        System.out.println("Informe o setor para o cartão VISA: ");
                        vi.setSetor(sc.nextInt());
                        System.out.println(vi.verificarBandeira(vi.getSetor()));
                        
                    } else if(opcao == 'm') {
                        MasterCard ma = new MasterCard();
                        System.out.println("Informe o setor para o cartão MASTERCARD:");
                        ma.setSetor(sc.nextInt());
                        System.out.println(ma.verificarBandeira(ma.getSetor()));
                    } else
                        break;
                    }
                }
            if (op == 4){
                
                sobre();
            }
        } while (op != 5);
        System.out.println("* * * PROGRAMA FINALIZADO * * *");
        
        sc.close();
    } 
    public static void sobre() {
        System.out.println("------------------------------------");
        System.out.println("|          SOBRE O PROGRAMA         |");
        System.out.println("------------------------------------");
        System.out.println("BYTA BUG LTDA");
        System.out.println("CLIENTE: SUPERMECADOS BIG");
        System.out.println("VERSÃO 1.0");
        System.out.println("EDUARDO GOMES BRAGA NETO");
        System.out.println("ESHTER GONSAÇALVES DE PAULA");
        System.out.println("JOÃO LUCAS DE MIRANDA BRUM");
        System.out.println("VITOR OZANAN DÓRIA");
        System.out.println("------------------------------------");
        System.out.println("Contatos:(31)99567-9944");
        System.out.println("          www.bytabugltda.com.br");
        System.out.println("------------------------------------");
    }
    
    public static void menu(){
            System.out.println("MENU DE OPÇÕES:");
            System.out.println("");
            System.out.println("1- REALIZAR VENDA");
            System.out.println("2- MOSTRAR SALÁRIOS DOS FUNCIONÁRIOS");
            System.out.println("3- VERIFICAR BANDEIRA DO CARTÃO");
            System.out.println("4- SOBRE O PROGRAMA");
            System.out.println("5- FINALIZAR PROGRAMA");
    }
}
