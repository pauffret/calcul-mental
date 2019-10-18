<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>E-Calcul</title>
    <link rel="stylesheet" type="text/css"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css"/>
    <link rel="stylesheet" type="text/css"
          href="<%= request.getContextPath()%>/vendor/foundation-6.5.1/css/foundation.min.css"/>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/css/style.css"/>
</head>
<body>

    <div class="callout large primary">
        <div class="row column text-center">
            <h1>E-Calcul</h1>
            <h3>1ère Question</h3>
        </div>
    </div>
    <div class="row small-1 small-centered">
        <span class="card-divider">14*2/8</span>
        <form method="POST" action="jeu">

        </form>
    </div>


    <script src="<%= request.getContextPath()%>/vendor/foundation-6.5.1/js/vendor/jquery.js"></script>
    <script src="<%= request.getContextPath()%>/vendor/foundation-6.5.1/js/vendor/foundation.min.js"></script>
    <script>
        $(document).foundation();
        document.documentElement.setAttribute('data-useragent', navigator.userAgent);
    </script>
</body>
</html>