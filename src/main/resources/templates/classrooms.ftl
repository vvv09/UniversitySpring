<#import "parts/common.ftl" as c>

 <@c.page>
 
 <table>
    <#list classrooms as classroom>
        <tr>
            <td>${classroom.name}</td>
            <td><a href="">Править</a></td>
            <td><a href="">Удалить</a></td>
        </tr>
    </#list>
</table>
</@c.page>
