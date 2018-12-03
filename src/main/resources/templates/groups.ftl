<#import "parts/common.ftl" as c>

 <@c.page>
 
 <table>
    <#list groups as group>
        <tr>
            <td>${group.name}</td>
            <td><a href="">Править</a></td>
            <td><a href="">Удалить</a></td>
        </tr>
    </#list>
</table>
</@c.page>