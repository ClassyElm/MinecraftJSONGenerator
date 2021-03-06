<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<c:set var="title" value="Sign Up" scope="request" />
<c:import url="includes/head.jsp"></c:import>

<body>
<div class="container-fluid px-0">
    <c:import url="includes/header.jsp"></c:import>

    <main class="p-3">
        <h2>Sign Up for an Account</h2>
        <p>* Indicates required field</p>
        <p>Enter your login information below.</p>
        <form action="#" method="post">
            <div class="form-group">
                <label for="email">*Email Address</label>
                <input type="email" id="email" name="email" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="nickname">*Nickname</label>
                <input type="text" id="nickname" name="nickname" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="password">*Password</label>
                <input type="password" id="password" name="password" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="confirmPassword">*Re-Enter Password</label>
                <input type="password" id="confirmPassword" name="confirmPassword" class="form-control" required>
            </div>
            <input type="submit" value="Register" class="btn btn-primary">
            <input type="reset" value="Clear" class="btn btn-primary">
        </form>
    </main>

    <c:import url="includes/footer.jsp"></c:import>
</div>
</body>

<c:import url="includes/scripts.jsp"></c:import>

</html>
