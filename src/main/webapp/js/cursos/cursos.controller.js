var cursosModule = angular.module("cursosModule");

cursosModule.controller('cursosController', ['$scope', '$http', '$state', function($scope, $http, $state){
        
        $scope.cursos = new Array();

        $scope.curso = {};
    
        // Crear Curso
        $scope.crearCurso = function() {

            let inicio = moment($scope.curso.inicio, "HH:mm.ss").format("hh:mm A");
            let fin = moment($scope.curso.fin, "HH:mm.ss").format("hh:mm A");
            let horario = $scope.curso.dia1 + '-' + $scope.curso.dia2 + ' | ' + inicio + ' a ' + fin;

            cursoCrear = {};

            cursoCrear.codCurso = $scope.curso.codCurso;
            cursoCrear.nomCurso = $scope.curso.nomCurso;
            cursoCrear.idAsignatura = $scope.curso.idAsignatura;
            cursoCrear.idProfesor = $scope.curso.idProfesor;
            cursoCrear.idHorario =  horario;
            
            $http.post('api/cursos', JSON.stringify(cursoCrear)).then(function(response){
            alert("Se ha inscrito a " +  cursoCrear.nomCurso);
            $scope.curso = {};            
            $state.reload();
            
            }, function(error){
                console.log(error);
                
            });
        };
 
        // Listar Cursos
        $http.get('api/cursos').then(function (response) {
            console.log(response.data);
            $scope.cursos = response.data;
        }, function (error) {
            console.log(error);
        });

        // Eliminar Curso
        $scope.eliminar = function (id) {
            $http.delete('api/cursos/' + id).then(function (response) {
                //Recargar la pag
                console.log("Eliminado: " + id);
                $state.reload();
            }, function (error) {
                console.log(error);
            });
        };

        // Encontrar Curso
        $scope.encontrar = function (id) {
            
            $http.get('api/cursos/'+id).then(function (response) {
                $scope.curso = response.data;
                console.log($scope.curso);
                
            }, function (error) {
                console.log(error);
            });
        };

        // Actualizar Curso
        $scope.actualizarCurso = function (id) {
            console.log($scope.curso);
            
            // Pendinete Modificacion Horario Entidad
            // if ($scope.curso.codCurso && $scope.curso.nomCurso && $scope.curso.idAsignatura && $scope.curso.idProfesor && 
            //     $scope.curso.dia1 && $scope.curso.dia2 && ){
            //     $http.put('api/cursos/'+id, JSON.stringify($scope.curso)).then(function (response) {
            //         $scope.curso = {};
            //         swal("Actualizado", "", "success");
            //         $state.reload();
            //     }, function (error) {
            //         console.log(error);
            //     });
            // }
        };

        // Cargar Combobox

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