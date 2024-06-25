package tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*Escreva um programa em Java que solicite ao usuário a quantidade de alunos em uma
        turma e, em seguida, peça ao usuário para inserir o nome e as notas de três provas para
cada aluno. O programa deve calcular a média das três notas de cada aluno e exibir o
nome do aluno juntamente com sua média. Utilize a classe Scanner para ler os dados de
entrada do usuário.
        a. Requisitos:
i. O programa deve pedir ao usuário a quantidade de alunos na turma.
ii. Para cada aluno, o programa deve solicitar:
iii. Nome do aluno.
iv. Nota da primeira prova.
v. Nota da segunda prova.
vi. Nota da terceira prova.

vii. O programa deve calcular a média das três notas para cada aluno.
viii. Após calcular a média, o programa deve exibir o nome do aluno e sua
média.*/


public class TaskSete {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int quantidadeDeAlunos = Integer.parseInt(sc.nextLine());

        List<Aluno> alunos = new ArrayList<>();
        for (int i = 0; i < quantidadeDeAlunos; i++) {
            String nome = sc.nextLine();
            double nota1 = Double.parseDouble(sc.nextLine());
            double nota2 = Double.parseDouble(sc.nextLine());
            double nota3 = Double.parseDouble(sc.nextLine());

            Aluno aluno = new Aluno(nome, nota1, nota2, nota3);
            alunos.add(aluno);
        }

        for(Aluno aluno : alunos){
            System.out.println(aluno);
        }
    }
}
