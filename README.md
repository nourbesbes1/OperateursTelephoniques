# OperateursTelephoniques
Application mobile qui permet à l'utilisateur de recharger son téléphone et de consulter son solde.

En cas de succès de l’authentification l’utilisateur est redirigé vers une deuxième activité.

Lors de l’initialisation de la deuxième activité, le login doit être affiché en haut à droite de l’écran sous l'image.

L’utilisateur est demandé de saisir un numéro de téléphone.

Vous devez détecter le fournisseur de ligne (Voir Figure 2) correspondant à votre numéro (Tunisie Telecom, Ooredoo, Orange,…) 

Une fois vous avez détectés le fournisseur, vous devez remplir les champs nécessaires pour recharger la ligne ainsi que le code nécessaire pour consulter votre solde.

Vous devez implémenter le code nécessaire pour valider les entrées de l’utilisateur : 
  1. Numéro de téléphone de type numérique (8 chiffres)
  2. code de recharge de type numérique (taille selon opérateur téléphonique)
  3. couleurs : voir interfaces de la figure 2.
  
Une fois l’utilisateur appui sur le bouton de titre Appeler, vous devez le rediriger vers le compositeur téléphonique en envoyant le code adéquat.


![fig](https://user-images.githubusercontent.com/62994130/226364484-b51d5457-be32-4cca-ba90-d0df00178838.PNG)
