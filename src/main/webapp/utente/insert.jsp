<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!doctype html>
<html lang="it" class="h-100">
<head>

<!-- Common imports in pages -->
<jsp:include page="../header.jsp" />

<title>Aggiungi Utente</title>
</head>
<body class="d-flex flex-column h-100">

	<!-- Fixed navbar -->
	<jsp:include page="../navbar.jsp"></jsp:include>


	<!-- Begin page content -->
	<main class="flex-shrink-0">
		<div class="container">

			<div
				class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none':'' }"
				role="alert">
				${errorMessage}
				<button type="button" class="btn-close" data-bs-dismiss="alert"
					aria-label="Close"></button>
			</div>

			<div class="alert alert-warning alert-dismissible fade show d-none"
				role="alert">
				Attenzione!!! Funzionalità ancora non implementata. Sulla 'Conferma'
				per il momento parte il 'listAll'
				<button type="button" class="btn-close" data-bs-dismiss="alert"
					aria-label="Close"></button>
			</div>

			<div class='card'>
				<div class='card-header'>
					<h5>Aggiungi utente</h5>
				</div>
				<div class='card-body'>
					<h6 class="card-title">I campi con <span class="text-danger">*</span> sono obbligatori</h6>
					<form method="post" action="${pageContext.request.contextPath}/utente/ExecuteInsertUtenteServlet"
						class="row g-3">


						<div class="col-md-6">
							<label for="username" class="form-label">Username</label> <input
								type="text" name="username" id="username" class="form-control"
								placeholder="Inserire username" value="${insert_utente_attr.username }" >
						</div>
						
						<div class="col-md-6">
							<label for="dataCreazione" class="form-label">Password
								</label> <input class="form-control" id="password"
								type="password" placeholder="Inserire la password" name="password" >
						</div>

						<div class="col-md-6">
							<label for="nome" class="form-label">Nome</label> <input
								type="text" name="nome" id="nome" class="form-control"
								placeholder="Inserire il nome" value="${insert_utente_attr.nome }" >
						</div>
						
						<div class="col-md-6">
							<label for="cognome" class="form-label">Cognome</label> <input
								type="text" name="cognome" id="cognome" class="form-control"
								placeholder="Inserire il cognome" value="${insert_utente_attr.cognome }" >
						</div>
						
						<c:forEach items="${ruoli_list_attribute}" var="ruoloEntry">
							<div class="form-check">
								<input class="form-check-input" name="ruoloInput" type="checkbox" value="${ruoloEntry.key.id}" id="ruoloInput-${ruoloEntry.key.id}" ${ruoloEntry.value?'checked':'' }>
								<label class="form-check-label" for="ruoloInput-${ruoloEntry.key.id}" >
									${ruoloEntry.key.codice}
								</label>
							</div>
						</c:forEach>
						
						<div class="col-12">
							<button type="submit" name="submit" value="submit" id="submit"
								class="btn btn-primary">Conferma</button>
							<a class="btn btn-outline-primary ml-2 d-none"
								href="PrepareInsertFilmServlet">Add New</a> <input
								class="btn btn-outline-warning" type="reset" value="Ripulisci">
						</div>

					</form>



					<!-- end card-body -->
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