var personasModule = angular.module("personasModule");

personasModule.controller('personasController', ['$scope', '$http', '$state', function($scope, $http, $state){
        
        $scope.personas = new Array();

        $scope.person = {};
 
        $scope.create = function() {
          console.log($scope.person);   

          $http.post('api/personas', JSON.stringify($scope.person)).then(function(response){
            alert("Persona " + $scope.person.nombrePersona + " ha sido creada.")
            $scope.person = {};
            $state.reload();
          }, function(error){
              console.log(error);
              
          });
        };

        $http.get('api/programas').then(function (response) {
            $scope.listaProgramas = new Array();
            $scope.listaProgramas = response.data;
            
        }, function (error) {
            console.log(error);
        });
 

        $http.get('api/personas').then(function (response) {
            console.log(response);
            $scope.personas = response.data;
        }, function (error) {
            console.log(error);
        });

        $scope.eliminar = function (id) {
            $http.delete('api/personas/' + id).then(function (response) {
                //Recargar la pag
                console.log("Eliminado: " + id);
                $state.reload();
            }, function (error) {
                console.log(error);
            });
        };
}]);