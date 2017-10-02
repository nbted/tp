

<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>

</head>
<body>

       <h1>Votre Profile</h1>
        Vous etes connecter en tant que 
        <sec:loggedInUserInfo field="username"></sec:loggedInUserInfo>
        votre mon de passe est actif ?

        <sec:loggedInUserInfo field="enabled"></sec:loggedInUserInfo>

</body>
</html>
