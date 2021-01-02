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
    
    static String menu(){ //menu che rimanda allo switch nel main
        
        String scelta=0;
        System.out.println("Benvenuto a gelateria Falloni! Solo i Grandi Membri scelgono noi! Seleziona un'opzione: ");
        int check=0;
        while(check!=1){
            System.out.println("1)Creazione tessera \n2)Acquisto di un gelato\n3)Vedi saldo\n 4)Annuario tessere\n 5)Leaderboard \nu)Uscita");
            if(scelta.equalsIgnoreCase("u"))
                check=1;
        }
        kek.nextLine();       
        return scelta;
    }
    
    static Carta inserimento(){//inserimento tessera da zero
        System.out.println("Inserisci il tuo nome: ");
        Carta tessera = new Carta(kek.nextLine()); //dichiaro un oggetto di tipo Carta
        System.out.println("Ora il tuo cognome: ");
        tessera.setCognomeutente(kek.nextLine());
        while(tessera.getCodiceid()>999999){
            System.out.println("Inserisci codice carta (6 cifre)");
            tessera.setCodiceid(kek.nextInt());
        }
        return tessera; //ritorno l'oggetto creato, in  modo tale da poterlo mettere in una arraylist
    }
    
    static void acquisto(){
        String quantitativo="";
        System.out.println("inserisci codice carta");
        int codicetemp = kek.nextInt(), check=-1;
        for(int i=0; i<InsiemeCarte.size(); i++){
            if(codicetemp == InsiemeCarte.get(i).getCodiceid())
                check = i;
        }
        boolean hovinto=false;
        if(check!=-1){
            System.out.println("Quanto Gelato vuoi acquistare? Abbiamo tre quantità: A)0,5kg\nB)0,75kg\nC)1kg");
            if(quantitativo.equalsIgnoreCase("a"))
                hovinto =InsiemeCarte.get(check).elaboropunti(1);
            if(quantitativo.equalsIgnoreCase("b"))
                hovinto = InsiemeCarte.get(check).elaboropunti(2);
            if(quantitativo.equalsIgnoreCase("c"))
                hovinto = InsiemeCarte.get(check).elaboropunti(3);
        }
        else
            System.out.println("codice carta non trovato!");
        if(hovinto = true)
            System.out.println("Hai vinto mezzo chilo di gelato gratis! ora smettila di mangiarlo brutta palla di lardo.");
    }
    
    
    public static void main(String[] args) {
        String scelta = menu();
        
        switch(scelta){
            case "1": InsiemeCarte.add(inserimento());
        break;
            case "2": acquisto();   
        break;
            case "3": System.out.println("inserisci codice");
                      int temp = kek.nextInt();
                      for(int i=0; i<InsiemeCarte.size();i++) 
                          if(InsiemeCarte.get(i).getCodiceid()==temp)System.out.println("il tuo saldo punti è: "+InsiemeCarte.get(i).getCodiceid()+" punti");
                          else System.out.println("codice non trovato!"); 
        break;
            case "4":
    }




    }
    
}
