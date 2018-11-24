<#import "parts/common.ftl" as c>

<meta charset="utf-8">
<@c.page>
<#--<form action="/UserPage" method="post">-->
<form action="/UserPage/Page" method="post">
    <#--<script>-->
        <#--var simplemde = new SimpleMDE({ element: $("#MyID")[0] });-->
        <#--simplemde.value();-->
        <#--simplemde.value("This text will appear in the editor");-->
    <#--</script>-->
    <p style="text-align: left"><button type="submit" class="btn btn-primary">Save</button></p>
    <p></p>
        <input class="form-control" type="text" name="title" value="${summ.title}" size="50%">
    <#--<h3>${summ.title}</h3>-->
    <i><br><input class="form-control" type="text" name="descript" value="${summ.descript}" size="50%">


    <br><input class="form-control" type="text" name="number" value="${summ.number}" size="50%">

    <#--<br><input class="form-control" type="text" name="tags" value="${summ.tags}" size="50%"></i>-->
    <#--<p></p>-->
    <div class="form-group">
        <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="text">${summ.text}</textarea>
        <#--<input class="form-control" type="text" name="text" value="${summ.text}">-->
    </div>
    <#--<input type="text" name="text" value="${summ.text}" size="50%">-->
    <input class="form-control" type="hidden" value="${summ.id}" name="summId" size="50%">
    <#--<a href="/user/User">Return</a>-->


</form>
    <#--<input type="hidden" value="${user.id}" name="userId">-->
    <#--<button type="submit">Save</button>-->
<#--</form>-->
</@c.page>