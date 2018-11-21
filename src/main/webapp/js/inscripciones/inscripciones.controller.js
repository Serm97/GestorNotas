var inscripcionesModule = angular.module("inscripcionesModule");

inscripcionesModule.controller('inscripcionesController', ['$scope', '$http', '$state', function($scope, $http, $state){
        
        $scope.inscripciones = new Array();

        $scope.inscripcion = {};
 
        $scope.Inscribirse = function() {

          $http.post('api/inscripciones', JSON.stringify($scope.inscripcion)).then(function(response){
            alert("Se ha inscrito a .");
            $scope.inscripcion = {};            
            $state.reload();
            
          }, function(error){
              console.log(error);
              
          });
        };
 

        $http.get('api/inscripciones').then(function (response) {
            console.log(response);
            $scope.inscripciones = response.data;
        }, function (error) {
            console.log(error);
        });

        $scope.eliminar = function (id) {
            $http.delete('api/inscripciones/' + id).then(function (response) {
                //Recargar la pag
                console.log("Eliminado: " + id);
                $state.reload();
            }, function (error) {
                console.log(error);
            });
        };
}]);