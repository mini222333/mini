<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    <c:import var="data"
    url="http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=108">
    </c:import>
    
    ${data}