<#import "parts/common.ftl" as c> 

<@c.page> 
Правка Преподавателя

<form action="/teachers" method="post">
	<div class="form-group row">
		<label class="col-sm-2 col-form-label">Фамилия :</label>
		<div class="col-sm-6">
			<input type="text" name="lastName" class="form-control" value="${teacher.lastName}" />
		</div>
	</div>
	<div class="form-group row">
		<label class="col-sm-2 col-form-label">Имя :</label>
		<div class="col-sm-6">
			<input type="text" name="firstName" class="form-control" value="${teacher.firstName}" />
		</div>
	</div>
	<div class="form-group row">
		<label class="col-sm-2 col-form-label">Отчество :</label>
		<div class="col-sm-6">
			<input type="text" name="middleName" class="form-control" value="${teacher.middleName}" />
		</div>
		<input type="hidden" name="id" value="${teacher.id}" >
	</div>
	<button class="btn btn-primary" type="submit">Сохранить изменения</button>
</form>
</@c.page>
 