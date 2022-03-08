<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="it" class="h-100" >
	 <head>

	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	 	
	   <title>Elimina Regista</title>
	   
	 </head>
	   <body class="d-flex flex-column h-100">
	   
	   		<!-- Fixed navbar -->
	   		<jsp:include page="../navbar.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">
			  		<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none':'' }" role="alert">
					  ${errorMessage}
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
				  
			  		<div class='card'>
					    <div class='card-header'>
					        <h5>Elimina regista</h5>
					    </div>
					    
					
					    <div class='card-body'>
					    	<dl class="row">
								<dt class="col-sm-3 text-right">Nome:</dt>
								 <dd class="col-sm-9">${delete_regista_attr.nome}</dd>
							</dl>
							<dl class="row">
								<dt class="col-sm-3 text-right">Cognome:</dt>
								<dd class="col-sm-9">${delete_regista_attr.cognome}</dd>
							</dl>
							<dl class="row">
								<dt class="col-sm-3 text-right">Nickname:</dt>
								<dd class="col-sm-9">${delete_regista_attr.nickName}</dd>
							</dl>
							<dl class="row">
								<dt class="col-sm-3 text-right">Sesso:</dt>
								<dd class="col-sm-9">${delete_regista_attr.sesso}</dd>
							</dl>
					    	
					    	<!-- info Regista -->
					    	
					    	
					    <!-- end card body -->
					    </div>
					    
					    <div class='card-footer'>
					        <form method="post" action="ExecuteDeleteRegistaServlet">
					    		<input type="hidden" name="idRegista" value="${delete_regista_attr.id}">
						    	<button type="submit"  value="Conferma" class="btn btn-primary">Conferma</button>
					        </form>
					    </div>
					<!-- end card -->
					</div>	
			  
			    
			  <!-- end container -->  
			  </div>
			  
			</main>
			
			<!-- Footer -->
			<jsp:include page="../footer.jsp" />
	  </body>
</html>