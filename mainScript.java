//import WordCorrection.enterWord;
import java.io.IOException;
import java.util.LinkedList;
//import WordCorrection.PossibleRealWords;
//import TakeDico.takeDico;


public class mainScript {
	public static void main(String[] args) throws IOException {
	String pathDico = "C:/Documents and Settings/Paul/workspace/BDD_WORDS.txt";
	String alphabet = "abcdefghijklmnopqrstuvwxyz";
	//LinkedList<String> Dico = TakeDico.takeDico(pathDico);
	String[] Dico = TakeDico.takeDico(pathDico);
	//System.out.println(Dico);
	//LinkedList<String> ImpossibleFirstLetters = ImpossibleWords.impossibleFirstLetters(Dico,alphabet);
	//System.out.println(ImpossibleFirstLetters);
	//LinkedList<String> ImpossibleInLetters = ImpossibleWords.impossibleInLetters(Dico,alphabet);
	//LinkedList<String> ImpossibleEndLetters = ImpossibleWords.impossibleEndLetters(Dico,alphabet);
	
	
	
	LinkedList<String> realWords = new LinkedList<String>();
	String word;
	String correctedWord;
	while(true) {
		word = enterWord.getWord();
		if ((CheckWord.checkWord(word,Dico))==true)
			{
			System.out.println("Le mot corrigé est : ");
			System.out.println(word);
			}
		else
			{
			String[] Words = PossibleRealWords.possibleRealWords(word,1,alphabet);
			System.out.println(Words);
			
			realWords = SearchingWords.searchingWords(Dico,Words);
			System.out.println(realWords);
			int[] Cost = new int[realWords.size()];
			Cost = GetCost.getCost(realWords,word);
			correctedWord = Decision.decision(realWords,Cost);
			System.out.println("Le mot corrigé est : ");
			System.out.println(correctedWord);
			}
		}
	}
}
