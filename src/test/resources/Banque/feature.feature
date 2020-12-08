#Author: Luc Gireaud
Feature: Banque

  Scenario: Ajouter 1 compte
  Given une agence vide
  When un compte est ajouté
  Then l'agence a un compte
  
   Scenario: Création d'un menu avec 2 options
  Given Un menu
  When On ajoute 2 options
  Then le menu a 2 options
  
   Scenario: Vérification titres d'un menu avec 2 options
  Given Un menu
  When On ajoute 2 options A et B
  Then le menu a 2 options A et B
  
   Scenario: Vérif du code d'un menu
  Given Un menu
  Then code à "0"
  
     Scenario: Vérif du code d'un menu fin
  Given Un menu
  When ferme menu
  Then code à "0"
  
    
  
   
  