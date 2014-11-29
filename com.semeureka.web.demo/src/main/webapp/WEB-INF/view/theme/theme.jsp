<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tt"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="sh"%>
<tt:frame>
	<h1 class="page-header">Theme...</h1>
	<form>
		<div class="form-group">
			<label>Username</label><select id="theme" class="form-control">
				<option value="">.DEFAULT</option>
				<option value=".cerulean">.CERULEAN</option>
				<option value=".cosmo">.COSMO</option>
				<option value=".cyborg">.CYBORG</option>
				<option value=".darkly">.DARKLY</option>
				<option value=".flatly">.FLATLY</option>
				<option value=".journal">.JOURNAL</option>
				<option value=".lumen">.LUMEN</option>
				<option value=".paper">.PAPER</option>
				<option value=".readable">.READABLE</option>
				<option value=".sandstone">.SANDSTONE</option>
				<option value=".simplex">.SIMPLEX</option>
				<option value=".slate">.SLATE</option>
				<option value=".spacelab">.SPACELAB</option>
				<option value=".superhero">.SUPERHERO</option>
				<option value=".united">.UNITED</option>
				<option value=".yeti">.YETI</option>
			</select>
		</div>
		<script type="text/javascript">
			$('#theme').change(function() {
				document.cookie = 'theme=' + $('#theme').val();
				location.reload(true);
			});
		</script>
	</form>
</tt:frame>