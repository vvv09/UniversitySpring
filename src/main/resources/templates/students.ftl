<#import "parts/common.ftl" as c>

 <@c.page>
 
 <table>
    <#list students as student>
        <tr>
            <td>${student.lastName}</td>
            <td>${student.firstName}</td>
            <td>${student.middleName}</td>
            <td><a href="">Править</a></td>
            <td><a href="">Удалить</a></td>
        </tr>
    </#list>
</table>
</@c.page>
