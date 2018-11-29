<#import "parts/common.ftl" as c>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://cdn.rawgit.com/toopay/bootstrap-markdown/master/js/bootstrap-markdown.js"></script>
<link rel="stylesheet" href="https://cdn.rawgit.com/toopay/bootstrap-markdown/master/css/bootstrap-markdown.min.css" />
  <link rel="stylesheet" href="style.css" />
    <meta charset="utf-8">

<@c.page>
<body class="bg-light">
<form method="post" action="/Summery">
<div class="form-group row">
    <label class="col-sm-2 col-form-label"> Title :</label>
    <div class="col-sm-6">
        <input type="text" name="title" class="form-control" placeholder="Title"/>
    </div>
</div>
<div class="form-group row">
    <label class="col-sm-2 col-form-label"> Short description :</label>
    <div class="col-sm-6">
        <input type="text" name="descript" class="form-control" placeholder="Short description"/>
    </div>
</div>
<div class="form-group row">
    <label class="col-sm-2 col-form-label"> Specialty number :</label>
    <div class="col-sm-6">
        <input type="text" name="number" class="form-control" placeholder="Specialty number"/>
    </div>
</div>
<div class="form-group row">
    <label class="col-sm-2 col-form-label"> Tags :</label>
    <div class="col-sm-6">
        <input type="text" name="tags" class="form-control" placeholder="Tags"/>
    </div>
</div>
    <div class="form-group row">
    <label class="col-sm-2 col-form-label"> Text :</label>
    <div class="col-sm-6">
        <input type="text" name="text" class="form-control" placeholder="Text"/>
    </div>
</div>

    <button class="btn btn-primary" type="submit">Save</button>
</form>
</body>
</@c.page>
