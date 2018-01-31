<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>companyList</h1>
	<div class="container">
		 <div class="method">
	        <div class="row margin-0 list-header hidden-sm hidden-xs">
	            <div class="col-md-3"><div class="header">Id</div></div>
	            <div class="col-md-5"><div class="header">Companyname</div></div>
	        </div>
	      </div> 
	       <div class="row margin-0">
            <div class="col-md-3">
                <div class="cell">
                    <div class="propertyname">
                        CurrencyCode  <span class="mobile-isrequired">[Required]</span>
                    </div>
                </div>
            </div>
            <div class="col-md-5">
                <div class="cell">
                    <div class="type">
                        <code>String</code>
                    </div>
                </div>
            </div>
        </div>
	</div>
	
		<table border="1">
			<c:forEach var="company" items="${list}">
			<thead>
				<tr>
				<td>아이디</td>
				<td>${company.companyId}</td>
				</tr>
			</thead>
			<tbody>
				<tr>
				<td>회사명</td>
				<td>${company.companyName}</td>
				</tr>
			</tbody>
			</c:forEach>
		</table>

</body>
</html>