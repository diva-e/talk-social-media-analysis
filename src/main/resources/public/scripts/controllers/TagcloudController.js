'use strict';

angular.module('socialMediaAnalysisApp').controller('TagcloudController',
		function($scope) {
			$scope.words = [{text: "word1", weight: 10}, {text: "word2", weight: 8}, {text: "word3", weight: 3}];
		});
