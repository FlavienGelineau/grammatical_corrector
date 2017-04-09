import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class initialisation {
	public static encyclopedia init(String [] Langues, String pathDirectory) throws IOException 
	{
		encyclopedia Encyclo = new encyclopedia();
		Encyclo.tailleEncy = Langues.length;
		Encyclo.Ency = new dictionnary[Encyclo.tailleEncy];
		String pathDico = ""; 
		String pathPres = "";
		String pathIn = "";
		String pathStart = "";
		String pathEnd = "";
		String pathAlphabet = "";
		String[] Alphabet;
		for (int j=0;j<Encyclo.tailleEncy;j+=1)
		{
			Encyclo.Ency[j] = new dictionnary();
			pathDico = pathDirectory + "\\" + Langues[j] + "Dico.txt";
			pathPres = pathDirectory + "\\" + Langues[j] + "Pres.txt";
			pathIn = pathDirectory + "\\" + Langues[j] + "In.txt";
			pathStart = pathDirectory + "\\" + Langues[j] + "Start.txt";
			pathEnd = pathDirectory + "\\" + Langues[j] + "End.txt";
			pathAlphabet = pathDirectory + "\\" + Langues[j] + "Alphabet.txt";
			
			//Construction de l'objet (un constructeur est superflus dans notre cas) :
			
			// Prise du dictionnaire (Dico) : 
			Encyclo.Ency[j].Dico = takeTxtFile(pathDico);
			//Prise de la présence (Pres) :
			Encyclo.Ency[j].Pres = takeTxtFile(pathPres);
			// Prise du dictionnaire (inCombinaisons) : 
			//Encyclo.Ency[j].ImpossibleInCombinaisons = takeTxtFile(pathIn);
			// Prise de la présence (startCombinaisons) :
			//Encyclo.Ency[j].ImpossibleStartCombinaisons = takeTxtFile(pathStart);
			// Prise de la présence (endCombinaisons) :
			//Encyclo.Ency[j].ImpossibleEndCombinaisons = takeTxtFile(pathEnd);
			// Langue :
			Encyclo.Ency[j].langue = Langues[j]; 
			// Alphabet : 
			//Alphabet = takeTxtFile(pathAlphabet);
			//Encyclo.Ency[j].alphabet = Alphabet[0];
			// Taille des dicos
			Encyclo.Ency[j].taille = Encyclo.Ency[j].Dico.length;
		}
		
		return Encyclo;
		
	}
	public static String[] takeTxtFile(String pathDico) throws IOException
	{
		InputStream flux = new FileInputStream(pathDico); 
		InputStreamReader lecture = new InputStreamReader(flux);
		  
		BufferedReader buff=new BufferedReader(lecture);
		String ligne;
		int nbLignes =0;
        while((ligne=buff.readLine()) != null)
         
        {
        		nbLignes+=1;
           	}
        buff.close();
        String[] Dico = new String[nbLignes];
        
        InputStream Flux = new FileInputStream(pathDico); 
		InputStreamReader Lecture = new InputStreamReader(Flux);
		  
		BufferedReader Buff=new BufferedReader(Lecture);
		nbLignes=0;
        while((ligne=Buff.readLine()) != null)
         
        {
        		Dico[nbLignes] = ligne;	
        		nbLignes+=1;
           	}
        Buff.close();
        return Dico;
	}
}

