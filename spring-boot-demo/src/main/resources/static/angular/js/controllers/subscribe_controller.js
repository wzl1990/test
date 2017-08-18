'use strict';
app.controller('ModalInstanceCtrl', function ($scope, $uibModalInstance, item) {
            $scope.ok = function () {
            	
            };
            $scope.cancel = function () {
                $uibModalInstance.dismiss('cancel');
            };
        });

app.controller('subscribeController', [
		'$scope',
		'$log',
		'$uibModal',
		'subscribeService',
		function($scope, $log,$uibModal, subscribeService) {
			$scope.currentPage = 1;
			$scope.maxSize = 5;
			$scope.itemsPerPage = 10;
			$scope.search =null;
			$scope.modalInstance=null;
			$scope.subscribe = {
				id : null,
				clientName : '',
				url : '',
				name : '',
				type :'ORDINARY',
				topic : '',
				tag : '',
				groupName : '',
				consumeFromWhere :'',
				Email:'',
				consumeThreadMin : 10,
				consumeThreadMax : 20,
				pullThresholdForQueue : 0,
				consumeMessageBatchMaxSize : 0,
				pullBatchSize : 0,
				pullInterval : 0,
				retryCount : 3,
				businessKey : '',
				status: 'START',
				retryCount:1,
			};
	        $scope.open = function (size,id) {
					if(id!=0){
						$scope.findById(id);
					}else{
						$scope.reset();
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
	                $scope.modalInstance=modalInstance;
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
			
			$scope.fetchAllSubscribes = function(currentPage, pageSize) {
				$log.log('Page changed to: ' + currentPage);
				$log.log('Page changed to: ' + pageSize);
				
				subscribeService.fetchAllSubscribes(currentPage, pageSize,$scope.search).then(
						function(d) {
							$scope.subscribes = d.data;
							$scope.totalItems = d.totalCount;
						}, function(errResponse) {
							console.error('Error while fetching Currencies');
						});
			};

			$scope.checkAll = function(checked) {
				angular.forEach($scope.subscribes, function(item) {
					item.$checked = checked;
				});
			};

			$scope.pageChanged = function() {
				$log.log('Page changed to: ' + $scope.currentPage);
				$scope.fetchAllSubscribes($scope.currentPage, $scope.itemsPerPage);
			};

			$scope.createSubscribe = function(subscribe) {
				subscribeService.createSubscribe(subscribe).then($scope.fetchAllSubscribes($scope.currentPage, $scope.itemsPerPage),
						function(errResponse) {
							console.error('Error while creating .');
						});
			};

			$scope.updateSubscribe = function(subscribe, id) {
				subscribeService.updateSubscribe(subscribe, id).then($scope.fetchAllSubscribes($scope.currentPage, $scope.itemsPerPage),
						function(errResponse) {
							console.error('Error while updating .');
						});
			};

			$scope.deleteSubscribe = function(id) {
				subscribeService.deleteSubscribe(id).then($scope.fetchAllSubscribes($scope.currentPage, $scope.itemsPerPage),
						function(errResponse) {
							console.error('Error while deleting subscribeService.');
						});
			};

			$scope.fetchAllSubscribes($scope.currentPage, $scope.itemsPerPage);

			$scope.submit = function() {
				if ($scope.subscribe.id == null) {
					console.log('Saving New subscribe', $scope.subscribe);
					$scope.createSubscribe($scope.subscribe);
				} else {
					$scope.updateSubscribe($scope.subscribe, $scope.subscribe.id);
				}
				$scope.reset();
			};
			
			$scope.findById = function(id) {
				$scope.subscribe=subscribeService.findById(id).then(
						function(data) {
							$scope.subscribe = data;
						}, function(errResponse) {
							console.error('Error while fetching Currencies');
						});
			};

			$scope.edit = function(id) {
				$scope.findById(id);
			};

			$scope.remove = function(id) {
				$scope.deleteSubscribe(id);
			};

			$scope.reset = function() {
				$scope.subscribe = {
						id : null,
						clientName : '',
						url : '',
						name : '',
						type :'ORDINARY',
						topic : '',
						tag : '',
						groupName : '',
						consumeFromWhere :'',
						Email:'',
						consumeThreadMin : 10,
						consumeThreadMax : 20,
						pullThresholdForQueue : 0,
						consumeMessageBatchMaxSize : 0,
						pullBatchSize : 0,
						pullInterval : 0,
						retryCount : 3,
						businessKey : '',
						status: 'START',
						retryCount:1,
					};
				if($scope.myForm!=undefined){
				   $scope.myForm.$setPristine();
				}
			};

		} ]);