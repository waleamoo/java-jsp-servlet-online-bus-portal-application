<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" 
	import="java.text.SimpleDateFormat, java.util.Date, com.google.gson.Gson" %>
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright &copy;  User Management <%= new SimpleDateFormat("yyyy").format(new Date()) %> &bull; South Africa</p>
    </div>
  </footer>

  <script type="text/javascript" src="resources/js/jquery.min.js"></script>
  <script type="text/javascript" src="resources/js/bootstrap.bundle.min.js"></script>
  <script type="text/javascript" src="resources/js/chart.min.js"></script>
  <!-- PayStack Payment JS -->
  <script src="https://js.paystack.co/v2/inline.js"></script>
  <script src="resources/js/web.js"></script>
  <% Gson gson = new Gson(); %>
  <script>
    let regstats = document.getElementById('student-bus-capacity').getContext('2d');
    let regchart = new Chart(regstats, {
        type: 'bar', 
        data: {
            labels: <%= gson.toJson(request.getAttribute("labels")) %>,
            datasets: [{
                label: 'Student Bus Capacity Report',
                data: <%= gson.toJson(request.getAttribute("counts")) %>, 
                backgroundColor: '#cea3a3', 
                borderWidth: 1,
                borderColor: '#c1a149',
                hoverBorderWidth: 3,
                hoverBorderColor: '#00cbff'
            }]

        } 
    });
  </script>
  
  <script>
    let activeStats = document.getElementById('student-bus-capacity-active').getContext('2d');
    let activechart = new Chart(activeStats, {
        type: 'pie', 
        data: {
            labels: <%= gson.toJson(request.getAttribute("activeLabels")) %>,
            datasets: [{
                label: 'Student Bus Capacity Report - Active Registrations Only',
                data: <%= gson.toJson(request.getAttribute("activeCounts")) %>, 
                backgroundColor: '#03fc90', 
                borderWidth: 1,
                borderColor: '#fdfdfd',
                hoverBorderWidth: 3,
                hoverBorderColor: '#000000'
            }]

        } 
    });
  </script>
  
  
</body>

</html>