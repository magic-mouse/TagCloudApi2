angular.module('cloud', ['ngTagCloud'])
    .controller('twitter_cloud', function($scope, $http) {

        $scope.word_cloud = [{text: "placeholder", weight: 1}];

        $scope.generateCloud = function(){


            // replace added to sanitize url
            $http.get("/api/twitter_cloud?q=" + $scope.hashtag.replace("#","") + "&count=" + $scope.nr_tweets).then(
                function(data){
                    $scope.word_cloud = data.data;
                },
                function(data,error){
                }
            );
        }
    }).controller('rss_cloud', function($scope, $http) {

        $scope.word_cloud = [{text: "placeholder", weight: 1}];

        $scope.generateCloud = function(){

            $http.get("/api/rss?q=" + $scope.website ).then(
                function(data){
                    $scope.word_cloud = data.data;
                },
                function(data,error){
                }
            );
        }
    });

