<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<@c.page>
<#if Session?? && Session.SPRING_SECURITY_LAST_EXCEPTION??>
    <div class="alert alert-danger" role="alert">
        ${Session.SPRING_SECURITY_LAST_EXCEPTION.message}
    </div>
</#if>
    <#if message??>
    <div class="alert alert-${messageType}" role="alert">
        ${message}
    </div>
    </#if>
<@l.login "/login" false/>
</@c.page>
