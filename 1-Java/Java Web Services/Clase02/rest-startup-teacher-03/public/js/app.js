(function() {
	
    var app = angular.module ("app", []);

	app.controller ("HttpCtrl", function ($scope, $http) {


	    $scope.employee = {firstName:'', lastName:'', title:'', city:'', officePhone:'', cellPhone:'', email:'', picture: 'test.jpg', department:''};

		
		var response = $http.get ('http://localhost:8080/employee-service2/api/employees');
		


		response.success ( function (data) {
			
			$scope.employees = data;
			console.log ("[main] # of items: " + data.length);
			
			angular.forEach (data, function (element) {

				console.log ("[main] employee: " + element.firstName + ' ' + element.lastName);
			});
		})

		response.error (function (data, status, headers, 
			                      config) {
			
			alert ("AJAX failed to get data, status = " + status);
		})

		

		$scope.add = function () {			
            
            jsonObj = angular.toJson ($scope.employee, false);

			console.log("[Create] data: " + jsonObj);

            var response = $http.post ('http://localhost:8080/employee-service2/api/employees/', jsonObj);
            
            response.success (function (data, status) {
                
                console.log ("Inside create operation..." + angular.toJson (data, false) + ", status=" + status);	
            });

            response.error (function (data, status) {

                alert ("AJAX failed to get data, status=" + status);  
            }); 
		};	
	});	
	
})();