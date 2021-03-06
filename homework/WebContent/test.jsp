<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <link rel="shortcut icon" type="image/ico" href="/images/favicon.ico" />
    <title>Login</title>
    <link href="styles.css" type="text/css" media="screen" rel="stylesheet" />
    <link href="jquery-ui-1.8.16.custom.css" rel="stylesheet">
    <script src="jquery-1.6.2.min.js"></script>
    <script src="jquery-ui-1.8.16.custom.min.js"></script>
    <script type="text/javascript" src="jquery.keyboard.extension-typing.js"></script>
    <link type="text/css" href="keyboard.css" rel="stylesheet" />
    <script type="text/javascript" src="jquery.keyboard.js"></script>


    

</head>
<body id="login">
    <div id="wrappertop">
    </div>
    <div id="wrapper">
        <div id="content">
            <div id="header">
                <h1>
                    <a href="">
                       <!--·ÅÖÃLogo <img src="logo.png"   height="50"  width="100"  alt="logo">--></a></h1>
            </div>
            <div id="darkbanner" class="banner320">
                <h2>
                    Booking Seats  System</h2>
            </div>
            <div id="darkbannerwrap">
            </div>
            <form name="form1" method="post" action="LoginServlet">
            <fieldset class="form">
                <p>
                    <label class="loginlabel" for="user_name" >
                        Username:</label>
                    <input class="logininput ui-keyboard-input ui-widget-content ui-corner-all" name="username"
                        id="user_name" type="text" value="" />
                </p>
                <p>
                    <label class="loginlabel" for="user_password">
                        Password:</label>
                    <span>
                        <input class="logininput"   name="password" id="user_password" type="password" /><img
                            id="passwd" class="tooltip" alt="Click to open the virtual keyboard" title="Click to open the virtual keyboard"
                            src="keyboard.png" /></span>
                </p>
                	<input type="submit"   value="loggin" />
                	
            
                <ul id="forgottenpassword">
                    <li class="boldtext">|</li>
                    <li>
                        <input id="remember" type="checkbox" name="remember" id="rememberMe"><label for="rememberMe">Remember
                            me</label></li>
                </ul>
            </fieldset>
            </form>
                <form action="register.jsp" method="post">
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="register" />
</form>
&nbsp;<form action="search.jsp" method="post">
   &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="search" />
</form>
        </div>
    </div>
    <div id="wrapperbottom_branding">
        <div id="wrapperbottom_branding_text">
            Language:<a href="#" style='text-decoration: none'>Japanese </a>| <a href="#" style='text-decoration: none'>
                English</a></div>
    </div>
    <script type="text/javascript">
        $(document).ready(function() {
            $('#user_password').keyboard({
                openOn: null,
                stayOpen: true,
                layout: 'qwerty'
            }).addTyping();
            $('#passwd').click(function() {
                $('#user_password').getkeyboard().reveal();
            })

            $(".logininput").blur(function() {
                if ($(this).val() == "") {
                    $(this).css("border-color", "red");
                                    }
                else
                    $(this).css("border-color", "#D9D6C4");
            })

            $("#loginbtn").click(function() {
                var k = 0;
                var ajaxhtml = "";
                $(".logininput").each(function(i, obj) {
                    if ($(obj).val().trim() == "") {
                        k++;
                        $(this).css("border-color", "red");
                        $(this).focus();
                        return false;
                    }
                });
                if (k != 0) return;
                ajaxhtml = $("#loginbtn").html();
                $("#loginbtn").html("Loading....  <img src='loading.gif' alt='Announcement' /> ");
                $("#loginbtn").attr("disabled", "disabled");

            })
        });
        
    </script>
</body>
