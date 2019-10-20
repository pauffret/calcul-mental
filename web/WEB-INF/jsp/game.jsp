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

<div class="container">
    <div class="callout large primary">
        <div class="row column text-center">
            <h1>E-Calcul</h1>
        </div>
    </div>
    <div class="text-center">
        <p>${game.pile}</p>
        <b>Le calcul: ${game.calcul}</b>
        <form method="post" action="game">
            <div class="row">
                <div class="input-field col s12">
                    <label for="reponse_user">Votre réponse:
                        <input id="reponse_user" name="reponse" type="number" step="any" class="validate" required>
                    </label>
                </div>
                <button class="button expanded" type="submit" name="action">Valider réponse</button>
            </div>
        </form>
    </div>
</div>


    <script src="<%= request.getContextPath()%>/vendor/foundation-6.5.1/js/vendor/jquery.js"></script>
    <script src="<%= request.getContextPath()%>/vendor/foundation-6.5.1/js/vendor/foundation.min.js"></script>
    <script>
        $(document).foundation();
        document.documentElement.setAttribute('data-useragent', navigator.userAgent);
    </script>
</body>
</html>