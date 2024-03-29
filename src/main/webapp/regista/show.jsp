<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="it" class="h-100" >
	 <head>

	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	 	
	   <title>Visualizza Regista</title>
	   
	 </head>
	   <body class="d-flex flex-column h-100">
	   
	   		<!-- Fixed navbar -->
	   		<jsp:include page="../navbar.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">
			  
			  		<div class='card'>
					    <div class='card-header'>
					        <h5>Visualizza regista</h5>
					    </div>
					    
					
					    <div class='card-body'>
					    	<dl class="row">
								<dt class="col-sm-3 text-right">Nome:</dt>
								 <dd class="col-sm-9">${show_regista_attr.nome}</dd>
							</dl>
							<dl class="row">
								<dt class="col-sm-3 text-right">Cognome:</dt>
								<dd class="col-sm-9">${show_regista_attr.cognome}</dd>
							</dl>
							<dl class="row">
								<dt class="col-sm-3 text-right">Nickname:</dt>
								<dd class="col-sm-9">${show_regista_attr.nickName}</dd>
							</dl>
							<dl class="row">
								<dt class="col-sm-3 text-right">Sesso:</dt>
								<dd class="col-sm-9">${show_regista_attr.sesso}</dd>
							</dl>
					    	
					    	<!-- info Regista -->
					    	
					    	
					    <!-- end card body -->
					    </div>
					    
					    <div class='card-footer'>
					        <a href="ExecuteListRegistaServlet" class='btn btn-outline-secondary' style='width:80px'>
					            <i class='fa fa-chevron-left'></i> Back
					        </a>
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