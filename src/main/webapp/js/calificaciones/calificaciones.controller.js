var inscripcionesModule = angular.module("inscripcionesModule");

inscripcionesModule.controller('inscripcionesController', ['$scope', '$http', '$state', function($scope, $http, $state){
        
        $scope.inscripciones = new Array();

        $scope.inscripcion = {};
 
        $scope.Inscribirse = function() {

          $http.post('api/inscripciones', JSON.stringify($scope.inscripcion)).then(function(response){
              console.log($scope.inscripcion);
              
            swal("Inscrito", "Se ha inscrito al curso N° " + $scope.inscripcion.idCurso , "success");
            $scope.inscripcion = {};            
            $state.reload();
            
          }, function(error){
              swal("Prohibido", "Ha ingresado datos no validos para la Inscripción.","error");
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

        // Cargar Datos
        $http.get('api/cursos').then(function (response) {
            $scope.listaCursos = new Array();
            $scope.listaCursos = response.data;
            
        }, function (error) {
            console.log(error);
        });

        $http.get('api/estudiantes').then(function (response) {
            $scope.listaEstudiantes = new Array();
            $scope.listaEstudiantes = response.data;
            console.log($scope.listaEstudiantes);
            
            
        }, function (error) {
            console.log(error);
        });
}]);