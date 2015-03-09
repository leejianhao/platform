<html>
<head>
<title>Welcome!</title>
</head>
<body>
<#import "/include/select.ftl" as my/>


<#list filterdoc["filters/filter[@id='student']/field"] as f>
	
	<@my.xmlselect cid="${f.@cid}" id="${f.@id}"/>
</#list>
</body>

</html> 