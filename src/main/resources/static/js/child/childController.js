angular.module('courseApp.childControllers', []).controller(
		'ChildListController',
		function($scope, $state, $window, Child, uibDateParser) {
			$scope.children = Child.query();
			$scope.deleteChild = function(child) {
				child.$delete(function() {
					$scope.children = Child.query();
					$state.go('children');
				});
			}
		}).controller('ChildCreateController',
		function($scope, $state, $stateParams, uibDateParser, Child, Parent, Course, $resource) {

			$scope.child = new Child();
			$scope.parents = Parent.query();
			$scope.courses = Course.query();

			$scope.addChild = function() {
				$scope.child.$save(function() {
					$state.go('children');
				});
			}

			$scope.childDobPopup = {
				opened : false
			};

			$scope.openChildDobPopup = function() {
				$scope.childDobPopup.opened = true;
			};
			$scope.dateOptions = {
				formatYear : 'yy',
				maxDate : new Date(),
				minDate : new Date(1989, 5, 22),
				startingDay : 1
			};
		}).controller('ChildViewController',
		function($scope, $resource, $stateParams, Child) {

			$scope.child = Child.get({
				id : $stateParams.id
			});
			
			var Attendency = $resource('/child/:id/attendencies', {
				id : $stateParams.id
			});
			
			var Payment = $resource('/child/:id/payments', {
				id : $stateParams.id
			});
			
			$scope.attendencies = Attendency.query();
			$scope.payments = Payment.query();
			
			
			$scope.getTotalAttended = function(){
			    var total = 0;
			    for(var i = 0; i < $scope.attendencies.length; i++){
			        var att = $scope.attendencies[i];
			        total += (att.amount);
			    }
			    return total;
			}
			
			$scope.getTotalPaid = function(){
			    var total = 0;
			    for(var i = 0; i < $scope.payments.length; i++){
			        var att = $scope.payments[i];
			        total += (att.amount);
			    }
			    return total;
			}
			
			
			

		}).controller('ChildEditController',
		function($scope, $state, $stateParams, Child, Parent, Course) {

			$scope.parents = Parent.query();
			$scope.courses = Course.query();
			
			$scope.updateChild = function(child) {
				$scope.child.$Update(function() {
					$state.go('children');
				});
			};
			
			$scope.loadChild = function() {
				$scope.child = Child.get({
					id : $stateParams.id
				});
			};

			$scope.childDobPopup = {
				opened : false
			};

			$scope.openChildDobPopup = function() {
				$scope.childDobPopup.opened = true;
			};
				$scope.dateOptions = {
				formatYear : 'yy',
				maxDate : new Date(),
				minDate : new Date(1989, 5, 22),
				startingDay : 1
			};
				 $scope.formats = ['dd-MMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
				    $scope.format = $scope.formats[1];
				    
				    $scope.loadChild();
		});