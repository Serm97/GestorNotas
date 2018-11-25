var programasModule = angular.module("programasModule");

programasModule.controller('programasController', ['$scope', '$http', '$state', function($scope, $http, $state){
        
        $scope.programas = new Array();

        $scope.programa = {};
    
        // Crear Programa
        $scope.crearPrograma = function() {
          $http.post('api/programas', JSON.stringify($scope.programa)).then(function(response){
            swal("Exito", $scope.programa.nomPrograma + " ha sido creado.", "success");
            $scope.programa = {};            
            $state.reload();
            
          }, function(error){
              console.log(error);
              
          });
        };
 
        // Listar Programas
        $http.get('api/programas').then(function (response) {
            console.log(response);
            $scope.programas = response.data;
        }, function (error) {
            console.log(error);
        });

        // Eliminar Programa
        $scope.eliminar = function (id) {
            $http.delete('api/programas/' + id).then(function (response) {
                //Recargar la pag
                console.log("Eliminado: " + id);
                $state.reload();
            }, function (error) {
                swal("Restricciòn", "No se puede eliminar el programa por que existen asignaturas dependientes.", "error");
                console.log(error);
            });
        };

        // Buscar Programa
        $scope.encontrar = function (id) {
            
            $http.get('api/programas/'+id).then(function (response) {
                $scope.programa = response.data;
                console.log($scope.programa);
                
            }, function (error) {
                console.log(error);
            });
        };


        // Actualizar Programa
        $scope.actualizarPrograma = function (id) {
            console.log($scope.programa);
            
            if ($scope.programa.codPrograma && $scope.programa.nomPrograma && $scope.programa.nivelAcademico && $scope.programa.idPrograma){
                $http.put('api/programas/'+id, JSON.stringify($scope.programa)).then(function (response) {
                    $scope.programa = {};
                    swal("Actualizado", "", "success");
                    $state.reload();
                }, function (error) {
                    console.log(error);
                });
            }
        };
}]);