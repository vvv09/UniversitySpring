<#import "parts/common.ftl" as c> 

<@c.page> 
Правка Расписания

<form action="/schedule" method="post">
<div class="form-group row">
        <label class="col-sm-2 col-form-label">День недели :</label>
        <div class="col-sm-6">
            <select class="form-control" name="dayOfWeek">
                <option <#if sceduleRow.parity == "MONDAY"> selected = "selected"</#if>>MONDAY</option>
                <option <#if sceduleRow.parity == "TUESDAY"> selected = "selected"</#if>>TUESDAY</option>
                <option <#if sceduleRow.parity == "WEDNESDAY"> selected = "selected"</#if>>WEDNESDAY</option>
                <option <#if sceduleRow.parity == "THURSDAY"> selected = "selected"</#if>>THURSDAY</option>
                <option <#if sceduleRow.parity == "FRIDAY"> selected = "selected"</#if>>FRIDAY</option>
                <option <#if sceduleRow.parity == "SATURDAY"> selected = "selected"</#if>>SATURDAY</option>
            </select>   
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Четность :</label>
        <div class="col-sm-6">
            <select class="form-control" name="parity">
                <option <#if sceduleRow.parity == "ODD"> selected = "selected"</#if>>ODD</option>
                <option <#if sceduleRow.parity == "EVEN"> selected = "selected"</#if>>EVEN</option>
            </select>  
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Лекция № :</label>
        <div class="col-sm-6">
            <select class="form-control" name="lesson">
                <option <#if sceduleRow.lesson == "FIRST"> selected = "selected"</#if>>FIRST</option>
                <option <#if sceduleRow.lesson == "SECOND"> selected = "selected"</#if>>SECOND</option>
                <option <#if sceduleRow.lesson == "THIRD"> selected = "selected"</#if>>THIRD</option>
                <option <#if sceduleRow.lesson == "FOURTH"> selected = "selected"</#if>>FOURTH</option>
                <option <#if sceduleRow.lesson == "FIFTH"> selected = "selected"</#if>>FIFTH</option>
                <option <#if sceduleRow.lesson == "SIXTH"> selected = "selected"</#if>>SIXTH</option>
            </select>
        </div>
    </div>
    
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Предмет :</label>
        <div class="col-sm-6">
            <select class="form-control" name="subjectId">
                <#list subjects as subject>
                    <option value="${subject.id}" <#if subject.id == sceduleRow.subject.id> selected = "selected"</#if>>${subject.name}</option>
                </#list>
            </select>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Преподаватель :</label>
        <div class="col-sm-6">
            <select class="form-control" name="teacherId">
                <#list teachers as teacher>
                    <option value="${teacher.id}" <#if teacher.id == sceduleRow.teacher.id> selected = "selected"</#if>>${teacher.lastName} ${teacher.firstName} ${teacher.middleName}</option>
                </#list>
            </select>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Группа :</label>
        <div class="col-sm-6">
            <select class="form-control" name="groupId">
                <#list groups as group>
                    <option value="${group.id}" <#if group.id == sceduleRow.group.id> selected = "selected"</#if>>${group.name}</option>
                </#list>
            </select>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Аудитория :</label>
        <div class="col-sm-6">
            <select class="form-control" name="classroomId">
                <#list classrooms as classroom>
                    <option value="${classroom.id}" <#if classroom.id == sceduleRow.classroom.id> selected = "selected"</#if>>${classroom.name}</option>
                </#list>
            </select>
        </div>
    </div>
    
    <input type="hidden" name="id" value="${sceduleRow.id}" >
    
    <button class="btn btn-primary" type="submit">Сохранить изменения</button>
</form>
</@c.page>
