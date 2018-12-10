<#import "parts/common.ftl" as c>

<@c.page>
 
<table class="table table-striped table-bordered table-hover table-sm">
    <thead class="thead-inverse">
        <tr>
            <th>#</th>
            <th>День недели</th>
            <th>Четность</th>
            <th>Лекция</th>
            <th>Предмет</th>
            <th>Фамилия преподавателя</th>
            <th>Группа</th>
            <th>Аудитория</th>
        </tr>
    </thead>
    <tbody>
    <#list schedule as row>
        <tr>        
            <td>${row.id}</td>
            <td>${row.dayOfWeek}</td>
            <td>${row.parity}</td>
            <td>${row.lesson}</td>
            <td>${row.subject.name}</td>
            <td>${row.teacher.lastName}</td>
            <td>${row.group.name}</td>
            <td>${row.classroom.name}</td>
            <td><a href="">Править</a></td>      
        </tr>
    </#list>
    </tbody>   
</table>

</@c.page>
