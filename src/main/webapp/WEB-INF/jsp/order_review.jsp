<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <%@include file="/WEB-INF/component/style.jsp" %>
    <script src="/js/item_detail.js" defer></script>
    <link rel="stylesheet" href="/css/item_detail.css" />
    <title>OrderReview</title>
  </head>
<body>  
	<!-- HEADER Fragment -->
    <jsp:include page="../component/header.jsp"></jsp:include>
    
    <!-- 상품후기 -->
    <div class="tab-content cont-review" id="cont-review">
                        <div class="review__keyword" id="reviewKywrdArea" style="display:none;">
                            <div class="review__keyword__title">
                                상품 후기로 본 <strong class="point">‘추천 키워드’</strong> <i class="ico_tooltip btn__modal-open" data-login="n" data-popup-name="popup_keyword"></i>
                            </div>

                            <div class="review__keyword__box" id="reviewKywrd">
                            </div>
                        </div> 
                        <div class="head">
                            <span class="all">
								전체 <span class="all__num">(<span id="reviewCnt2">0</span>)</span>
                            </span>
                            <em>&#8251 일부 효능/효과 관련 후기는 구매자의 주관적인 소견이며 개인별로 상이할 수 있습니다.</em>
                        </div>
                        
                        <script type="text/x-handlebars-template" id='dvGoodsFbListMainTemplate'>
							{{#if total}}
							<ul class="box" id="dvGoodsFbListMainArea">
								<!-- dvGoodsFbListTemplate -->
							</ul>

							{{else}}
							<div class="no-list">
								<p>등록된 상품후기가 없습니다.</p>
							</div>
							{{/if}}
                        </script>

                        <!-- 상품 후기 페이징 처리 -->
                        <div class="pagenation" id="pageNation"></div>
                        <script type="text/x-handlebars-template" id='dvGoodsFbListTemplate'>
                        	<li class="box__list accordion">
                                <div class="box__list__head accordion__head accordion__head--on">
                                    <strong class="box__list__title">
										{{#HELPER_BEST_YN}}
                                        	<span class="box__list__best">MD 리뷰</span>
										{{/HELPER_BEST_YN}}
										{{TITLE}}
										{{#if FB_IMG_CNT}}
                                        	<span class="box__list__photo"></span>
										{{/if}}
                                    </strong>

                                    <div class="writer-info">
                                        <span class="writer-info__id">{{LOGIN_ID}}</span> | 
										<span class="writer-info__date">{{CREATED}}</span><span class="writer-info__time">{{CREATED_TIME}}</span>
                                    </div>
                                </div>

                                <div class="accordion__cont accordion__cont--show" style="display: block;">
                                    <div class="box__list__detail">
                                        <strong class="box__list__title">
                                            {{TITLE}}
											<!--
                                            <span class="box__list__photo"></span>
											-->
                                        </strong>

                                        <div class="writer-info">
                                            <span class="writer-info__id">{{LOGIN_ID}}</span> | 
											<span class="writer-info__date">{{CREATED}}</span><span class="writer-info__time">{{CREATED_TIME}}</span>
                                        </div>

                                        <div class="item">
											{{#if ITEM_OPTN_NAME}}
                                            	<span class="item__option">옵션 : {{ITEM_OPTN_NAME}}</span>
											{{/if}}
                                            
                                            <div class="item__cont">{{{COMMENT}}}</div>

											{{#if FB_IMG_CNT}}
	                                            <div class="item__img">
													<a href="#" class="btn__modal-open" data-login="n" data-popup-name="popup_reviewImg">
														<figure>
														{{#each FB_IMG_FILES}}
    	                                            	<img src="{{REAL_ATTACHED}}" alt="" {{#ifCond @index '>' '0'}}style="display:none;"{{/ifCond}}>
														{{/each}}
														</figure>
														<span class="item__img-number">+{{FB_IMG_TOTAL}}</span>
													</a>
        	                                    </div>
											{{/if}}

											<div class="item__helpful">
                                                <strong class="point_color" id="helpCntS{{FB_FEEDBACK_ID}}">{{{HELP_CNT}}}명</strong>에게 도움 됐어요!
												<a href="javascript:addReviewHelp('{{FB_FEEDBACK_ID}}');" id="helpCntC{{FB_FEEDBACK_ID}}" class="item__helpful-ico{{#ifCond HELP_YN '==' 'Y'}} on{{/ifCond}}">{{{HELP_CNT}}}</a>
                                            </div>
                                        </div>
                                    </div>
									{{#if REPLY_COMMENT}}
                                    <div class="box__list__review">
                                        <div class="boxInner">
											{{REPLY_COMMENT}}                                            
                                            <div class="writer-info">
                                                <span class="writer-info__id">담당자</span> | <span class="writer-info__date">{{REPLY_DT}}</span><span class="writer-info__time">{{REPLY_TIME}}</span>
                                            </div>
                                        </div>
                                    </div>
									{{/if}}
                                </div>
                            </li>
						</script>
                    </div>
                    <!-- //상품후기 -->

    <!-- Footer Fragment -->
    <%@include file="/WEB-INF/component/footer.jsp" %>
</body>
</html>

