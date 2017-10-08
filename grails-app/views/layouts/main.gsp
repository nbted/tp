<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Grails"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <asset:stylesheet src="application.css"/>

    <g:layoutHead/>
</head>
<body>

<sec:ifNotLoggedIn>
    <g:link controller='login' action='auth'>

        <h1>connection requise !!!!! </h1>

    </g:link>

</sec:ifNotLoggedIn>
<sec:ifLoggedIn>
    <div class="navbar navbar-default navbar-static-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/#">
                    <i class="fa grails-icon">
                        <asset:image src="poi.png"/>
                    </i> Search POI
                </a>
            </div>
            <div class="navbar-collapse collapse" aria-expanded="false" style="height: 0.8px;">
                <ul class="nav navbar-nav navbar-right">
                    <g:pageProperty name="page.nav" />

                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Nos Services <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/poi/index">List des Poi</a></li>
                            <li><a href="/groupePoi/index">List des Groupes des Poi</a></li>
                            <li><a href="/pages/google">Voir sur les Poi sur le Map</a></li>
                        </ul>
                    </li>

                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Paramètres <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/user/index">Liste des utilisateurs</a></li>
                            <li><a href="/role/index">Liste des Roles</a></li>

                        </ul>
                    </li>

                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> Votre Profile <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="/pages/infoperso">Informations personnelles</a>
                                <a href="/user/edit/1">Edit Profile</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <g:form controller="logout">
                            <g:submitButton name="logout" value="Se deconnecter" />
                        </g:form>
                    </li>
                </ul>

            </div>

             <div class="navbar-collapse collapse">
                 <div id="mySidenav" class="sidenav">
                     <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
                     <a href="#">About</a>
                     <a href="pages/services">Services</a>
                     <a href="user/index">Utilisateurs</a>
                     <a href="#">Contact</a>
                 </div>
                 <div id="main">
                     <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; open</span>
                 </div>

             </div>
        </div>


    </div>

</sec:ifLoggedIn>
<script>
    function openNav() {
        document.getElementById("mySidenav").style.width = "250px";
        document.getElementById("main").style.marginLeft = "250px";
        document.body.style.backgroundColor = "rgba(0,0,0,0.4)";
    }

    function closeNav() {
        document.getElementById("mySidenav").style.width = "0";
        document.getElementById("main").style.marginLeft= "0";
        document.body.style.backgroundColor = "white";
    }
</script>

    <g:layoutBody/>


    <asset:javascript src="application.js"/>

</body>
</html>
