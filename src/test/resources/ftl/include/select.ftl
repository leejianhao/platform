<#macro select id datas value="" key="" text="" headkey="" headtext="">
	<select id="${id}" name="${id}">
		<#if headtext != "">
			<option value="${headkey}">${headtext}</option>
		</#if>
		<#if datas?is_hash_ex>
			<#--如果是hash，就通过key和value来取值-->
			<#local ks=datas?keys/>
			<#list ks as k>
				<#if value==k>
					<option value="${k}" selected>${datas[k]}</option>
					<#else>
					<option value="${k}">${datas[k]}</option>
				</#if>
			</#list>
			<#else>
				<#list datas as d>
				<#if key !="">
					<#if value==d[key]?string>
						<option value="${d[key]}" selected>${d[text]}</option>
					<#else>
						<option value="${d[key]}">${d[text]}</option>
					</#if>
					
					<#else>
					<#if value==d>
						<option value="${d}" selected>${d}</option>
					<#else>
						<option value="${d}">${d}</option>
					</#if>
				</#if>
					
				</#list>
		</#if>
		
	</select>
</#macro>

<#macro xmlselect cid id>
	<#local tt=fielddoc["fields/field[@id='${cid}']"].@name />
	${tt}:
	<select id="${id}">
		<option value="">${tt}</option>
		<#list fielddoc["fields/field[@id='${cid}']/data"] as d>
			<option value="${d.key}">${d.value}</option>
		</#list>
	</select>
</#macro>










