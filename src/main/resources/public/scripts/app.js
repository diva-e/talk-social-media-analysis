'use strict';

angular
  .module('socialMediaAnalysisApp', [
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
    'chart.js',
    'angular-jqcloud'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainController'
      })
      .when('/sentiment-analysis', {
        templateUrl: 'views/sentiment-analysis.html',
        controller: 'SentimentAnalysisController'
      })
      .when('/tagcloud', {
        templateUrl: 'views/tagcloud.html',
        controller: 'TagcloudController'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
