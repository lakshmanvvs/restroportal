(function() {
	'use strict';

	angular.module('restApp').controller('CustomerCtrl', MainController);

	MainController.$inject = ['$http','$location'];
	
	function MainController($http,$location) {
		var customerVm = this;
		
		console.log('Main Controller');
		//console.log($routeParams);
		//console.log(dataService);
		
		/*dataService.getUsers().then(function(data){
			
			customerVm.people = data;
			
		}, function(err){
			
			console.log(err);
		});*/
			
		
		
		customerVm.updateEmp = function () {
			
			if(customerVm.confirmCode)
			{
				$http({
					method: 'PUT',
					url: 'api/customer/edittable/' + customerVm.confirmCode,
					data: customerVm.editUser
				}).success(function(data){
					console.log(data);
					//customerVm.getdata = data;
				}).error(function(error){
					console.log(error);
				});
			}
		};
		
		customerVm.reserveUser = function() {
			$http({
				method: 'POST',
				url: 'api/customer/reservetable',
				data: customerVm.newUser
			}).success(function(data){
				console.log(data);
				mctrl.newEmp = null;
			}).error(function(error){
				console.log(error);
			});
			
		};
		
		customerVm.login = function () {
			
			$http({
				method: 'POST',
				url: 'api/owner/login',
				data: customerVm.loginOwner
			}).success(function(data){
				console.log(data);
				customerVm.status = data;
				if (customerVm.status == 'Valid login'){
					customerVm.loggedIn = true;
					$location.path('/owner/postlogin');
				}
					else {
						customerVm.loggedIn = false;
					}
				
				customerVm.loginOwner = null;
			}).error(function(error){
				console.log(error);
			});
			
		};
		
	}
		
})();