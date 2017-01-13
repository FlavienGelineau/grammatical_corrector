//Packages à importer afin d'utiliser les objets

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Stocker_dict_dans_tableau {
   private static List tableau_dico = new LinkedList();
   
   public static void readFromFileAndStockToList(String file){
	      Stocker_dict_dans_tableau s = new Stocker_dict_dans_tableau();
	      FileInputStream fis = null;
	      try {
	         // On instancie nos objets : fis va lire le fichier
	         fis = new FileInputStream(new File(file));
	         // On crée un tableau de byte pour indiquer le nombre de bytes lus à chaque tour de boucle
	         byte[] buf = new byte[8];
	         // On crée une variable de type int pour y affecter le résultat de la lecture vaut -1 quand c'est fini
	         int n = 0;
	         // Tant que l'affectation dans la variable est possible, on boucle lorsque la lecture du fichier est terminée l'affectation n'est
	         // plus possible ! On sort donc de la boucle
	         while ((n = fis.read(buf)) >= 0) {
	            // On écrit dans notre deuxième fichier avec l'objet adéquat
	        	 s.tableau_dico.add(buf);
	            //Nous réinitialisons le buffer à vide au cas où les derniers byte lus ne soient pas un multiple de 8
	            //Ceci permet d'avoir un buffer vierge à chaque lecture et ne pas avoir de doublon en fin de fichier
	            buf = new byte[8];
	         }
	         System.out.println("Stockage terminé !");
	      } 
	      catch (FileNotFoundException e) {
	         // Cette exception est levée si l'objet FileInputStream ne trouve
	         // aucun fichier
	         e.printStackTrace();
	      } catch (IOException e) {
	         // Celle-ci se produit lors d'une erreur d'écriture ou de lecture
	         e.printStackTrace();
	      } finally {
	         // On ferme nos flux de données dans un bloc finally pour s'assurer
	         // que ces instructions seront exécutées dans tous les cas même si
	         // une exception est levée !
	         try {
	            if (fis != null)
	               fis.close();
	         } catch (IOException e) {
	            e.printStackTrace();
	         }
	      }
	   
   }
   
   public static void main(String[] args) {
      // Nous déclarons nos objets en dehors du bloc try/catch
	   readFromFileAndStockToList("dic.txt");
	   for(int i = 0; i <= 1; i++)
		   System.out.println(String.valueOf(tableau_dico.get(i)));	   
   }	 
}