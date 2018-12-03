<#import "parts/common.ftl" as c>

 <@c.page>
 
 <table>
    <#list teachers as teacher>
        <tr>
            <td>${teacher.lastName}</td>
            <td>${teacher.firstName}</td>
            <td>${teacher.middleName}</td>
            <td><a href="">Править</a></td>
            <td><a href="">Удалить</a></td>
        </tr>
    </#list>
</table>
</@c.page>
