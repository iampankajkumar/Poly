<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>

<head>
<title>User Page :: polytechnique</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/footer.css">
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.12.4.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery.js"></script>
<meta name="keywords"
	content="Registration / Login form Responsive Widget, Login forms,Flat Pricing tables,Flat Drop downs  Sign up Web forms, Login sign up Responsive web Forms," />

<script type="application/x-javascript">
        addEventListener("load", function() {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!-- font CSS -->
<!--
<link href='//fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
<link href="//fonts.googleapis.com/css?family=Archivo+Black" rel="stylesheet">-->
<link href="//fonts.googleapis.com/css?family=Signika:300,400,700"
	rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Roboto+Condensed:400,700"
	rel="stylesheet">

<!--font CSS-->
<script src="js/jquery2.0.3.min.js"></script>
<script type="text/javascript"
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js">
		
	</script>
	<script type="text/javascript">
		$(document).ready(
				function() {
					$.ajax({
						url : "getAllNewsList",
						dataType : "application/json",
						success : function(JSONdata) {
							var data = $.parseJSON(JSONdata);
							$(data).each(
							function(index, value) {
								$('#myModalBody').append("<div class='panel panel-primary'><div class='panel-heading'> >>"
										+data[index].heading+"</div><div class='panel-body'><p>"
										+data[index].description+"</p><p><a download='"
										+data[index].newsFileName+"'	href='"+data[index].newsFile+"' title='"+data[index].newsFileName+"'> Download	attachment </a></p></div></div>");
							});

						}
					});
				});
	</script>
</head>

<body class="dashboard-page">
	<nav class="navbar navbar-inverse navbar-static-top">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">GTI-Daily-Info</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse pull-right"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="#">About</a></li>
					<li><a href="#">Services</a></li>
					<li><a href="#">Contact</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>
  <div class="container">
  	<a href="#" class="btn btn-success btn-lg btn-block">Upload new information</a>
  	<hr>
  </div>
<div class="container">
  <div id="myModalBody"></div>
</div>
<!-- footer -->
	<hr>
	<div class="text-center center-block">
		<p class="txt-railway">- Bootsnipp.com -</p>
		<br /> <a href="https://www.facebook.com/bootsnipp"><i
			id="social-fb" class="fa fa-facebook-square fa-3x social"></i></a> <a
			href="https://twitter.com/bootsnipp"><i id="social-tw"
			class="fa fa-twitter-square fa-3x social"></i></a> <a
			href="https://plus.google.com/+Bootsnipp-page"><i id="social-gp"
			class="fa fa-google-plus-square fa-3x social"></i></a> <a
			href="mailto:bootsnipp@gmail.com"><i id="social-em"
			class="fa fa-envelope-square fa-3x social"></i></a>
	</div>
	<div class="footer">
		<p>
			All Rights Reserved . Design by <a href="#">PremSoft Infotech</a>
		</p>
	</div>
	<!-- //footer -->
	<!-- input-forms -->

	<script type="text/javascript" src="js/valida.2.1.6.min.js"></script>
	<script type="text/javascript">
        $(document).ready(function() {

            // show Valida's version.
            $('#version').valida('version');

            // Exemple 1
            $('.valida').valida();
            // setup the partial validation
            $('#partial-1').on('click', function(ev) {
                ev.preventDefault();
                $('#res-1').click(); // clear form error msgs
                $('form').valida('partial', '#field-1'); // validate only field-1
                $('form').valida('partial', '#field-1-3'); // validate only field-1-3
            });

        });
    </script>
	<!-- //input-forms -->
	<!--validator js-->
	<script src="js/validator.min.js"></script>
	<!--//validator js-->
</body>

</html>