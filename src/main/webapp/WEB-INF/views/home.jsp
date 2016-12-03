<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Programming Assessment</title>

    <link rel="stylesheet" href="resources/css/main.css">
    <!-- Bootstrap -->
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet"
        href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
        integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
        crossorigin="anonymous">
</head>
<body>
    <div class="header">
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <h1>Programming Assessment</h1>
                    <p>The purpose of this page is to find the intersection of two arrays filled with random integers.</p>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-4">
            <h2>Configuration</h2>
            <sf:form method="POST" modelAttribute="seekerConfig" cssClass="form-horizontal">
                <div class="row">
                    <div class="form-group">
                        <label class="control-label col-sm-6" for="arrayASize">Enter the array "A" size</label>
                        <div class="col-sm-6">
                            <sf:input path="arrayASize" cssClass="form-control" cssStyle="width: 100px;" />
                            <sf:errors path="arrayASize" cssClass="error" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-6" for="arrayBSize">Enter the array "B" size</label>
                        <div class="col-sm-6">
                            <sf:input path="arrayBSize" cssClass="form-control" cssStyle="width: 100px;" />
                            <sf:errors path="arrayBSize" cssClass="error" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="radio control-label col-sm-6" for="arrayAIntoHashSet">Array "A" in the HashSet<br /> Array "B" would be iterated over</label>
                        <div class="col-sm-6">
                            <sf:radiobutton id="arrayAIntoHashSet" path="arrayAIntoHashSet" value="true" cssStyle="margin-top: 20px;" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="radio control-label col-sm-6" for="arrayBIntoHashSet">Array "B" in the HashSet<br /> Array "A" would be iterated over</label>
                        <div class="col-sm-6">
                            <sf:radiobutton id="arrayBIntoHashSet" path="arrayAIntoHashSet" value="false" cssStyle="margin-top: 20px;" />
                            <sf:errors path="arrayAIntoHashSet" cssClass="error" />
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-6 col-sm-6">
                            <button class="btn btn-primary" type="submit"><span class="glyphicon glyphicon-play" aria-hidden="true"></span> Run</button>
                        </div>
                    </div>
                </div>
            </sf:form>
            </div>
            <c:if test="${not empty seekerData}">
                <div class="col-md-8">
                    <h2>Result</h2>
                    <div class="row">
                        <div class="col-md-4">
                            <h3>Number of items in both arrays</h3>
                            <p class="result">${fn:length(seekerData.resultSet)}</p>
                        </div>
                        <div class="col-md-4">
                            <h3>Time elapsed</h3>
                            <p class="result">${seekerData.executionTime} [ms]</p>
                        </div>
                        <div class="col-md-4">
                            <h3>Time elapsed Naive Method</h3>
                            <p class="result">${seekerData.executionTimeNaiveMethod} [ms]</p>
                        </div>                  
                    </div>
                </div>
            </c:if>
        </div>
    </div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script
        src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <!-- Latest compiled and minified JavaScript -->
    <script
        src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
</body>
</html>