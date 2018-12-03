<#import "parts/common.ftl" as c>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/simplemde/latest/simplemde.min.css">
<script src="https://cdn.jsdelivr.net/simplemde/latest/simplemde.min.js"></script>
<html>
<@c.page>
<meta charset="utf-8">
<body class="bg-light">
          <p></p>
        <form action="/UserPage/Page" method="post" enctype="multipart/form-data">
           <input class="form-control" type="text" name="title" value="${summ.title}" size="50%">
           <i><br><input class="form-control" type="text" name="descript" value="${summ.descript}" size="50%">

               <br><input class="form-control" type="text" name="number" value="${summ.number}" size="50%">
               <script>
                   $(document).ready(function () {
                       createMarkdown(document.getElementById("area"));
                       function createMarkdown(textarea) {
                           simplemde = new SimpleMDE({
                               element: textarea
                           })}
                       });
               </script>
               <br> <div class="form-group">
                   <textarea class="form-control" id="area" rows="3" name="text">${summ.text}</textarea>
               </div>
               <input class="form-control" type="hidden" value="${summ.id}" name="summId" size="50%">
            <p style="text-align: right"><button type="submit" class="btn btn-primary">Save</button></p>
            <p></p>
               <div class="custom-file">
          <input type="file" name="file" id="customFile">
               <label class="custom-file-label" for="customFile">Choose File</label>
               </div>
                   <div>
                   <#if summ.filename??>
                       <img src="/img/${summ.filename}">
                   </#if>
               </div>
        </form>
</body>
</html>
</@c.page>