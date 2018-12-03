<#import "parts/common.ftl" as c>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<@c.page>
<body class="bg-light">
<h1 class="h3 mb-3 font-weight-normal" align="center">
    User editor</h1>
<form action="/user" method="post">
    <#list roles as role>
     <div class="text-center">
         <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
     </div>
    </#list>
    <input type="hidden" value="${user.id}" name="userId">
    <div class="text-center">
    <button type="submit" class="btn btn btn-outline-primary">Save</button>
    </div>
</form>
</body>
</@c.page>