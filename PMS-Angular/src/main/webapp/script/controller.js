app
		.controller(
				"mycontroller",
				function($scope, $http) {
					$scope.getCategories = function() {
						var url = "http://localhost:8090/PMS-Angular/JsonServlet?action=category";
						$http.get(url).success(function(response) {

							$scope.categories = response;
						}).error(function(msg) {
							$scope.categories = msg;
						});

					};

					$scope.getSubCategories = function() {
						// var catId=$scope.catId;
						var url = "http://localhost:8090/PMS-Angular/JsonServlet?action=subcategory";
						$http.get(url).success(function(response) {
							$scope.subcategories = response;
						}).error(function(msg) {

							$scope.subcategories = msg;
						});
					};

					$scope.getSupplier = function() {
						var url = "http://localhost:8090/PMS-Angular/JsonServlet?action=supplier";
						$http.get(url).success(function(response) {
							$scope.suppliers = response;

						}).error(function(msg) {

							$scope.suppliers = msg;
						});
					};

					$scope.getDiscount = function() {
						var url = "http://localhost:8090/PMS-Angular/JsonServlet?action=discount";
						$http.get(url).success(function(response) {
							$scope.discounts = response;

						}).error(function(msg) {

							$scope.discounts = msg;
						});
					};

				});

app.controller("listCtrl", function($scope, $http) {

	$http.get('http://localhost:8090/PMS-Angular/ViewAllServlet').success(
			function(response) {
				$scope.products = response;
			}).error(function(errMsg) {
		$scope.errmsg = errMsg;
	});

});

	app.controller("dispCtrl",function($scope,$http){
		
		
		$http.get('http://localhost:8090/PMS-Angular/DeleteServlet')
			.success(function(response){
				$scope.showp=response;
			})
			.error(function(errMsg){
				$scope.errmsg=errMsg;
			});
	});