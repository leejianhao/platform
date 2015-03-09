<html>
<head>
<title>Welcome!</title>
</head>
<body>
${doc.fields.field[0].@id}

<#list doc.fields.field[0].data as d>
	${d.key}-->${d.value}
</#list>

<#list doc["fields/field[@id='sex']/data"] as d]
	${d.key}-->${d.value}
</#list>
</body>

</html> 