<#macro common>
    <#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Reg Form</title>

    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <#--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>-->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../../css/styles.css"/>
</head>
<body>
<header>
    <h1>Registration Form</h1>
    <a href="/calculate"><@spring.message "calculator"/></a>
    <a href="/main"><h2>login</h2></a>
    <a href="/registration"><h2>reg</h2></a>
    <a class="lang" href="?lang=en"><@spring.message "lang.eng"></@spring.message></a>
    <a class="lang" href="?lang=ua"><@spring.message "lang.ua"></@spring.message></a>
</header>
<#nested>
</body>
</html>
</#macro>