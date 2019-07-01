<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<c:import url="./layouts/header.jsp">
	<c:param name="title">Home Page</c:param>
</c:import>

<sql:query var="rs" dataSource="jdbc/TestDB">
	select * from categories
</sql:query>

<div class="container my-5">
	<div class="row">
		<c:forEach var="row" items="${rs.rows }">
			<div class="col-md-3 mb-3">
				<div class="card">
					<img
						src="${pageContext.request.contextPath}/assets/imgs/${row.image}"
						class="card-img-top" alt="..."
						style="min-height: 180px; max-height: 180px;">
					<div class="card-body">
						<h5 class="card-title">${row.name }</h5>
						<div class="row justify-content-between"></div>
						<a href="/MyShop/PageController?page=single&id=${row.id }"
							class="btn btn-info btn-sm float-right">See More</a>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>

<c:import url="./layouts/footer.jsp"></c:import>

