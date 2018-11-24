<#import "parts/common.ftl" as c>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<meta charset="utf-8">

<@c.page>
List of summaries
<#--<form action="/UserPage" method="post">-->
    <form method="post" action="UserPage" class="form-inline my-2 my-lg-2">
        <input type="text" name="filter" class="form-control mr-sm-2" placeholder="Search"  width="10%">
        <button type="submit" class="btn btn-primary">Search</button>
    </form>
<table class="table table-striped" id="table-set">

    <thead>
    <tr>
        <#--<th>-->
            <#--<button onclick="onClickBtnAllSummeries()">All</button>-->
        <#--</th>-->
        <th scope="col">Title</th>
        <th scope="col">Descript</th>
        <th scope="col">Number</th>
        <th scope="col">Tags</th>
        <th scope="col">Text</th>
            <th scope="col">Comment</th>
        </tr>
    </thead>
    <tbody>
    <#list summs as s>
    <tr>
        <#--<th>-->
            <#--<input type="checkbox" value="${s.id}">-->
        <#--</th>-->
            <td><a href="/UserPage/${s.id}"><u><em>${s.title}</em></u></a></td>
        <td>${s.descript}</td>
        <td>${s.number}</td>

        <td>
            <#list s.tags as tag>
                <a href="/search?">${tag.tags} </a>
                <#else >
                No tags
            </#list>
        </td>
        <td>${s.text}</td>
        <td>
            <#list comments as com>
                <a href="/search">${com.text} </a>
            <#else >
                No com
            </#list>
        </td>
    </tr>
    </#list>
    <#--<script>-->
        <#--function onClickBtnAllSummeries(){-->
            <#--$('body input:checkbox').prop('checked', true)-->
        <#--}-->
        <#--function getArrayIdSummeries(){-->
            <#--arrayIdSummeries = [];-->

            <#--$('input:checkbox:checked').each(function(){-->
                <#--arrayIdSummeries.push($(this).val());-->
            <#--});-->

            <#--return arrayIdSummeries;-->
        <#--}-->
    <#--</script>-->
    <#--<button onclick="onClickBtnDeleteSummeries()">Delete</button>-->
    <#--<script>-->
        <#--function onClickBtnDeleteSummeries(){-->
            <#--idSummeries = getArrayIdSummeries();-->

            <#--$.ajax({-->
                <#--url: '/deletesummeries',-->
                <#--dataType: 'json',-->
                <#--data: JSON.stringify(idSummeries),-->
                <#--contentType: "application/json",-->
                <#--type: 'post',-->
                <#--success: function(settings){-->
                    <#--if(settings=="1") {-->
                        <#--window.location.reload()-->
                    <#--}else{-->
                        <#--document.location.href = "http://localhost:8080/UserPage";-->
                    <#--}-->
                <#--}-->
            <#--});-->
        <#--}-->
    <#--</script>-->
        </tbody>
</table>
<#--</form>-->
</@c.page>