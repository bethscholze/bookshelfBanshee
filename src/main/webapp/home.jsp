
<html>
<!-- <%-- <%@include file="head.jsp"%> --%> -->
<!-- this is the stuff in the head.jsp -->
    <!DOCTYPE html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title>${title}</title>
        <link href="https://fonts.googleapis.com/css?family=Rye&display=swap" rel="stylesheet">
        <!-- Bootstrap 4 -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <!-- My stylesheet -->
        <link rel="stylesheet" href="styles.css">


        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </head>
    <!-- this is the head stuff -->
    <!--  -->

    <body class="container-fluid p-0">
        <header class="pageBackground jumbotron jumbotron-fluid d-flex flex-wrap p-0">
            <div class="col-12 align-self-top d-flex justify-content-end">
                <button class="btn my-1 mx-1 p-1" type="button" name="logout">Logout</button>
                <button  class="btn my-1 mx-1 p-1" type="button" name="button">Profile</button>
            </div>
            <div class="col-12 align-self-center p-5">
                <h1>Bookshelf Banshee</h1>
            </div>
            <!-- create header image with navbar elements below -->
            <nav class="navbar navbar-expand-md navbar navbar-dark bg-dark col-12 align-self-end">
                <a href="#" class="navbar-brand">Bookshelf Banshee</a>
                <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse1">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarCollapse1">
                    <div class="navbar-nav">
                        <a href="#" class="nav-item nav-link active">Home</a>
                        <a href="#" class="nav-item nav-link">Bookshelf</a>
                        <a href="#" class="nav-item nav-link">Lists</a>
                        <a href="#" class="nav-item nav-link">Stats</a>
                    </div>
                    <form class="form-inline ml-auto bg-dark">
                        <input type="text" class="form-control mr-sm-2" placeholder="Search">
                        <button type="submit" class="btn btn-outline-light bg-info">Search</button>
                    </form>
                </div>
            </nav>
        </header>
        <section class="row justify-content-around d-flex align-items-center mx-5">
            <div class="col-3 card">
                <h2>Bookshelf</h2>
            </div>
            <div class="col-3 card">
                <h2>Lists</h2>
            </div>
            <div class="col-3 card">
                <h2>Stats</h2>
            </div>

        </section>


    </body>


</html>
