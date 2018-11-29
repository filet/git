<#import "parts/common.ftl" as c>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<@c.page>
<body class="bg-light">
User editor
<form action="/user" method="post">
    <#list roles as role>
     <div>
         <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
     </div>
    </#list>
    <input type="hidden" value="${user.id}" name="userId">
    <button type="submit">Save</button>
</form>
</body>
</@c.page>