<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="template"%>
<template:frame>
	<blockquote>
		<p>${requestScope['javax.servlet.error.status_code']} <kbd>+</kbd></p>
		<p>${requestScope['javax.servlet.error.message']} <kbd>+</kbd></p>
		<p>${requestScope['javax.servlet.error.exception']} <kbd>+</kbd></p>
	</blockquote>
</template:frame>