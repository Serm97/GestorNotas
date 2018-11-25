var estudiantesModule = angular.module("estudiantesModule");

estudiantesModule.controller('estudiantesController', ['$scope', '$http', '$state', function($scope, $http, $state){
        
        $scope.estudiantes = new Array();

        // $scope.person = {};
 
        // $http.get('api/estudiantes').then(function (response) {
        //     $scope.listaProgramas = new Array();
        //     $scope.listaProgramas = response.data;   
            
        // }, function (error) {
        //     console.log(error);
        // });
 

        $http.get('api/estudiantes').then(function (response) {
            console.log(response);
            $scope.estudiantes = response.data;
        }, function (error) {
            console.log(error);
        });

        $scope.eliminar = function (id, person) {
            $http.delete('api/estudiantes/' + id).then(function (response) {

                $http.delete('api/personas/' + person).then(function (response) {
                    //Recargar la pag
                    console.log("Eliminado: " + id);
                    $state.reload();
                }, function (error) {
                    console.log(error);
                });

                swal("El estudiante ha sido eliminado al igual que sus datos personales.");
                //Recargar la pag
                console.log("Eliminado: " + id);
                $state.reload();
            }, function (error) {
                console.log(error);
            });
        };
}]);
