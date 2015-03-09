<html>
<head>
<title>Welcome!</title>
</head>
<body>
<#--自定义指令，第一个参数是指令的名称，第二个是指令的参数
可以为参数添加默认值，有默认值的参数必须放在最后-->
<#macro hello num word default=1>
	<#list 1..num as n>
		hello:${username}-->${n}-->${word}-->${default}
	</#list>
</#macro>
<#--传入参数必须写参数名-->
<@hello num=6 word="w"/>

<#macro test num=3>
	<ul>
	<#list 1..num as n>
	
		<#nested n/>
	</#list>	
	</ul>
</#macro>
	
<@test;n>
	<li>${n}.label li</li>
</@test>

<#macro helloworld>
	<#--当函数执行之后，使用assign所定义的模板变量会被覆盖，这是一个有风险的行为
	所以在函数中没有特殊需求，一般不适用assign来定义变量，而是使用local，用local来定义的变量是局部变量-->
	
	<#--<#assign username="leejianhao2"/>-->
	<#local username="leejianhao2"/>
	macro:${username}
</#macro>
<@helloworld/>
${username}
</body>
</html> 