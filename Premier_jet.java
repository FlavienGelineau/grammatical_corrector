//Fichier de base pour lire la bdd de mots en anglais, et la stocker dans un array

import java.util.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;

import java.io.IOException;

import java.util.LinkedList;

import java.util.List;

import java.util.ListIterator;

public class Premier_jet 
{
	public static void main(String[] args) throws IOException{
		  
		  File f = new File("/home/a/antoine/IN204/Projet/BDD_WORDS.txt");
		  
		  String path = "/home/a/antoine/IN204/Projet/BDD_WORDS";
		  InputStream flux = new FileInputStream(path); 
		  InputStreamReader lecture = new InputStreamReader(flux);
		  
		  BufferedReader buff=new BufferedReader(lecture);
		  String ligne;
		  ArrayList dicoMots = new ArrayList();
		  
		  
		  while ((ligne=buff.readLine())!=null){
		  	dicoMots.add(ligne);
		  }
		  buff.close(); 
		  
		  
		  System.out.println("Hello World !");
		  
		  Scanner sc = new Scanner(System.in);
		  
		  System.out.println("Veuillez saisir un MOT :");

		  String motEnter = sc.nextLine();
		   
		  System.out.println("Vous avez saisi le mot : " + motEnter);
		  
		  
		  
		  
		  System.out.println("Voici la correction : " + motEnter);
		}
}
