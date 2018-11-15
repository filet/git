<#import "parts/common.ftl" as c>
<meta charset="utf-8">
<@c.page>
<#--<form action="/UserPage" method="post">-->
<h3>${summ.title}</h3>
<i><br>${summ.descript}
<br>${summ.number}
    <br>${summ.tags}</i>
<p></p>
${summ.text}
    <#--<input type="hidden" value="${user.id}" name="userId">-->
    <#--<button type="submit">Save</button>-->
<#--</form>-->
</@c.page>