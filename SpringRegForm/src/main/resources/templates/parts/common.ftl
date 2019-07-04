<#macro common>
    <#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Reg Form</title>
    <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous"/>
    <link rel="stylesheet" href="../../css/styles.css"/>
</head>
<body>
<header>
    <h1>Registration Form</h1>
    <a class="lang" href="?lang=en"><@spring.message "lang.eng"></@spring.message></a>
    <a class="lang" href="?lang=ua"><@spring.message "lang.ua"></@spring.message></a>
</header>
<#nested>
</body>
</html>
</#macro>