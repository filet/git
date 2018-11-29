<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<@c.page>
<body class="bg-light">
<div class="mb-1"><h1 class="h3 mb-3 font-weight-normal" align="center"><u>Add new user:</u></h1></div>
${message?if_exists}
<@l.login "/registration" true/>
</body>
</@c.page>