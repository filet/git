<#import "parts/common.ftl" as c>
<meta charset="utf-8">
<@c.page>
<#--<form action="/UserPage" method="post">-->
<form action="/UserPage" method="post">
    <input type="text" name="title" value="${summ.title}">
    <button type="submit">Save</button>
<#--<h3>${summ.title}</h3>-->
<i><br><input type="text" name="descript" value="${summ.descript}">
<br><input type="text" name="number" value="${summ.number}">
    <br><input type="text" name="tags" value="${summ.tags}"></i>
<p></p>
    <input type="text" name="text" value="${summ.text}">
    <input type="hidden" value="${summ.id}" name="summId">
</form>
    <#--<input type="hidden" value="${user.id}" name="userId">-->
    <#--<button type="submit">Save</button>-->
<#--</form>-->
</@c.page>