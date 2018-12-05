<#import "parts/common.ftl" as c>
<@c.page>
Правка Аудитории
<form action="/classrooms" method="post">
	<div class="form-group row">
		<label class="col-sm-2 col-form-label">Название :</label>
		<div class="col-sm-6">
			<input type="text" name="name" class="form-control" value="${classroom.name}">
		</div>
		<input type="hidden" name="id" value="${classroom.id}">
	</div>
	<button class="btn btn-primary" type="submit">Сохранить изменения</button>
</form>
</@c.page>
