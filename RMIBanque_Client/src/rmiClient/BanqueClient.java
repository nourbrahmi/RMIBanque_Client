package rmiClient;
import rmiService.IBanque;
import metier.Compte;

import java.rmi.Naming;
import java.util.Date;


public class BanqueClient {
    public static void main(String[] args) {
        try {
            // Se connecter au registre RMI pour obtenir l'objet distant
            IBanque banque = (IBanque) Naming.lookup("rmi://localhost:1090/BanqueService");

            // Utiliser les méthodes de l'objet distant
            // Exemple :
            Compte nouveauCompte = new Compte(123, 1000.0, new Date()); // Création d'un compte
            String resultat = banque.creerCompte(nouveauCompte); // Appel de la méthode distante
            System.out.println("message de creation de compte"+ resultat);
            
            int codecompte=11;
            String infocompte=banque.getInfoCompte(codecompte);
            System.out.println("info de compte"+ infocompte);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

