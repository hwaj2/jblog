<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container mt-3">
    <form>
        <div class="mb-3">
            <label for="title">제목 : </label>
            <input type="text" class="form-control" id="title" placeholder="Enter title">
        </div>
        <div class="mb-3">
            <label for="content">내용 :</label>
            <textarea class="form-control" rows="5" id="content"></textarea>
        </div>
    </form>

    <button id="btn-insert" class="btn btn-secondary">포스트 등록</button>
</div>

<script>
    $(document).ready(function () {
        $("#content").summernote({
            height: 300
        });
    });
</script>

<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>
