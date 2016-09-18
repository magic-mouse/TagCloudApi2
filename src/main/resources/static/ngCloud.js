angular.module('cloud', [])
    .controller('twitter_cloud', function($scope, $http) {
        $scope.generateCloud = function(){
            $http.get("/api/twitter_cloud?q=" + $scope.hashtag + "&count=50").then(
                function(data){
                    $scope.word_cloud = data.data;
                },
                function(data,error){
                }
            );
        }
    });

