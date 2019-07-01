<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<c:import url="./layouts/header.jsp">
	<c:param name="title">Home Page</c:param>
</c:import>

<sql:query var="rs" dataSource="jdbc/TestDB">
	select * from products WHERE cat_id=${id }
</sql:query>


<div class="container my-5">
	<div class="row">
		<c:forEach var="row" items="${rs.rows }">
			<div class="col-md-3 mb-3">
				<div class="card">
					<img src="${row.image}" class="card-img-top" alt="..."
						style="min-height: 180px; max-height: 180px;">
					<div class="card-body">
						<div class="row justify-content-between no-gutters">
							<h5 class="card-title">${row.name }</h5>
							<h5 class="card-title">${row.price }</h5>
						</div>
						<p>
							<i class="fa fa-star text-warning"></i> <i
								class="fa fa-star text-warning"></i> <i
								class="fa fa-star text-warning"></i> <i
								class="fa fa-star text-warning"></i> <i
								class="fa fa-star-half text-warning"></i>
						</p>
						<p>${row.description.substring(0,row.description.length() > 100 ? 100: row.description.length()) }</p>
						<div class="row justify-content-between">
							<a href="" class="btn btn-info btn-sm"><i class="fa fa-eye"></i></a>
							<button class="btn btn-success btn-sm"
								onclick="addToCart(${row.id})">
								<i class="fa fa-shopping-cart"></i>
							</button>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>


<c:import url="./layouts/footer.jsp"></c:import>



