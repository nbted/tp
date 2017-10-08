# projetgrailspoi
bonjour
1.Je commence par demande pardon car mon travail est loin d'être parfait
2. Etant en retard et taravaillant seul j'ai rencontré des difficulté surtout sur les droit d'acces d'utilisateur et l'ajout des photos
3. Le disign a été mis à part pour se concentrer sur le fonctionnement
4. voilà mes soucis :

-----------------
a. pour ce qui est d'authentification il ya pas de probleme et pour acceder à mon site on devrait se connecter
b. la gestion des droits d'acces : en premier lieu a été faite via les annotations. En plus de ça j'ai essayé de modifier le controleur UserControler: par exemple la methode "update" a été modifiée de la maniere suivante :


     User current = springSecurityService.currentUser
        def autorite1 = current.getAuthorities().authority
        def autorite2 = user.getAuthorities().authority
        if (current != user){
            if (autorite1.contains('ROLE_ADMIN')){
                user.save  flush:true
            }
            else if (autorite1.contains('ROLE_ANNOUNCER')){
                if(autorite2.contains('ROLE_ANNOUNCER') || autorite2.contains('ROLE_USE') ) {
                    user.save  flush:true
                }
                else render  'mon role ' + current.getAuthorities().authority +' no droit'
             }
            else
                render  'mon role ' + current.getAuthorities().authority +' no droit'

        }
        else  user.save flush:true
        
        
   mais malheureusement cette maniere de faire n'a pas fonctionné l'utilisateur accede seulement sur son profil meme si c'est un admin
   
   j'aimerais une explication sur ce morceaux de code.
   
 3. un autre souci c'est sur les images
   j'ai suivi un tuto qui correspond à votre explication mais arrivé à l'ajout des associations "hasMany ou hasOne" pour lier les images au poi ou groupe des Poi je rencontre une erreur ' mediaPoi not found with id null'  lors de l'upload .Par contre quand j'enleve les relations je peux stocker l'image sur mon serveur local wamp et l'afficher.
   
   Veuiller m' excuser !!


