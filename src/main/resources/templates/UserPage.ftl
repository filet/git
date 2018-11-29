<#import "parts/common.ftl" as c>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<meta charset="utf-8">

<@c.page>
<body class="bg-light">
<div class="mb-1"><h1 class="h3 mb-3 font-weight-normal">
    List of summaries</h1>

    <form method="post" action="/UserPage/Filt" class="form-inline my-2 my-lg-2">
        <input type="text" name="filterr" class="form-control mr-sm-2" placeholder="Search"  width="10%">
        <button type="submit" class="btn btn-primary">Search</button>
    </form>
<table class="table table-striped" id="table-set">

    <thead>
    <tr>
        <th scope="col">Title</th>
        <th scope="col">Descript</th>
        <th scope="col">Number</th>
        <th scope="col">Tags</th>
        <th scope="col">Text</th>
            <th scope="col">Date</th>
        <th scope="col">Rate</th>

    </tr>
    </thead>
    <tbody>
    <#list summs1 as s>
    <tr>
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
            <td>${s.dateRegistr}</td>
        <td>
                <a href="/search?">${s.ratings} </a>
            <#--<#list comments as com>-->
                <#--<a href="/search">${com.text} </a>-->
            <#--<#else >-->
                <#--No com-->
            <#--</#list>-->
        </td>
            <#--<td>-->
                  <#--<#list s.comment as comment>-->
                      <#--Text:${comment.text}-->
                  <#--</#list>-->
            <#--</td>-->
    </tr>
    </#list>
        </tbody>
</table>
</body>
</@c.page>