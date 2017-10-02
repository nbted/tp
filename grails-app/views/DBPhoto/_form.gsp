<%@ page import="photo.DBPhoto" %>

<div class="fieldcontain ${hasErrors(bean: DBPhotoInstance, field: 'payload', 'error')} required">
	<label for="payload">
		<g:message code="DBPhoto.payload.label" default="Payload" />
		<span class="required-indicator">*</span>
	</label>
	<input type="file" id="payload" name="payload" />

</div>





