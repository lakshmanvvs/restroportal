(function(){
	
	angular.module('restApp')
	 .service('dataService', dataServiceFn);
	
	dataServiceFn.$inject = ['$q', '$http'];
	
	function dataServiceFn($q, $http){
		
		var self= this; 
		
		self.getUsers = function() {
		      var defer = $q.defer();

		      $http({
		          method: 'GET',
		          url: 'api/customer/all'
		        })
		        .success(function(data) {
		          defer.resolve(data);
		        })
		        .error(function(err) {
		          defer.reject(err);
		        });

		      return defer.promise;
		    };
		
		
	
	
	}
	
}());