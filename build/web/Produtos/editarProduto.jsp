<%@ page import="br.com.login.model.Produto"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>

<%
	Produto produto = (Produto) request.getAttribute("produto");
%>

<div class="panel panel-default">
	<!-- Default panel contents -->
	<div class="panel-heading">Editar Produto</div>

	<form id="editarProdutoFormulario">

		<input type="hidden" name="id" value="<%=produto.getId()%>" /> <input
			
		<div class="form-group">
			<label class="control-label required">Nome <abbr
				title="required">*</abbr>
			</label> <input type="text" class="form-control" name="nome"
				value="<%=produto.getNome()%>" required />
		</div>

		<div class="form-group">
			<label class="control-label required">Preço <abbr
				title="required">*</abbr>
			</label> <input type="text" class="form-control" name="preco"
				value="<%=produto.getPreco()%>" required />
		</div>

		<div class="form-group">
			<label class="control-label required">Observações <abbr
				title="required">*</abbr>
			</label> <input type="text" class="form-control" name="observacao"
				value="<%=produto.getObservacao()%>" required />
		</div>

		<button class="btn btn-primary" type="button"
			onclick="onSalvarProduto()">Salvar</button>
		<button class="btn btn-primary" type="button"
			onclick="onVoltarProduto()">Voltar</button>

	</form>
</div>
<script type="text/javascript">
	<jsp:include page="/Produtos/EditarProduto.js" />
</script>