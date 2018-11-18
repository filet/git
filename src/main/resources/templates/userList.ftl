<#import "parts/common.ftl" as c>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<meta charset="utf-8">

<@c.page>
List of users

<table class="table table-striped" id="table-set">

    <thead>
    <tr>
        <th>
            <button onclick="onClickBtnAll()">All</button>
        </th>
        <th scope="col">Name</th>
        <th scope="col">Role</th>
        <th scope="col">Edit</th>
        <th scope="col">DateReg</th>
        <th scope="col">DateLastSeen</th>
        <th scope="col">Active</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <#list users as user>
    <tr>
        <th>
            <input type="checkbox" value="${user.id}">
        </th>
        <td><u><a href="/user/User/${user.id}">${user.username}</a></u></td>
        <td><#list user.roles as role>${role}<#sep>, </#list></td>
        <td><a href="/user/${user.id}">edit</a></td>
        <td>${user.dateReg}</td>
        <td>${user.dateLastSeen}</td>
        <td>${user.active?c}</td>
    </tr>
    </#list>
    <script>
        function onClickBtnAll(){
            $('body input:checkbox').prop('checked', true)
        }
        function getArrayIdUser(){
            arrayIdUser = [];

            $('input:checkbox:checked').each(function(){
                arrayIdUser.push($(this).val());
            });

            return arrayIdUser;
        }
    </script>
    <button onclick="onClickBtnDelete()">Delete</button>
    <script>
        function onClickBtnDelete(){
            idUsers = getArrayIdUser();

            $.ajax({
                url: '/delete',
                dataType: 'json',
                data: JSON.stringify(idUsers),
                contentType: "application/json",
                type: 'post',
                success: function(settings){
                    if(settings=="1") {
                        window.location.reload()
                    }else{
                        document.location.href = "http://localhost:8080/login?logout";
                    }
                }
            });
        }
    </script>
    <button onclick="onClickBtnBlock()">Block</button>
    <script>
        function onClickBtnBlock(){
            idUsers = getArrayIdUser();
            $.ajax({
                url: '/update',
                dataType:'json',
                data: JSON.stringify(idUsers),
                contentType: "application/json",
                type: 'post',
                success: function(settings){
                    if (settings=="1") {
                        window.location.reload();
                } else {
                    document.location.href = "http://localhost:8080/login?logout";
        }
                                    }
                });
        }
    </script>
    <button onclick="onClickBtnUnBlock()">UnBlock</button>
    <script>
        function onClickBtnUnBlock(){
            idUsers = getArrayIdUser();
            $.ajax({
                url: '/updatee',
                dataType:'json',
                data: JSON.stringify(idUsers),
                contentType: "application/json",
                type: 'post',
                success: function(settings){
                    if (settings=="1") {
                        window.location.reload();
                    } else {
                        document.location.href = "http://localhost:8080/login?logout";
                    }
                }
            });
        }
        </script>
    </tbody>
</table>
</@c.page>