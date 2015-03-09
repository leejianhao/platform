<html>
<head>
<title>Welcome!</title>
</head>
<body>
<#import "/include/select.ftl" as my/>


<#list fs as f>
	<@my.xmlselect cid="${f.cid}" id="${f.id}"/>
</#list>
</body>

</html> 