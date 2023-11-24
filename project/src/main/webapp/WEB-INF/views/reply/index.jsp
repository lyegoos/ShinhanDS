<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head> 
    <meta charset="utf-8">
    <title></title>
    <META name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, user-scalable=no"> 
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.css" />
    <link rel="stylesheet" href="/project/css/reset.css"/>
    <link rel="stylesheet" href="/project/css/style.css"/>
    <script src="/project/js/script.js"></script>
</head> 
<body>
    </div>
    <div class="wrap">
        <%@ include file = "/WEB-INF/views/common/header.jsp" %>
        <div class="sub">
            <div class="size">
                <h3 class="sub_title">게시판</h3>
    
                <div class="bbs">
                    <table class="list">
                    <p><span><strong>총 100개</strong>  |  1/10페이지</span></p>
                        <caption>게시판 목록</caption>
                        <colgroup>
                            <col width="80px" />
                            <col width="*" />
                            <col width="100px" />
                            <col width="100px" />
                        </colgroup>
                        <thead>
                            <tr>
                                <th>번호</th>
                                <th>제목</th>
                                <th>작성자</th>
                                <th>작성일</th>
                            </tr>
                        </thead>
                        <tbody>

                            <tr>
                                <td class="first" colspan="8">등록된 글이 없습니다.</td>
                            </tr>

                                    
                            <tr>
                                <td>10</td>
                                <td class="txt_l">
                                    <a href="board_view.html">게시글 제목</a>
                                </td>
                                <td class="writer">
                                    홍길동
                                </td>
                                <td class="date">2021-01-01</td>
                            </tr>
                            <tr>
                                <td>9</td>
                                <td class="txt_l">
                                    <a href="board_view.html">게시글 제목</a>
                                </td>
                                <td class="writer">
                                    홍길동
                                </td>
                                <td class="date">2021-01-01</td>
                            </tr>
                            <tr>
                                <td>8</td>
                                <td class="txt_l">
                                    <a href="board_view.html">게시글 제목</a>
                                </td>
                                <td class="writer">
                                    홍길동
                                </td>
                                <td class="date">2021-01-01</td>
                            </tr>
                        </tbody>
                    </table>
                    <div class="btnSet"  style="text-align:right;">
                        <a class="btn" href="board_write.html">글작성 </a>
                    </div>
                    <div class="pagenate clear">
                        <ul class='paging'>
                            <li><a href='javascript:;' class='current'>1</a></li>
                            <li><a href='javascript:;'>2</a></li>
                            <li><a href='javascript:;'>3</a></li>
                        </ul> 
                    </div>
                
                    <!-- 페이지처리 -->
                    <div class="bbsSearch">
                        <form method="get" name="searchForm" id="searchForm" action="">
                            <span class="srchSelect">
                                <select id="stype" name="stype" class="dSelect" title="검색분류 선택">
                                    <option value="all">전체</option>
                                    <option value="title">제목</option>
                                    <option value="contents">내용</option>
                                </select>
                            </span>
                            <span class="searchWord">
                                <input type="text" id="sval" name="sval" value=""  title="검색어 입력">
                                <input type="button" id="" value="검색" title="검색">
                            </span>
                        </form>
                        
                    </div>
                </div>
            </div>
        </div>
        <%@ include file="/WEB-INF/views/common/footer.jsp" %>
    </div>
</body> 
</html>