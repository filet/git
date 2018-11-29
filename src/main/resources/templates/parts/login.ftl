<#macro login path isRegisterForm>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<body class="bg-light">
<form action="${path}" method="post" class="form-signin">
    <h1 class="h3 mb-3 font-weight-normal" align="center">Please sign in</h1>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"></label>
        <label class="col-sm-2 col-form-label"></label>
        <div class="col-sm-4">
            <input align="center" type="text" name="username" class="form-control" placeholder="User name"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"></label>
        <label class="col-sm-2 col-form-label"></label>
        <div class="col-sm-4">
            <input type="password" name="password" class="form-control" placeholder="Password"/>
        </div>
    </div>
    <#if isRegisterForm>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"></label>
        <label class="col-sm-2 col-form-label"></label>
        <div class="col-sm-4">
            <input type="email" name="email" class="form-control" placeholder="some@some.com"/>
        </div>
    </div>
    </#if>
    <#if !isRegisterForm>
    <label class="col-sm-5 col-form-label"></label>
        <a href="/registration">Add new user</a></#if>
    <#if isRegisterForm>
    <label class="col-sm-7 col-form-label"></label>
        <a href="/registration"></a></#if>
    <button class="btn btn-primary" type="submit">
    <#if !isRegisterForm>Sign In</#if>

         <#if isRegisterForm>Create</#if>

    </button>
</form>
</#macro>
</body>
<#macro logout>
<body class="bg-light">
<form action="/logout" method="post">
    <button class="btn btn-outline-warning my-2 my-sm-0" type="submit">Sign Out</button>
</form>
</body>
</#macro>