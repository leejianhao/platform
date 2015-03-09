<html>
<head>
<title>Welcome!</title>
</head>
<body>
${test?html}
<#assign nums=[1,2,3,4,5,6,7,8]/>
<#assign nums=1..100/>
<#list nums[0..9] as num>
	${num}
</#list>
${"学好freemarker!!!"[0..3]}...
<#assign user={"1":"老张","2":"校长"}/>
<#--map支持string的类型作为key-->
${user["1"]}
<#--map的遍历-->
<#assign keys=user?keys/>
<#list keys as key>
	${key}---${user["${key}"]}
</#list>

</body>
</html> 