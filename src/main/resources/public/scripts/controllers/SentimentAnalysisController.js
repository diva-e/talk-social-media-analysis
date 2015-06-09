'use strict';

angular.module('socialMediaAnalysisApp').controller(
		'SentimentAnalysisController', function($scope, $http) {

			$scope.searchKeyword = '';

			$scope.performSentimentAnalysis = function() {
				console.log('perform analysis with keyword '
						+ $scope.searchKeyword);
				$http.get('/social-media-analysis/v1.0/sentiments', { params: { 'keyword': $scope.searchKeyword } })
				.then(function(result) {
					$scope.sentimentAnalysisResults = result.data;
				})};

		});