'use strict';
app.controller('ModalInstanceCtrl', function ($scope, $uibModalInstance, item) {
            $scope.ok = function () {
            	
            };
            $scope.cancel = function () {
                $uibModalInstance.dismiss('cancel');
            };
        });


app.controller('demoController', [
		'$scope',
		'$log',
		'$uibModal',
		'demoService',
		function($scope, $log,$uibModal, demoService) {
			$scope.currentPage = 1;
			$scope.maxSize = 5;
			$scope.itemsPerPage = 10;
			$scope.demo = {
				id : null,
				name : '',
				password : '',
				email : '',
				ren:$scope.people
			};
		    $scope.people = [
			                        { name: 'Adam',      email: 'adam@email.com',      age: 12, country: 'United States' },
			                        { name: 'Amalie',    email: 'amalie@email.com',    age: 12, country: 'Argentina' },
			                        { name: 'Estefanía', email: 'estefania@email.com', age: 21, country: 'Argentina' },
			                        { name: 'Adrian',    email: 'adrian@email.com',    age: 21, country: 'Ecuador' },
			                        { name: 'Wladimir',  email: 'wladimir@email.com',  age: 30, country: 'Ecuador' },
			                        { name: 'Samantha',  email: 'samantha@email.com',  age: 30, country: 'United States' },
			                        { name: 'Nicole',    email: 'nicole@email.com',    age: 43, country: 'Colombia' },
			                        { name: 'Natasha',   email: 'natasha@email.com',   age: 54, country: 'Ecuador' },
			                        { name: 'Michael',   email: 'michael@email.com',   age: 15, country: 'Colombia' },
			                        { name: 'Nicolás',   email: 'nicole@email.com',    age: 43, country: 'Colombia' }
			];
			
	            $scope.open = function (size,id) {
					if(id!=0){
						$scope.findById(id);
					}
	                var modalInstance = $uibModal.open({
	                    templateUrl: 'myModalContent.html',
	                    controller: 'ModalInstanceCtrl',
	                    backdrop: "static",
	                    size: size,
	                    scope:$scope,
	                    resolve: {
	                        item: function () {
	                            return $scope;
	                        }
	                    }
	                });
	                modalInstance.result.then(function (selectedItem) {
	                    $scope.selected = selectedItem;
	                }, function () {
	                    $log.info('Modal dismissed at: ' + new Date());
	                });
	            };
	            $scope.toggleAnimation = function () {
	                $scope.animationsEnabled = !$scope.animationsEnabled;
	            };
			$scope.placement = {
	                    options: [5,10,20,50],
	                    pageSize:15,
	                    selected: 5,
	                    changeFn:function(){
	                        console.log($scope.placement.selected);
	                        $scope.maxSize=$scope.placement.selected;
	                    }
	        };
			
			$scope.fetchAllDemos = function(currentPage, pageSize) {
				demoService.fetchAllDemo(currentPage, pageSize).then(
						function(d) {
							$scope.demos = d.data;
							$scope.totalItems = d.totalCount;
						}, function(errResponse) {
							console.error('Error while fetching Currencies');
						});
			};

			$scope.checkAll = function(checked) {
				angular.forEach($scope.demos, function(item) {
					item.$checked = checked;
				});
			};

			$scope.pageChanged = function() {
				$log.log('Page changed to: ' + $scope.currentPage);
				$scope.fetchAllDemos($scope.currentPage, $scope.itemsPerPage);
			};

			$scope.createDemo = function(demo) {
				demoService.createDemo(demo).then($scope.fetchAllDemos(),
						function(errResponse) {
							console.error('Error while creating demo.');
						});
			};

			$scope.updateDemo = function(demo, id) {
				console.info(111);
				console.info(demo);
				demoService.updateDemo(demo, id).then($scope.fetchAllDemos,
						function(errResponse) {
							console.error('Error while updating demo.');
						});
			};

			$scope.deleteDemo = function(id) {
				demoService.deleteDemo(id).then($scope.fetchAllDemos,
						function(errResponse) {
							console.error('Error while deleting demo.');
						});
			};

			$scope.fetchAllDemos($scope.currentPage, $scope.itemsPerPage);

			$scope.submit = function() {
				$log.log('Page changed to: ' + $scope.demo)
				if ($scope.demo.id == null) {
					console.log('Saving New Demo', $scope.demo);
					$scope.createDemo($scope.demo);
				} else {
					$scope.updateDemo($scope.demo, $scope.demo.id);
				}
				$scope.reset();
			};
			
			$scope.findById = function(id) {
				$scope.demo=demoService.findById(id).then(
						function(data) {
							console.info(111111111);
							console.info(data);
							$scope.demo = data;
						}, function(errResponse) {
							console.error('Error while fetching Currencies');
						});
			};

			$scope.edit = function(id) {
				console.log('id to be edited', id);
				$scope.findById(id);
				for (var i = 0; i < $scope.demos.length; i++) {
					if ($scope.demos[i].id == id) {
						$scope.demo = angular.copy($scope.demos[i]);
						break;
					}
				}
			};

			$scope.remove = function(id) {
				console.log('id to be deleted', id);
				for (var i = 0; i < $scope.demos.length; i++) {
					if ($scope.demos[i].id == id) {
						$scope.reset();
						break;
					}
				}
				$scope.deleteDemo(id);
			};

			$scope.reset = function() {
				console.log('Saving New Demo', $scope.demo.name);
				$scope.demo = {
					id : null,
					name : '',
					password : '',
					email : ''
				};
				$scope.myForm.$setPristine();
			};

		} ]);