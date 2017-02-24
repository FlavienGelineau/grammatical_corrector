# grammatical_corrector
A grammatical correcteur in Java

    GENERAL STUFF TO DO :
     - adaptate the different functions to be able to process several languages, by going on object oriented programming
     - auto-detecte the language of the written word, to process it with the right methods and dictionnary
     - create a user-friendly graphic interface
     - implemente a neurone network to measure the cost of the distance between two words
     - implemente a neurone network to choose (decision) the closest word to the written word, with the help of the cost of the distance and of the probability of use of the word
     - implemente a function searching on the internet the probability of use of the different words of the different dictionnaries
     - implemente a function that can compare the correction of a word with that of google, or of an other searching tool
     - search for a data base of wrongly written words, in order to have a better understanding of the efficiency of the project
     - list typical errors to auto-correct ?
     - take numbers and special characters into account -> change the "alphabet" string variable
     - upgrade the project to be able to correct a series of words by taking into account the links between those words
     - use the java classes by creating objects, in order to use java as it should be used (not only one class one function, no attribut, no method)
     
  Function stuff to correct :
    SearchingWord : comment, describe the inputs and outputs of the function, and writte a serie of testing for those, modify it in order to have a static array as an output, to make treatments faster -> modify by way of consequence GetCost, Decision.
    TakeDico : comment, describe the inputs and outputs of the function, and writte a serie of testing for those
    CheckWord : comment, describe the inputs and outputs of the function, and writte a serie of testing for those
    Decision : comment, describe the inputs and outputs of the function, and writte a serie of testing for those, see also SearchingWord
    enterWord : comment, describe the inputs and outputs of the function, and writte a serie of testing for those
    GetCost : comment, describe the inputs and outputs of the function, and writte a serie of testing for those, integrate it into PossibleRealWord, or make it so that it can treat farther corrected words, see also SearchingWord
    mainScript : comment, describe the inputs and outputs of the function, and writte a serie of testing for those, add another while loop, in order to generate farther corrected words (with PossibleRealWord), while there are none in the dictionnary 
    PossibleRealWord : comment, describe the inputs and outputs of the function, and writte a serie of testing for those, add the GetCost function in it, in order to take into account farther corrected words

Project Structure :
- Searching Word : from an array of possible corrections of the written word, determine wich are included in the dictionnary
- TakeDico : create a String[] containing the dictionnary, from a .txt
- CheckWord : check if the written word is already in the dictionnary chosen
- Decision : Decide wich correction is the closest to the written word
- enterWord : Ask a word to correct to the user
- GetCost : Get the cost of a correction of the written word
- mainScript : contain the infinite loop asking a word and giving the closest correction
- PossibleRealWord : from the written word, return an array of possible corrected words
