<div class="container-fluid bg-dark">
	<nav class="container navbar navbar-expand-lg navbar-light">
		<a class="navbar-brand"
			href="${pageContext.request.contextPath }/PageController"> <img
			src="${pageContext.request.contextPath }/assets/imgs/coder.png"
			class="rounded" width="30" height="30" /> <span
			class="text-white ml-3">My Shop</span>
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a class="nav-link text-white"
					href="#">Home </a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle text-white" href="#"
					id="navbarDropdown" role="button" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"> Dropdown </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="#">Action</a> <a
							class="dropdown-item" href="#">Another action</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#">Something else here</a>
					</div></li>
				<li class="nav-item active"><a class="nav-link text-white"
					href="${pageContext.request.contextPath }/PageController?page=cart_detail"><i class="fa fa-shopping-cart"></i>
					<span class="badge badge-pill badge-danger my_cart">0</span>
					</a></li>
			</ul>
		</div>
	</nav>
</div>