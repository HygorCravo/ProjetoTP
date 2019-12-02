package sistesmaescolar;

import java.util.ArrayList;
import java.util.Scanner;

public class SistesmaEscolar {

    static Scanner entrada = new Scanner(System.in);
    private static int contadorDisciplina;
    private static int contadorAluno;
    private static Disciplina disciplina = new Disciplina();;
    static int idAluno = 0;
    private static int codigoD;
	private static String nomeD;
	private static int cargaHoraria;
    static String opcao;
    static ArrayList<Disciplina> materias = new ArrayList<>();
    static ArrayList<Aluno> alunos = new ArrayList<>();
    static ArrayList<Matricula> matriculas = new ArrayList<>();
    
    public SistesmaEscolar() {
    	contadorAluno = 0;
    	contadorDisciplina = 0;
    }

    static void cadastrarDisciplina() {
    	
        do {

            System.out.println("Digite nome da disciplina");
            nomeD = entrada.next();

            System.out.println("Digite codigo da disciplina");
            codigoD = entrada.nextInt();
            
            System.out.println("Digite a carga horaria da disciplina");
            cargaHoraria = entrada.nextInt();

            materias.add(new Disciplina(codigoD,nomeD,cargaHoraria));

            System.out.println("Disciplina: " + nomeD + "cadastrada, ID " + codigoD + "\nQuantidade total de disciplinas cadastradas: " + materias.size());

            System.out.println("Cadastrar outra discinplina? (s/n)");
            opcao = entrada.next();

        } while (opcao.toLowerCase().equals("s"));
        menu();

    }

    static void cadastrarAluno() {
  

        do {
        	
        	Aluno aluno = new Aluno();

            System.out.println("Digite seu nome: ");
            String nome = entrada.next();
            aluno.setNome(nome);

            System.out.println("Digite seu sexo: ");
            char sexo = entrada.next().charAt(0);
            aluno.setSexo(sexo);

            System.out.println("Digite sua idade: ");
            int idade = entrada.nextInt();
            aluno.setIdade(idade);

            System.out.println("Digite o ID do aluno:");
            int idAluno = entrada.nextInt();
            aluno.setIdAluno(idAluno);

            alunos.add(aluno);

            System.out.println("Aluno " + aluno.getNome() + " cadastrado, ID: " + aluno.getIdAluno() + "\nQuantidade total de alunos cadastrados: " + contadorAluno);

            System.out.println("Cadastrar outro aluno? (s/n)");
            opcao = entrada.next();

        } while (opcao.toLowerCase().equals("s"));
        menu();

    } // CadastraAluno();

    static void matriculaAluno() {

        int idAluno = 0;
        int idDisciplina = 0;
        short anoLetivo;
        byte serie;
        Aluno aluno = new Aluno();
        Disciplina disciplina = new Disciplina();
        Matricula matricula;

        System.out.println("Digite o ano letivo");
        anoLetivo = entrada.nextShort();

        System.out.println("Digite a serie");
        serie = entrada.nextByte();

        System.out.println("Digite o identificador do aluno");
        idAluno = entrada.nextInt();

        System.out.println("Escolha a disciplina:\n");
        for(int i=0;i<materias.size();i++) {
            System.out.println(materias.get(i).getCodigoDisciplina()+" - "+materias.get(i).getNomeD());
        }
        System.out.println("Digite id da disciplina");
        idDisciplina = entrada.nextInt();

        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getIdAluno() == idAluno) {
                aluno = alunos.get(i);
            }
        }

        for(int i=0;i<materias.size();i++) {
        	if(materias.get(i).getCodigoDisciplina() == idDisciplina ) {
        		disciplina = materias.get(i);
        	}
        }

            matriculas.add(new Matricula(anoLetivo, serie, aluno, disciplina));
        
        menu();

    } // Fim do método matriculaAluno

    static void lancarNota() {

        int idAluno = 0;
        int idDisciplina = 0;
        int contador = 0;
        float media = 0.0f;
        
      //do{
        
        System.out.println("Digite o identificador do aluno");
        idAluno = entrada.nextInt();

        System.out.println("Escolha a disciplina:\n");
        for (int i = 0; i < materias.size(); i++) {
            System.out.println(materias.get(i).getCodigoDisciplina() + " - " + materias.get(i).getNomeD());
        }
        idDisciplina = entrada.nextInt();
        
        
        
            for (int i = 0; i < matriculas.size() ; i++) {
                if (matriculas.get(i).getDisciplina().getCodigoDisciplina() == idDisciplina) {
                    if (matriculas.get(i).getAluno().getIdAluno() == idAluno) {
                        
                    	Disciplina disciplina = new Disciplina();
                    	
                        System.out.println("Digite a nota do primeiro bimestre");
                        matriculas.get(i).setNotaPrimeiroBimestre(entrada.nextFloat());

                        System.out.println("Digite a nota do segundo bimestre");
                        matriculas.get(i).setNotaSegundoBimestre(entrada.nextFloat());

                        System.out.println("Digite a nota do terceiro bimestre");
                        matriculas.get(i).setNotaTerceiroBimestre(entrada.nextFloat());

                        System.out.println("Digite a nota do quarto bimestre");
                        matriculas.get(i).setNotaQuartoBimestre(entrada.nextFloat());
                        ++contador;
                        matriculas.get(i).media();
                        if(matriculas.get(i).isAprovado()) {
                        	System.out.println("Aprovado");
                        }else {
                        	System.out.println("Reprovado");
                        }
                        
                    }
                }
            }
            if(contador == 0) {
            	System.out.println("N�o foi encontrado esse aluno nessa disciplina!");
            }
            //System.out.println("Deseja inserir novas notas?(s/n)");
            //opcao=entrada.next();
        //}while(opcao.toLowerCase().equals("s"));
            menu();

    }
    public static void imprimirRegistros(){
        
        for(int i = 0; i<matriculas.size(); i++){
            matriculas.get(i).imprimeMatricula();
        }
        
    }
    public static void menu() {

        int opcao;

        System.out.println("Menu principal\n\nDigite\n1 - Para cadastrar Disciplina\n2 - Para cadastrar Aluno\n3 - Matricular aluno em uma disciplina\n4 - Lançar nota aluno\n5 - Imprimir registros\n6 - Sair do sistema");
        opcao = entrada.nextInt();

        switch (opcao) {

            case 1:
                cadastrarDisciplina();
                break;
            case 2:
                cadastrarAluno();
                break;
            case 3:
                matriculaAluno();
                break;
            case 4:
                lancarNota();
            case 5:
                imprimirRegistros();
            case 6:
                System.exit(0);
                break;
            default:
                menu();
                break;

        } // Fim do switch

    } // Fim do menu

    public static void main(String[] args) {

        menu();

    } // Fim do método main

} // Fim da classe main

