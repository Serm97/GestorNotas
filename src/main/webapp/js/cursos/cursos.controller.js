var cursosModule = angular.module("cursosModule");

cursosModule.controller('cursosController', ['$scope', '$http', '$state', function($scope, $http, $state){
        
        $scope.cursos = new Array();

        $scope.curso = {};
 
        $scope.crearCurso = function() {

            let horario = '"' + $scope.curso.dia1 + '-' + $scope.curso.dia2 + ' | ' + $scope.curso.inicio + ' a ' + $scope.curso.fin;

            console.log(horario);
            

        //   $http.post('api/cursos', JSON.stringify($scope.curso)).then(function(response){
        //     alert("Se ha inscrito a .");
        //     $scope.curso = {};            
        //     $state.reload();
            
        //   }, function(error){
        //       console.log(error);
              
        //   });
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

        $http.get('api/asignaturas').then(function (response) {
            $scope.listaAsignaturas = new Array();
            $scope.listaAsignaturas = response.data;
            
        }, function (error) {
            console.log(error);
        });

        $http.get('api/profesores').then(function (response) {
            $scope.listaProfesores = new Array();
            $scope.listaProfesores = response.data;
            console.log($scope.listaProfesores);
            
        }, function (error) {
            console.log(error);
        });

        $http.get('api/programas').then(function (response) {
            $scope.listaProgramas = new Array();
            $scope.listaProgramas = response.data;
            
        }, function (error) {
            console.log(error);
        });
}]);