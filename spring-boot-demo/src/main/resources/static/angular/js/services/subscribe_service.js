'use strict';

app.factory('subscribeService', ['$http', '$q', function($http, $q){

	return {
		
			fetchAllSubscribes: function(currentPage,numPerPage,search) {
					return $http({
						               url:'/admin/subscribe/getAllByPage',
						               method : 'get',  
									   params : {  
								            'currentPage' : currentPage,  
								            'pageSize' : numPerPage,
								            'search':search
								       }          
					          })
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while fetching users');
										return $q.reject(errResponse);
									}
							);
			},
			findById: function(id){
					return $http.get('/admin/subscribe/getById?id='+id)
							.then(
									function(response){
										console.info(response.data);
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while creating user');
										return $q.reject(errResponse);
									}
							);
		    },
			
		    createSubscribe: function(demo){
					return $http.post('/admin/subscribe/create', demo)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while creating user');
										return $q.reject(errResponse);
									}
							);
		    },
		    
		    updateSubscribe: function(demo, id){
		    	console.info(demo)	
					return $http.post('/admin/subscribe/update', demo)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while updating user');
										return $q.reject(errResponse);
									}
							);
			},
		    
			deleteSubscribe: function(id){
					return $http.delete('/admin/subscribe/delete/'+id)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while deleting user');
										return $q.reject(errResponse);
									}
							);
			}
		
	};

}]);
