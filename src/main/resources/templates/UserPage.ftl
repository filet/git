<#import "parts/common.ftl" as c>

<meta charset="utf-8">

<@c.page>
List of summeries

<table class="table table-striped" id="table-set">

    <thead>
    <tr>
        <th scope="col">Title</th>
        <th scope="col">Descript</th>
        <th scope="col">Number</th>
        <th scope="col">Tags</th>
        <th scope="col">Text</th>
        </tr>
    </thead>
    <tbody>
    <#list summs as s>
    <tr>
        <td><a href="/UserPage/${s.id}"><u>${s.title}</u></a></td>
        <#--<td>${s.title}</td>-->
        <td>${s.descript}</td>
        <td>${s.number}</td>
        <td>${s.tags}</td>
        <td>${s.text}</td>
    </tr>
    </#list>
        </tbody>
</table>
</@c.page>