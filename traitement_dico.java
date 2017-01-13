//Package à importer afin d'utiliser l'objet File

import java.io.File;

public class traitement_dico {
  public static void main(String[] args) {
    //Création de l'objet File
    File f = new File("dic.txt");
    System.out.println("Chemin absolu du fichier : " + f.getAbsolutePath());
    System.out.println("Nom du fichier : " + f.getName());
    System.out.println("Est-ce qu'il existe ? " + f.exists());
    System.out.println("Est-ce un répertoire ? " + f.isDirectory());
    System.out.println("Est-ce un fichier ? " + f.isFile());

  }
}