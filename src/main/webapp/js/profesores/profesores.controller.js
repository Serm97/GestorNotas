var profesoresModule = angular.module("profesoresModule");

profesoresModule.controller('profesoresController', ['$scope', '$http', '$state', function($scope, $http, $state){
        
        $scope.profesores = new Array();

        // $scope.person = {};
 
        // $http.get('api/estudiantes').then(function (response) {
        //     $scope.listaProgramas = new Array();
        //     $scope.listaProgramas = response.data;   
            
        // }, function (error) {
        //     console.log(error);
        // });
 

        $http.get('api/profesores').then(function (response) {
            console.log(response.data);
            $scope.profesores = response.data;
        }, function (error) {
            console.log(error);
        });

        $scope.eliminar = function (id, person) {
            
            $http.delete('api/profesores/' + id).then(function (response) {

                $http.delete('api/personas/' + person).then(function (response) {
                    //Recargar la pag
                    console.log("Eliminado: " + id);
                    $state.reload();
                }, function (error) {
                    console.log(error);
                });

                swal("El Profesor ha sido eliminado al igual que sus datos personales.");
                //Recargar la pag
                console.log("Eliminado: " + id);
                $state.reload();
            }, function (error) {
                console.log(error);
            });
        };
}]);
