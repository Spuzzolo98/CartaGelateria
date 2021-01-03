package cartagelateria;

import java.util.Scanner;
import ClassiVarie.Carta; //aggiungo la classe carta, che gestisce la tessera in sè per sè
import java.util.Random;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CartaGelateria {

    static Scanner kek = new Scanner(System.in);
    static Random pen = new Random();
    static ArrayList<Carta> InsiemeCarte = new ArrayList();

    static String menu() { //menu che rimanda allo switch nel main

        String scelta = "";
        System.out.println("Benvenuto a gelateria Falloni! Solo i Grandi Membri scelgono noi! Seleziona un'opzione: ");
        int check = 0;
        while (check == 0) {
            System.out.println("1)Creazione tessera \n2)Acquisto di un gelato \n3)Vedi saldo\n4)Annuario tessere\n5)Leaderboard \nu)Uscita");
            scelta = kek.nextLine();
            if (scelta != "") {
                check = 1;
            }
        }
        return scelta;
    }

    static Carta inserimento() {//inserimento tessera da zero
        System.out.println("Inserisci il tuo nome: ");
        Carta tessera = new Carta(kek.nextLine()); //dichiaro un oggetto di tipo Carta
        System.out.println("Ora il tuo cognome: ");
        tessera.setCognomeutente(kek.nextLine());
        try{
            while (tessera.getCodiceid() > 999999) {
                System.out.println("Inserisci codice carta (6 cifre)");
                tessera.setCodiceid(kek.nextInt());
                if(tessera.getCodiceid()>999999)
                    System.out.println("il codice dev'essere di sei cifre!");
            }
            System.out.println("Inserisci giorno creazione: ");
            tessera.setGiornor(kek.nextInt());
            System.out.println("Ora inserisci mese creazione: ");
            tessera.setMeser(kek.nextInt());
            System.out.println("E infine inserisci l'anno: ");
            tessera.setAnnor(kek.nextInt());
        }
        catch(Exception ex){
            System.out.println("Errore inserimento!");
            Carta errore = new Carta();
        }
        return tessera; //ritorno l'oggetto creato, in  modo tale da poterlo mettere in una arraylist
    }

    static void acquisto() {
        String quantitativo = "";
        System.out.println("inserisci codice carta");
        int codicetemp = kek.nextInt(), check = -1;
        for (int i = 0; i < InsiemeCarte.size(); i++) {
            if (codicetemp == InsiemeCarte.get(i).getCodiceid()) {
                check = i;
            }
        }
        boolean hovinto = false;
        if (check != -1) {
            System.out.println("Quanto Gelato vuoi acquistare? Abbiamo tre quantità: A)0,5kg\nB)0,75kg\nC)1kg");
            if (quantitativo.equalsIgnoreCase("a")) {
                hovinto = InsiemeCarte.get(check).elaboropunti(1);
            }
            if (quantitativo.equalsIgnoreCase("b")) {
                hovinto = InsiemeCarte.get(check).elaboropunti(2);
            }
            if (quantitativo.equalsIgnoreCase("c")) {
                hovinto = InsiemeCarte.get(check).elaboropunti(3);
            }
        } else {
            System.out.println("codice carta non trovato!");
        }
        if (hovinto = true) {
            System.out.println("Hai vinto mezzo chilo di gelato gratis! ora smettila di mangiarlo brutta palla di lardo.");
        }
    }
    
    static ArrayList elencoanno(int annorif){
        ArrayList<Integer> anni = new ArrayList();
        for(int i=0; i<InsiemeCarte.size();i++){
            if(InsiemeCarte.get(i).getAnnor()==annorif)
                anni.add(i);
        }
        return anni;
    }
    
    static String leaderboard(){
        String leader="";
        int ntemp = Integer.MIN_VALUE;
        for(int i=0; i<InsiemeCarte.size(); i++){
            if(InsiemeCarte.get(i).getNreset()>ntemp&&InsiemeCarte.get(i).getNreset()!=0){
                leader = InsiemeCarte.get(i).getNomeutente();
                ntemp = InsiemeCarte.get(i).getNreset();
            }
        }
        if(leader.equals("")){
            ntemp = Integer.MIN_VALUE;
            for(int i=0; i<InsiemeCarte.size(); i++){
                if(InsiemeCarte.get(i).getPuntitot()>ntemp){
                    leader = InsiemeCarte.get(i).getNomeutente();
                    ntemp = InsiemeCarte.get(i).getPuntitot();
                }
            }
        }
        return leader;
    }

    public static void main(String[] args) {
        String scelta = menu();

        switch (scelta) {
            case "1":
                InsiemeCarte.add(inserimento());
                kek.nextLine();
                break;
            case "2":
                acquisto();
                break;
            case "3":
                System.out.println("inserisci codice");
                int temp = kek.nextInt();
                for (int i = 0; i < InsiemeCarte.size(); i++) {
                    if (InsiemeCarte.get(i).getCodiceid() == temp) {
                        System.out.println("il tuo saldo punti è: " + InsiemeCarte.get(i).getCodiceid() + " punti");
                    } else {
                        System.out.println("codice non trovato!");
                    }
                }
                break;
            case "4":
                System.out.println("inserisci anno di rif");
                ArrayList<Integer> anni = elencoanno(kek.nextInt());
                System.out.println("le carte create nell'anno scelto hanno i codici: ");
                for(int i=0; i<anni.size();i++)
                    System.out.println(InsiemeCarte.get(anni.get(i)).getCodiceid());
                break;
            case "5":
                String topcliente = leaderboard();
                System.out.println("Il cliente che ha comprato più gelato è "+topcliente);             
        }
        if (scelta != "u") {
            menu();
        }
    }

}
