$(document).ready(
    function () {

        // SUBMIT FORM
        $("#insertForm").submit(function (event) {
            event.preventDefault();
            ajaxPost();
        });

        function ajaxPost() {

            // PREPARE FORM DATA
            let formData = {
                bookName: $("#bookName").val(),
                author: $("#author").val()
            }

            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: "saveBook",
                data: JSON.stringify(formData),
                dataType: 'json',
                success: function (result) {
                    if (result.status == "success") {
                        $("#postResultDiv").html();
                    } else {
                        $("#postResultDiv").html("<strong>Error</strong>");
                    }
                    console.log(result);
                    ajaxGet();
                },
                error: function (e) {
                    alert("Error!")
                    console.log("ERROR: ", e);
                }
            });
        }

        function ajaxGet() {
            $.ajax({
                type: "GET",
                url: "getBooks",
                success: function (result) {
                    if (result.status == "success") {
                        $('#getResultDiv ul').empty();
                        var custList = "";
                        $.each(result.data,
                            function (i, book) {
                                var user =
                                    "id = " + book.id +
                                    " Book Name = "
                                    + book.bookName
                                    + ", Author  = " + book.author
                                    + "<br>";
                                $('#getResultDiv .list-group').append(
                                    user)
                            });
                        console.log("Success: ", result);
                    } else {
                        $("#getResultDiv").html("<strong>Error</strong>");
                        console.log("Fail: ", result);
                    }
                },
                error: function (e) {
                    $("#getResultDiv").html("<strong>Error</strong>");
                    console.log("ERROR: ", e);
                }
            });
        }
    })