<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<#escape x as x?if_exists>
	<p>${nv.name}</p>
	<p>${nv.author}</p>
	<p>${nv.info}</p>
	<p>${nv.status}</p>
	<p>${nv.novleType}</p>
	<p>----------</p>
	<div id="ca">
		<#list nv.catalogues as ca> <!-- <#if ca_index<2000> -->
		<p>
			<a href="#" na="${ca.name}" >${ca.name}</a><!-- <#else><#break> -->
		</p>
		<!-- </#if> --> </#list>
	</div>
	</#escape>
</body>
<script src="${rc.getContextPath()}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">

function info(ca){
	$.post("${rc.getContextPath()}/info",{"id":"${nv.name}","ca":ca,"author":"${nv.author}"}, 
			function(data) {
				alert(data);
				return false;
			});
	return false;
}
$(document).ready(function(){
	$("#ca a").click(function(){
		return info($(this).attr("na"));
	});
});


</script>
</html>