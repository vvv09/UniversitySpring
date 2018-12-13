<#import "parts/common.ftl" as c>

<@c.page>

<a class="btn btn-primary mb-3" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
   Использовать фильтр
</a>
<div class="collapse" id="collapseExample">
    <form action="/schedule<#if group??>/group/${group.id}</#if><#if teacher??>/teacher/${teacher.id}</#if>" method="get">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">День недели :</label>
            <div class="col-sm-6">
                <select class="form-control" name="dayOfWeek">
                    <option>any</option>
                    <option>MONDAY</option>
                    <option>TUESDAY</option>
                    <option>WEDNESDAY</option>
                    <option>THURSDAY</option>
                    <option>FRIDAY</option>
                    <option>SATURDAY</option>
                </select>   
            </div>
        </div>            
        <div class="form-group row">    
            <label class="col-sm-2 col-form-label">Четность недели :</label>
            <div class="col-sm-6">
                <select class="form-control" name="parity">
                    <option>any</option>
                    <option>ODD</option>
                    <option>EVEN</option>
                </select>  
            </div>
        </div>
        
        <#if group??><input type="hidden" name="groupId" value="${group.id}"></#if>
        <#if teacher??><input type="hidden" name="teacherId" value="${teacher.id}"></#if>
        
        <button class="btn btn-primary my-3" type="submit">Применить фильтр</button>
    
    </form>
</div>

<table class="table table-striped table-bordered table-hover table-sm">
    <thead class="thead-inverse">
        <tr>
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
            <td>${row.dayOfWeek}</td>
            <td>${row.parity}</td>
            <td>${row.lesson}</td>
            <td>${row.subject.name}</td>
            <td>${row.teacher.lastName}</td>
            <td>${row.group.name}</td>
            <td>${row.classroom.name}</td>
            <td><a href="/schedule/edit/${row.id}">Править</a></td>      
        </tr>
    </#list>
    </tbody>   
</table>

</@c.page>
