<#import "login.ftl" as l>
<#include "security.ftl">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #800080">
    <a class="navbar-brand mb-0 h3" href="/">Summary</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <form class="form-inline my-2">
                        <li class="nav-item">
                <a class="nav-link" href="/user">User list </a>
            </li>

                 <li class="nav-item">
                <a class="nav-link" href="/home">Home </a>
            </li>
                <li class="nav-item">
                    <a class="nav-link" href="/UserPage">Summaries </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/cabinet">My cabinet </a>
                </form>
                </li>
        </ul>
        <@l.logout/>
       </div>
    </nav>