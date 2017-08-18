'use strict';

app
  .run(
      function ($rootScope,   $state,   $stateParams) {
          $rootScope.$state = $state;
          $rootScope.$stateParams = $stateParams;        
      }
  )
.config(
      function ($stateProvider,   $urlRouterProvider) {
          $urlRouterProvider
              .otherwise('/app/dashboard');
          $stateProvider
              .state('app', {
                  abstract: true,
                  url: '/app',
                  templateUrl: 'admin/app.html',
              })
              .state('app.dashboard', {
                  url: '/dashboard',
                  templateUrl: 'admin/dashboard.html',
              })
		      .state('app.newslist', {
                  url: '/newslist',
                  templateUrl: 'admin/news/list.html',
              })
			  .state('app.test', {
                  url: '/test',
                  templateUrl: 'admin/news/test.html',
              })
			  .state('app.demo', {
                  url: '/demo',
                  templateUrl: 'admin/demo/demo.html',
                   resolve: {
                      deps: ['$ocLazyLoad',
                        function( $ocLazyLoad ){
                    	  return $ocLazyLoad.load('ui.select').then(
                                  function(){
                                	  return $ocLazyLoad.load([
                                	                            'js/services/demo_service.js', 
                                	                            'js/controllers/demo_controller.js',
                                	                            'js/controllers/select.js'
                                	                          ]);
                                  }
                              );
                      }]
                  }
              })
              .state('app.subscribe', {
                  url: '/subscribe',
                  templateUrl: 'admin/subscribe/subscribe.html',
                   resolve: {
                      deps: ['$ocLazyLoad',
                        function( $ocLazyLoad ){
                    	  return $ocLazyLoad.load('ui.select').then(
                                  function(){
                                	  return $ocLazyLoad.load([
                                	                            'js/services/subscribe_service.js', 
                                	                            'js/controllers/subscribe_controller.js',
                                	                            'js/controllers/select.js'
                                	                          ]);
                                  }
                              );
                      }]
                  }
              })
      }
  );
