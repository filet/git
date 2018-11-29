<#import "parts/common.ftl" as c>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/simplemde/latest/simplemde.min.css">
    <script src="https://cdn.jsdelivr.net/simplemde/latest/simplemde.min.js"></script>
    <meta charset="utf-8">
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<@c.page>
<body class="bg-light">
<form action="/home" method="post">

    <div class="text-center"> <h3>${summ.title}</h3>

    <br><em>Description:</em> ${summ.descript}
    <br><em>Cpeciality:</em> ${summ.number}
     <#--<br>${summ.tags}</i>-->
    <p></p>
    <br>
        ${summ.text}
    <p></p>
    <br>
    <p></p>
    <br>
    <a href="/home"><u>Return</u></a>
    </div>
</form>
</body>
</@c.page>