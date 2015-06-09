'use strict';

angular.module('socialMediaAnalysisApp').controller(
		'SentimentAnalysisController', function($scope, $http) {

			$scope.searchKeyword = '';
			
			$scope.sentimentAnalysisResultsValues = [];
			
			$scope.sentimentAnalysisResultsLabels = [];
			
			$scope.performSentimentAnalysis = function() {
				$http.get('/social-media-analysis/v1.0/sentiments', 
						{ params: { 'keyword': $scope.searchKeyword } })
				.then(function(result) {
					$scope.prepareChartModels(result.data);
				})};
				
			$scope.prepareChartModels = function(sentimentAnalysisResults) {
				
				$scope.sentimentAnalysisResultsValues = [];
				$scope.sentimentAnalysisResultsLabels = [];
				
				angular.forEach(sentimentAnalysisResults, function(value, key) {
					  $scope.sentimentAnalysisResultsLabels.push(key);
					  $scope.sentimentAnalysisResultsValues.push(value);
					});
			};

		});