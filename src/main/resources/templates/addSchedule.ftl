<#import "parts/common.ftl" as c> 

<@c.page> 
Новая Строка Расписания

<form action="saveNew" method="post">
<div class="form-group row">
        <label class="col-sm-2 col-form-label">День недели :</label>
        <div class="col-sm-6">
            <select class="form-control" name="dayOfWeek">
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
        <label class="col-sm-2 col-form-label">Четность :</label>
        <div class="col-sm-6">
            <select class="form-control" name="parity">
                <option>ODD</option>
                <option>EVEN</option>
            </select>  
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Лекция № :</label>
        <div class="col-sm-6">
            <select class="form-control" name="lesson">
                <option>FIRST</option>
                <option>SECOND</option>
                <option>THIRD</option>
                <option>FOURTH</option>
                <option>FIFTH</option>
                <option>SIXTH</option>
            </select>
        </div>
    </div>
    
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Предмет :</label>
        <div class="col-sm-6">
            <select class="form-control" name="subjectId">
                <#list subjects as subject>
                    <option value="${subject.id}">${subject.name}</option>
                </#list>
            </select>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Преподаватель :</label>
        <div class="col-sm-6">
            <select class="form-control" name="teacherId">
                <#list teachers as teacher>
                    <option value="${teacher.id}">${teacher.lastName} ${teacher.firstName} ${teacher.middleName}</option>
                </#list>
            </select>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Группа :</label>
        <div class="col-sm-6">
            <select class="form-control" name="groupId">
                <#list groups as group>
                    <option value="${group.id}">${group.name}</option>
                </#list>
            </select>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Аудитория :</label>
        <div class="col-sm-6">
            <select class="form-control" name="classroomId">
                <#list classrooms as classroom>
                    <option value="${classroom.id}">${classroom.name}</option>
                </#list>
            </select>
        </div>
    </div>
    
    <button class="btn btn-primary" type="submit">Создать</button>
</form>
</@c.page>
