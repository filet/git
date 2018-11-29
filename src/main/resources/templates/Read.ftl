<#import "parts/common.ftl" as c>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<meta charset="utf-8">
<@c.page>
<body class="bg-light">
<form action="/UserPage/" method="post" enctype="multipart/form-data">
   <p></p>
    <style type="text/css">
        #rating_arr {
            width: 320px;
            text-align: right;
        }
        #rating_arr div { float: left; }
        #rating_arr p { margin: 0; padding: 0; }
        .param {
            width: 110px;
            margin: 0 20px 0 0;
            text-align: right;
        }
        .param, .rating, #summ { line-height: 28px; }
        .stars_progress, #sum_stars { background: url(../static/stars.png); }
        .stars_progress, #sum_stars, .progress_stars, #sum_progress {
            width: 130px;
            height: 28px;
            cursor: pointer;
        }
        .progress_stars { background: #FFEE00; }
        #sum_progress { background: #00EE00; }
        .rating, #summ {
            margin: 0 0 0 20px;
            font-weight: bold;
        }
    </style>
    <div id="rating_arr">
        <div class="stars_progress"></div><p class="progress_stars" id="p3"></p>

        <div id="sum_stars"></div><p id="sum_progress"></p>
    </div>
    <div class="text-center"> <h3>${summ.title}</h3>
        <br><em>Description:</em> ${summ.descript}
        <br><em>Cpeciality:</em>${summ.number}

        <p></p>${summ.text}</div>

        <p></p>
    <div class="form-inline my-2 my-lg-2">
            <label class="col-sm-2 col-form-label"> Comment :</label>

                <input type="text" name="commentar" class="form-control  mr-sm-2" placeholder="Text" size="90%"/>
                <button type="submit" class="btn btn-primary">Save</button>

        </div>
        <p></p>

        <#list summ.comment as comment>
        <ul>
            Text:${comment.text}
        </ul>
        </#list>

        <input class="form-control" type="hidden" value="${summ.id}" name="summId" size="50%">

</form>
</body>
</@c.page>