
public class dictionnary {
	String[] Dico;//dictionnaire de mots
	String[] Pres;//dictionnaire de pr�sences
	String[] PresComplexe;//dictionnaire de pr�sence gauche et droite de mots ([[],[]]), limit� aux 50 plus probables ?
	String[] ImpossibleInCombinaisons;//dictionnaire de combi de caract�res impossible dans un mot
	String[] ImpossibleStartCombinaisons;//dico de combi de carac impossible au d�but d'un mot
	String[] ImpossibleEndCombinaisons;//dico de combi de carac impossible en fin de mot
	String langue;//langue du dico
	String alphabet;//alphabet de la langue langue
	int taille;//taille des dico de mots et de pr�sence
}
