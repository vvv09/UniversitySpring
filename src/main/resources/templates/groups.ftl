<#import "parts/common.ftl" as c>

 <@c.page>
 
 <table class="table table-striped table-bordered table-hover">
    <#list groups as group>
        <tr>
            <td>${group.name}</td>
            <td><a href="/groups/edit/${group.id}">Править</a></td>
            <td><a href="/groups/delete/${group.id}">Удалить</a></td>
        </tr>
    </#list>
</table>

<a class="btn btn-primary mt-5" href="/groups/new">Новая группа</a>

</@c.page>
