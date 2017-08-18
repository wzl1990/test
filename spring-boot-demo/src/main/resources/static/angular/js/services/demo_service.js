'use strict';

app.factory('demoService', ['$http', '$q', function($http, $q){

	return {
		
			fetchAllDemo: function(currentPage,numPerPage) {
					return $http({
						               url:'/admin/demo/getAllByPage',
						               method : 'get',  
									   params : {  
								            'currentPage' : currentPage,  
								            'pageSize' : numPerPage  
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
					return $http.get('/admin/demo/getById?id='+id)
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
			
		    createDemo: function(demo){
					return $http.post('/admin/demo/create', demo)
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
		    
		    updateDemo: function(demo, id){
		    	console.info(demo)	
					return $http.post('/admin/demo/update', demo)
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
		    
			deleteDemo: function(id){
					return $http.delete('/admin/demo/delete/'+id)
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
