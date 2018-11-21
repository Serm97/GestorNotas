var programasModule = angular.module("programasModule");

programasModule.controller('programasController', ['$scope', '$http', '$state', function($scope, $http, $state){
        
        $scope.programas = new Array();

        $scope.programa = {};
 
        $scope.crearPrograma = function() {

          $http.post('api/programas', JSON.stringify($scope.programa)).then(function(response){
            alert($scope.programa.nomPrograma + " ha sido creado.");
            $scope.programa = {};            
            $state.reload();
            
          }, function(error){
              console.log(error);
              
          });
        };
 

        $http.get('api/programas').then(function (response) {
            console.log(response);
            $scope.programas = response.data;
        }, function (error) {
            console.log(error);
        });

        $scope.eliminar = function (id) {
            $http.delete('api/programas/' + id).then(function (response) {
                //Recargar la pag
                console.log("Eliminado: " + id);
                $state.reload();
            }, function (error) {
                console.log(error);
            });
        };
}]);