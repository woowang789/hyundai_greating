<%@page import="vo.UserVO"%>
<%@page import="vo.OrderProductVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/WEB-INF/component/style.jsp"%>
<link rel="stylesheet" href="/css/order_list.css" />
<script src="/js/order_list.js" defer></script>
<title>OrderList</title>
</head>
<body>

	<div class="modal__background"></div>

	<!-- HEADER Fragnent -->
	<jsp:include page="../component/header.jsp"></jsp:include>
	
	<%
	String userId = "";
	UserVO user = (UserVO) session.getAttribute("user");
	if (user != null)
		userId = user.getId();
	%>

	<script>
    	let userId = "<%=userId%>"
	</script>

	<!-- review input -->
	<div class="review__input">
		<div class="dialog__content">
			<p class="reivew__optn">
				옵션 : <span>{optn}</span>
			</p>
			<input type='text' placeholder="Title" />
			<textarea placeholder="Content"></textarea>
		</div>
		<div class="dialog__btns">
			<div class="review__cancel">취소</div>
			<div class="review__com">작성완료</div>
		</div>
	</div>

	<!-- Main -->
	<main>
		<div class="main__left">
			<h1>마이페이지</h1>
			<div class="left__content">
				<ul class="shopping__log">
					<h3>나의 쇼핑내역</h3>
					<li><a href="/v1/orderList">주문/배송 조회</a></li>
				</ul>
				<ul class="interest_log">
					<h3>나의 관심내역</h3>
					<li><a href="/v1/viewProductList">최근 본 상품</a></li>
					<li><a href="/v1/likeProductList">관심상품</a></li>
				</ul>
				<ul class="post_log">
					<h3>나의 커뮤니티</h3>
					<li><a href="">나의 상품후기</a></li>
					<li><a href="">나의 상품문의</a></li>
				</ul>
				<ul class="post_log">
					<h3>회원정보</h3>
					<li><a href="">회원정보 수정</a></li>
					<li><a href="">로그인 기록 관리</a></li>
					<li><a href="">회원 탈퇴</a></li>
				</ul>
			</div>
		</div>
		<div class="main__center">
			<div class="center__header">
				<span>${sessionScope.user.name}</span>님 반갑습니다.
			</div>
			<div class="center__body">
				<h1>주문내역</h1>
				<div class="body__option">
					<div class="option__status input__flex">
						<div class="head">주문상태</div>
						<div class="tail">
							<select name="" id="">
								<option value="">주문상태 전체</option>
								<option value="">배송준비</option>
								<option value="">배송완료</option>
							</select>
						</div>
					</div>
					<div class="option__name input__flex">
						<div class="head">상품명</div>
						<div class="tail">
							<input type="text" />
						</div>
					</div>
					<div class="option__reset">
						<i class="fa-solid fa-arrow-rotate-left"></i>초기화
					</div>
					<div class="search__btn">조회</div>
				</div>
			</div>
			<c:forEach var="entry" items="${orders}">
				<ul class="order__list">
					<li class="order__item">
						<div class="order__head">
							<div class="head__left">
								주문일 : <span val="${entry.key}">${entry.key}</span> <a href=""><span>상세보기 ></span></a>
							</div>
						</div>
						<ul class="item__list">
							<c:forEach var="el" items="${entry.value}">
								<li class="item" prodId="${el.prodId}" optnId="${el.optnId}" >
									<div class="info">
										<div class="item__img">
											<img src="${el.thumbImgUrl}" alt="" />
										</div>
										<div class="item__info">
											<p class="order__status">배송준비</p>
											<h3>${el.prodName}</h3>
											<p class="desc">${el.optName}</p>
											<p class="price">${el.marketPrice}원/${el.qty}개</p>
										</div>
									</div>
									<c:if test="${not empty el.comment}">
									 <div class='input__btn has_reivew'>리뷰확인</div>
									</c:if>
									<c:if test="${empty el.comment}">
									 <div class='input__btn open_form'>리뷰작성</div>
									</c:if>
								</li>
							</c:forEach>
						</ul>
					</li>
				</ul>
			</c:forEach>

			<!-- 
			<ul class="order__list">
				<li class="order__item">
					<div class="order__head">
						<div class="head__left">
							주문일 : 2022-11-17 <a href=""><span>상세보기 ></span></a>
						</div>
					</div>
					<ul class="item__list">
						<li class="item">
							<div class="item__img">
								<img src="../img/order_list/item__img.jpeg" alt="" />
							</div>
							<div class="item__info">
								<p class="order__status">배송준비</p>
								<h3>베지미트볼 파스타소스</h3>
								<p class="desc">베이지트볼 파스타소스 250g</p>
								<p class="price">5,500원 / 1개</p>
							</div>
						</li>
						<li class="item">
							<div class="item__img">
								<img src="../img/order_list/item__img.jpeg" alt="" />
							</div>
							<div class="item__info">
								<p class="order__status">배송준비</p>
								<h3>베지미트볼 파스타소스</h3>
								<p class="desc">베이지트볼 파스타소스 250g</p>
								<p class="price">5,500원 / 1개</p>
							</div>
						</li>
					</ul>
				</li>
			</ul>
			
 -->

		</div>
	</main>
	<!-- Footer Fragnent -->
	<%@include file="/WEB-INF/component/footer.jsp"%>
</body>
</html>