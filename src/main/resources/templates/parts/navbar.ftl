<#import "login.ftl" as l>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Vtoroe</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">

            <form class="form-inline my-2">
                <li class="nav-item">
                <a class="nav-link" href="/">Home </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/user">User list </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/Summery">Summery </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/UserPage">UserPage </a>
            </li>
                <li class="nav-item">
                    <a class="nav-link" href="/User">User </a>
                </li>
            <li>
                <input type="search" class="form-control mr-sm-2" placeholder="Search" aria-label="Search" size="80%">
             <button type="submit" class="btn btn-outline-success my-2 my-sm-0">Search</button>
                </form>
            </li>
        </ul>
        <@l.logout/>
       </div>
    </nav>