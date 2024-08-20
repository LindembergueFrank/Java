package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Neste caso eu poderia utiliazr outras implementações, até o HashMap seria mais conveniente
        Map<String, Integer> listUrna = new LinkedHashMap<>();

        System.out.println("Enter file full path: ");
        String path = sc.nextLine();

        try(BufferedReader br = new BufferedReader(new FileReader(path))){

            String line = br.readLine();
            while(line != null){

                String[] tokens = line.split(",");
                String name = tokens[0];
                int votos = Integer.parseInt(tokens[1]);

                if(listUrna.containsKey(name)){
                    int votes = listUrna.get(name);
                    listUrna.put(name, (votos + votes));
                }
                else {
                    listUrna.put(name, votos);
                }

                line = br.readLine();
            }
            System.out.println();
            System.out.println("RESULTADO DOS VOTOS:");
            for (String name : listUrna.keySet()){
                System.out.println(name + ": " + listUrna.get(name));
            }

        }
        catch (IOException e){
            System.out.println("Erro: " + e.getMessage());
        }

        sc.close();
    }
}