import br.com.dio.poo.dominio.Bootcamp;
import br.com.dio.poo.dominio.Curso;
import br.com.dio.poo.dominio.Dev;
import br.com.dio.poo.dominio.Mentoria;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso();
        curso1.setTitulo("Curso Java");
        curso1.setDescricao("Descricao: Curso em Java");
        curso1.setCargaHoraria(10);

        Curso curso2 = new Curso();
        curso2.setTitulo("Curso Js");
        curso2.setDescricao("Descricao: Curso Js");
        curso2.setCargaHoraria(8);

        Mentoria mentoria1 = new Mentoria();
        mentoria1.setTitulo("Mentoria de Java");
        mentoria1.setDescricao("Descricao: Mentoria de Java");
        mentoria1.setData(LocalDate.now());

        /*System.out.println(curso1);
        System.out.println(curso2);
        System.out.println(mentoria1);*/

        Bootcamp bootcamp1 = new Bootcamp();
        bootcamp1.setNome("Bootcamp Java");
        bootcamp1.setDescricao("Descricao: Bootcamp Java");
        bootcamp1.getConteudos().add(curso1);
        bootcamp1.getConteudos().add(curso2);
        bootcamp1.getConteudos().add(mentoria1);

        Dev devBergue = new Dev();
        devBergue.setNome("Lindembegue");
        devBergue.inscreverBootcamp(bootcamp1);
        System.out.println("Contéudos inscritos Bergue: " + devBergue.getConteudosInscritos());
        devBergue.prodredir();
        System.out.println("Contéudos concluidos Bergue: " + devBergue.getConteudosConcluidos());
        System.out.println("XP: " + devBergue.calcularTotalXp());

        System.out.println("-------");

        Dev devJose = new Dev();
        devJose.setNome("Josenildo");
        devJose.inscreverBootcamp(bootcamp1);
        System.out.println("Contéudos inscritos Jose: " + devJose.getConteudosInscritos());
        devJose.prodredir();
        System.out.println("Contéudos concluidos Jose: " + devJose.getConteudosInscritos());
        System.out.println("XP: " + devJose.calcularTotalXp());

    }
}