<#import "parts/common.ftl" as c>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/simplemde/latest/simplemde.min.css">
<script src="https://cdn.jsdelivr.net/simplemde/latest/simplemde.min.js"></script>

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
<meta charset="utf-8">
<@c.page>
<body class="bg-light">
<form action="/UserPage" method="post" enctype="multipart/form-data">
    <input type="hidden" name="summId" value="${summ.id}">
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
        <div class="stars_progress"  title="${rating}"></div><p class="progress_stars" id="p3"></p>

        <div id="sum_stars" title="${summ.getRatings()}"></div><p id="sum_progress"></p>
    </div>
    <script type="text/javascript">
        $(document).ready(function() {
            if($('.stars_progress').attr('title') != 0){
                $('.stars_progress').toggleClass('fixed');
                $('.progress_stars').width(Math.round($('.stars_progress').width() * $('.stars_progress').attr('title') / 5));
            }
            $('#sum_progress').width(Math.round($('.stars_progress').width() * $('#sum_stars').attr('title') / 5));
            function move(e, obj) {
                var summ = 0;
                var id = obj.next().attr('id').substr(1);
                var progress = e.pageX - obj.offset().left;
                var rating = progress * 5 / $('.stars_progress').width();
                $('#param' + id).text(rating.toFixed(1));
                obj.next().width(progress);
                $('.rating').each(function () {
                    summ += parseFloat($(this).text());
                });
                summ = summ / $('.rating').length;
                return rating;
            }

            $('#rating_arr .stars_progress').click(function(e){
               if ($(this).attr("class")!="stars_progress fixed") {
                   $(this).toggleClass('fixed');
                   var rating = move(e, $(this));
                   var idS = document.getElementById("summId").value;
                   $.ajax({
                       url: '/save',
                       data: ({
                           "rating": rating,
                           "idSummaries": idS
                       }),
                       type: 'post',
                       success: function (settings) {
                           if (settings == "1") {
                               window.location.reload();
                           } else {
                               document.location.href = "http://localhost:8080/login?logout";
                           }
                       }
                   });
               }
            })

            $('#rating_arr .stars_progress').on('mousemove', function(e){
                if ($(this).hasClass('fixed')==false) move(e, $(this));
            });
            $('#rating_arr [type=submit]').click(function(){
                summ = parseFloat($('#summ').text());
                jQuery.post('change_rating.php', {
                    obj_id: $(this).attr('id').substr(3),
                    rating: summ
                }, notice);
            });

            function notice(text){
                $('#message').fadeOut(500, function(){ $(this).text(text); }).fadeIn(2000);
            }
        });
    </script>
    <div></div>
    <div class="text-center"> <h3>${summ.title}</h3>
        <br><em>Description:</em> ${summ.descript}
        <br><em>Cpeciality:</em>${summ.number}

        <p></p>
        <script type="text/javascript">
            $(document).ready(function() {
                var html=SimpleMDE.prototype.markdown("${summ.text}");
                document.getElementById("textarea").innerHTML = html;
            })
        </script>
        <div id="textarea"></div>
    <div>
                   <#if summ.filename??>
                       <img src="/img/${summ.filename}">
                   </#if>
    </div>
    </div>
        <p></p>
    <br>

    <b> Comments:</b>
    <div class="form-inline my-2 my-lg-2">
                <br>
        <input type="text" name="commentar" class="form-control  mr-sm-2" placeholder="Text" size="90%"/>
                <button type="submit" class="btn btn-primary">Save</button>

        </div>
        <p></p>

        <#list summ.comment as comment>
        <ul>
            <b>Comment by ${comment.getUser().username}:</b>
            <br>
            ${comment.text}
            <br>
            <p></p>
        </ul>
        </#list>

        <input class="form-control" type="hidden" value="${summ.id}" id="summId" size="50%">

</form>
</body>
</@c.page>