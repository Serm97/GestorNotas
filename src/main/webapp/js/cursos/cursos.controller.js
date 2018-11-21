var cursosModule = angular.module("cursosModule");

cursosModule.controller('cursosController', ['$scope', '$http', '$state', function($scope, $http, $state){
        
        $scope.cursos = new Array();

        $scope.curso = {};
 
        $scope.crearCurso = function() {

          $http.post('api/cursos', JSON.stringify($scope.curso)).then(function(response){
            alert("Se ha inscrito a .");
            $scope.curso = {};            
            $state.reload();
            
          }, function(error){
              console.log(error);
              
          });
        };
 

        $http.get('api/cursos').then(function (response) {
            console.log(response);
            $scope.cursos = response.data;
        }, function (error) {
            console.log(error);
        });

        $scope.eliminar = function (id) {
            $http.delete('api/cursos/' + id).then(function (response) {
                //Recargar la pag
                console.log("Eliminado: " + id);
                $state.reload();
            }, function (error) {
                console.log(error);
            });
        };
}]);