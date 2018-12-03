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
    <p></p>
    <br>
        <script type="text/javascript">
            $(document).ready(function() {
               var html=SimpleMDE.prototype.markdown("${summ.text}");
               document.getElementById("text").innerHTML = html;
            })
                 </script>
        <div id="text"></div>
    <p></p>
    <br>
        <div>
                   <#if summ.filename??>
                       <img src="/img/${summ.filename}">
                   </#if>
        </div>
    <p></p>
    <br>
    <a href="/home"><u>Return</u></a>
    </div>
</form>
</body>
</@c.page>