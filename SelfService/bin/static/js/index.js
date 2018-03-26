var app = angular.module("app", []);
app.controller("HttpGetController", function($scope, $http) {

	$scope.SendData = function() {
		var data = {
			"restrictionMap" : [ {
				"key" : "tenantName",
				"value" : $scope.tenantName
			} ]
		}

		var config = {
			headers : {
				'Content-Type' : 'application/json'
			}
		}
		$http.post('../selfservice/getStatsticsByTenantIdAndFromDateAndToDate',
				data).then(function(success) {
			$scope.PostDataResponse = [];
			$.each(success.data, function(index, array) {
				$.each(array.values, function(index, obj) {
					$scope.PostDataResponse.push(obj);
				});
			});
//			$scope.PostDataResponse = success.data[0].values;
			$scope.table_headers = [];
			$.each(success.data[0].values[4], function(k, v) {
				$scope.table_headers.push({"name" : k});
			});
			console.log($scope.table_headers);
		});
	};

});