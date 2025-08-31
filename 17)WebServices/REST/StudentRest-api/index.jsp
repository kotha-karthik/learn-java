<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Students</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="bg-light">

<div class="container my-5">
    <h2 class="mb-4 text-center">Student List</h2>
    
    <table class="table table-striped table-hover shadow-sm rounded" id="studentTable">
        <thead class="table-dark">
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Name</th>
                <th scope="col">Fee</th>
                <th scope="col">Action</th>
            </tr>
        </thead>
        <tbody>
            <!-- Data will load here -->
        </tbody>
    </table>

    <!-- Pagination controls -->
    <nav>
        <ul class="pagination justify-content-center" id="pagination">
            <!-- Buttons will be generated -->
        </ul>
    </nav>
</div>

<!-- Student Detail Modal -->
<div class="modal fade" id="studentModal" tabindex="-1" aria-labelledby="studentModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content shadow-lg rounded-3">
      <div class="modal-header bg-dark text-white">
        <h5 class="modal-title" id="studentModalLabel">Student Details</h5>
        <button type="button" class="btn-close btn-close-white" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <p><strong>ID:</strong> <span id="modalId"></span></p>
        <p><strong>Name:</strong> <span id="modalName"></span></p>
        <p><strong>Fee:</strong> $<span id="modalFee"></span></p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-outline-secondary" data-bs-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

<script>
    $(document).ready(function () {
        let students = [];
        let currentPage = 1;
        let rowsPerPage = 10;

        // Fetch data
        $.get("http://localhost:8080/student-rest/api/students", function (data) {
            students = data;
            displayTable();
            setupPagination();
        });

        // Display table rows for current page
        function displayTable() {
            let tbody = $("#studentTable tbody");
            tbody.empty();

            let start = (currentPage - 1) * rowsPerPage;
            let end = start + rowsPerPage;
            let paginatedStudents = students.slice(start, end);

            $.each(paginatedStudents, function (index, student) {
                tbody.append(
                    "<tr>" +
                        "<td>" + student.sid + "</td>" +
                        "<td>" + student.sname + "</td>" +
                        "<td>$" + student.fee + "</td>" +
                        "<td><button class='btn btn-sm btn-primary viewBtn' " +
                        "data-id='" + student.sid + "' data-name='" + student.sname + "' data-fee='" + student.fee + "'>" +
                        "View</button></td>" +
                    "</tr>"
                );
            });
        }

        // Setup pagination controls
        function setupPagination() {
            let totalPages = Math.ceil(students.length / rowsPerPage);
            let pagination = $("#pagination");
            pagination.empty();

            for (let i = 1; i <= totalPages; i++) {
                pagination.append(
                    "<li class='page-item " + (i === currentPage ? "active" : "") + "'>" +
                        "<a class='page-link' href='#'>" + i + "</a>" +
                    "</li>"
                );
            }

            $(".page-link").click(function (e) {
                e.preventDefault();
                currentPage = parseInt($(this).text());
                displayTable();
                setupPagination();
            });
        }

        // Event: Show modal on button click
        $(document).on("click", ".viewBtn", function () {
            $("#modalId").text($(this).data("id"));
            $("#modalName").text($(this).data("name"));
            $("#modalFee").text($(this).data("fee"));
            $("#studentModal").modal("show");
        });
    });
</script>

</body>
</html>
