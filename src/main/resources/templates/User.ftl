<#import "parts/common.ftl" as c>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<meta charset="utf-8">

<@c.page>
<body class="bg-light">
    <h3>Personal Area</h3>
    <form method="post" action="/user/User" class="form-inline my-2 my-lg-2">
    <input type="text" name="filterr" class="form-control mr-sm-2" placeholder="Search"  width="10%">
    <button type="submit" class="btn btn-primary">Search</button>
</form>
    <a href="/Summery">Create of summaries</a>
    <table class="table table-striped" id="table-set">

        <thead>
        <tr>
            <th>
                <button onclick="onClickBtnAllSummeries()">All</button>
            </th>
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
        <th>
            <input type="checkbox" value="${s.id}">
        </th>
        <td><a href="/UserPage/Page/${s.id}"><u>${s.title}</u></a></td>
        <td>${s.descript}</td>
        <td>${s.number}</td>
        <#--<td>${.tags}</td>-->
        <td>${s.text}</td>
    </tr>
    </#list>
        <script>
            function onClickBtnAllSummeries(){
                $('body input:checkbox').prop('checked', true)
            }
            function getArrayIdSummeries(){
                arrayIdSummeries = [];

                $('input:checkbox:checked').each(function(){
                    arrayIdSummeries.push($(this).val());
                });

                return arrayIdSummeries;
            }
        </script>
        <button onclick="onClickBtnDeleteSummery()">Delete</button>
        <a href="/user/profile">Edit</a>
        <script>
            function onClickBtnDeleteSummery(){
                idSummeries = getArrayIdSummeries();

                $.ajax({
                    url: '/deletesummeries',
                    dataType: 'json',
                    data: JSON.stringify(idSummeries),
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

        </tbody>
    </table>
</form>
</body>
</@c.page>