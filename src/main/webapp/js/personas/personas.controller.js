var personasModule = angular.module("personasModule");

personasModule.controller('personasController', ['$scope', '$http', '$state', function($scope, $http, $state){
        
        $scope.personas = new Array();

        $scope.person = {};

        // Crear Persona 
        $scope.create = function() {
            
          $http.post('api/personas', JSON.stringify($scope.person)).then(function(response){
            alert("Persona " + $scope.person.nombrePersona + " ha sido creada.")
            persona = response.data;

            switch($scope.person.rol){
                case "Estudiante":
                    estudiante = {};
                    estudiante.codEstudiante = '500'+ getRandomInt(100, 200);
                    estudiante.idPersona = persona;
                    $http.post('api/estudiantes', JSON.stringify(estudiante)).then(function(response){
                        alert("Asignado a la lista de Estudiantes.");
                    }, function (error) {
                        console.log(error);
                    });   
                    estudiante = {};                
                break;

                case "Profesor":
                    profesor = {};
                    profesor.codprofesor = '200'+ getRandomInt(200, 400);
                    profesor.idPersona = persona;
                    profesor.areaProfundizacion = "Por definir";

                    $http.post('api/profesores', JSON.stringify(profesor)).then(function(response){
                        alert("Asignado a la lista de Profesores.");
                    }, function (error) {
                        console.log(error);
                    });
                    profesor = {};
                break;

                case "Coordinador":
                    coordinador = {};
                    coordinador.codCoordinador = '111'+ getRandomInt(111, 500);
                    coordinador.idPersona = persona;
                    coordinador.idPrograma = persona.idPrograma;
                    alert("Asignado a la lista de Coordinadores.");
                    // $http.post('api/profesores', JSON.stringify(coordinador)).then(function(response){
                       
                    // }, function (error) {
                    //     console.log(error);
                    // });
                    coordinador = {};
                break;

            }   


            $scope.person = {};
            $state.reload();
          }, function(error){
              console.log(error);
              
          });
        };

        // ComboBox
        $http.get('api/programas').then(function (response) {
            $scope.listaProgramas = new Array();
            $scope.listaProgramas = response.data;
            
        }, function (error) {
            console.log(error);
        });
 
        //Listar Personas
        $http.get('api/personas').then(function (response) {
            console.log(response.data);
            $scope.personas = response.data;
        }, function (error) {
            console.log(error);
        });

        // Eliminar Persona
        $scope.eliminar = function (id) {
            $http.delete('api/personas/' + id).then(function (response) {
                //Recargar la pag
                console.log("Eliminado: " + id);
                $state.reload();
            }, function (error) {
                console.log(error);
            });
        };

        // Encontrar Persona
        $scope.encontrar = function (id) {
            
            $http.get('api/personas/'+id).then(function (response) {
                $scope.person = response.data;
                
            }, function (error) {
                console.log(error);
            });
        };

        // Actualizar Persona
        $scope.actualizarPersona = function (id) {
            console.log($scope.curso);
            
            if ($scope.person.idTipoDocumento && $scope.person.numDocumento && $scope.person.nombrePersona && $scope.person.apellidoPersona && $scope.person.idGenero && $scope.person.idPrograma && $scope.person.rol){
                $http.put('api/personas/'+id, JSON.stringify($scope.person)).then(function (response) {
                    $scope.person = {};
                    swal("Actualizado", "", "success");
                    $state.reload();
                }, function (error) {
                    console.log(error);
                });
            }
        };
}]);

function getRandomInt(min, max) {
    return Math.floor(Math.random() * (max - min)) + min;
  }