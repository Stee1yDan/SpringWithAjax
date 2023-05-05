$(document).ready(
    function() {
        // SUBMIT FORM
        $("#editForm").submit(function(event) {
            event.preventDefault();
            $.ajax("editBook?id=" + $("#editId").val()
                + "&name=" + $("#editBookName").val()
                + "&author=" + $("#editAuthor").val());
            ajaxGet();
        });

        function ajaxGet() {
            $.ajax({
                type : "GET",
                url : "getBooks",
                success : function(result) {
                    if (result.status == "success") {
                        $('#getResultDiv ul').empty();
                        var custList = "";
                        $.each(result.data,
                            function(i, book) {
                                var user =
                                    "id = " + book.id	+
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
                error : function(e) {
                    $("#getResultDiv").html("<strong>Error</strong>");
                    console.log("ERROR: ", e);
                }
            });
        }
    })