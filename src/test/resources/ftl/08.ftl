<html>
<head>
<title>Welcome!</title>
</head>
<body>
<#import "include/select.ftl" as my/>
<@my.select id="choice" datas=["刘德华","金城武","阿斗"] value="阿斗"/>
<@my.select id="address" datas=["北京","天津","上海"] value="上海"/>

<@my.select id="emp" datas=emps key="id" text="name" value="1" headkey="-1" headtext="请选择"/>

<@my.select id="emp" datas={"0":"男","1":"女"} text="name" value="1" headkey="-1" headtext="请选择性别"/>


</body>

</html> 