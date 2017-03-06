import urllib
import time
import os
import sys 
import pickle
from bs4 import BeautifulSoup
import re
    
def searchingWords(nbOfTimes):
    x = time.clock()
    #ouverture du dictionnaire de recherche
    txt = open('G:\Java_CO\\BDD_WORDS.txt',"r")
    DicoReal = []
    lines = txt.readlines()
    for line in (lines):#on utilise pas les MAJ, attention !!
        if ord(line[0])<97:#change les MAJ en min
            lane = ""
            lane+=chr(ord(line[0])+32)
            for k in range(len(line)):
                if k>0:
                    lane+=line[k]
            line = lane
        DicoReal.append(line[0:len(line)-1])#enlève le retour chariot à la fin
        
        
    #Initialisation : création/ouverture du fichier qui contiendra le nombre de fois que chaque mot à été utilisé -> NbUsed, liste d'int, correspondant au rang dans le dictionnaire du mot étudié, donc même len que celle du dico.
    try:
        txt=open('G:\Java_CO\\UsedWords',"rb")
        mon_depickler = pickle.Unpickler(txt)
        NbUsed = mon_depickler.load()
        txt.close()
    except:
        NbUsed = [0]*len(DicoReal)
        txt=open('G:\Java_CO\\UsedWords',"wb")
        mon_pickler = pickle.Pickler(txt)
        mon_pickler.dump(NbUsed)
        txt.close()
        
    #Initialisation : création/ouverture du fichier qui contiendra le nombre de mots total du dico trouvés
    try:
        txt=open('G:\Java_CO\\TotalFoundWords',"rb")
        mon_depickler = pickle.Unpickler(txt)
        totalFoundWords = mon_depickler.load()
        txt.close()
    except:
        totalFoundWords=0
        txt=open('G:\Java_CO\\TotalFoundWords',"wb")
        mon_pickler = pickle.Pickler(txt)
        mon_pickler.dump(totalFoundWords)
        txt.close()
        
    nbDone = 0
    while nbDone< nbOfTimes:#pour chaque page
        
        htmlSource = urllib.request.urlopen("https://en.wikipedia.org/wiki/Special:Random")#accède au site internet
        html = htmlSource.read()
        soup = BeautifulSoup(html, 'html.parser')
        Soup = soup.find_all('p')#prend le texte entre les balises p
        
        for j in range(len(Soup)):#pour chaque ligne
            
            listt = Soup[j].text.replace("'"," ")
            chaine1 = listt.replace(":","").replace(";","").replace(".","").replace("!","").replace("?","").replace(",","").replace('"',"").replace("-"," ").lower()
            regex = re.compile(r"[a-z]+s ")
            chaine2 = regex.findall(chaine1)#cherche les mots finissant pas un s (les pluriels)
            chaine2 = ' '.join(chaine2)
            chaine2 = chaine2.replace("s "," ")#string de mots sans le s final
            WordList = chaine1.split() + chaine2.split()#liste des mots
            
            
            for k in range(len(WordList)):#pour chaque mot de chaque ligne
                try:
                    cran = DicoReal.index(WordList[k])
                    totalFoundWords+=1
                    NbUsed[cran]+=1
                except:
                    de=4
        
            
        txt=open('G:\Java_CO\\TotalFoundWords',"wb")#sauvegarde les chgments effectués
        mon_pickler = pickle.Pickler(txt)
        mon_pickler.dump(totalFoundWords)
        txt.close()
        
        txt=open('G:\Java_CO\\UsedWords',"wb")
        mon_pickler = pickle.Pickler(txt)
        mon_pickler.dump(NbUsed)
        txt.close()
       
        nbDone+=1
        print("nombre de pages consultées : " + str(nbDone))
        print("nombre de mots trouvés : " + str(totalFoundWords))
    return time.clock()-x