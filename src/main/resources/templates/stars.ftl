<#import "parts/common.ftl" as c>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<html>
<head>

</head>
<@c.page>
<meta charset="utf-8">
<body class="bg-light">
          <p></p>
        <form action="/UserPage/Page" method="post">
           <input class="form-control" type="text" name="title" value="${summ.title}" size="50%">
           <i><br><input class="form-control" type="text" name="descript" value="${summ.descript}" size="50%">

               <br><input class="form-control" type="text" name="number" value="${summ.number}" size="50%">
               <br> <div class="form-group">
                   <textarea class="form-control" id="area" rows="3" name="text">${summ.text}</textarea>
               </div>
               <input class="form-control" type="hidden" value="${summ.id}" name="summId" size="50%">
            <p style="text-align: right"><button type="submit" class="btn btn-primary">Save</button></p>
            <p></p>

        </form>
</body>
</html>
</@c.page>