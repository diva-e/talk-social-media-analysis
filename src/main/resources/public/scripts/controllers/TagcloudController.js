'use strict';

angular.module('socialMediaAnalysisApp').controller('TagcloudController',
		function($scope, $http) {

			$scope.searchKeyword = '';

			$scope.tagcloudModel = null;

			$scope.calculateWordFrequencies = function() {
				$http.get('/social-media-analysis/v1.0/wordfrequencies', {
					params : {
						'keyword' : $scope.searchKeyword
					}
				}).then(function(result) {
					$scope.prepareTagcloudModel(result.data);
				})
			};

			$scope.prepareTagcloudModel = function(wordFrequencies) {
				$scope.tagcloudModel = [];

				angular.forEach(wordFrequencies, function(value, key) {
					$scope.tagcloudModel.push({
						text : key,
						weight : value
					});
				});
			}

		});
