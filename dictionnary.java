
public class dictionnary {
	String[] Dico;//dictionnaire de mots
	String[] Pres;//dictionnaire de présences
	String[] PresComplexe;//dictionnaire de présence gauche et droite de mots ([[],[]]), limité aux 50 plus probables ?
	String[] ImpossibleInCombinaisons;//dictionnaire de combi de caractères impossible dans un mot
	String[] ImpossibleStartCombinaisons;//dico de combi de carac impossible au début d'un mot
	String[] ImpossibleEndCombinaisons;//dico de combi de carac impossible en fin de mot
	String langue;//langue du dico
	String alphabet;//alphabet de la langue langue
	int taille;//taille des dico de mots et de présence
}
