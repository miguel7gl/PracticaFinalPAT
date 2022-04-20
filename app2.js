//Boton Buscar
let button= document.querySelector('.submit');

//URLs para la búsqueda de datos
const urlPrecios = 'https://api.esios.ree.es/indicators/';
const token = "67ff456a8376fbbb16a69c06b925535675ccc05b153c04f28219a66013a810c5";

/*
const headers = {
  Accept: application/json, application/vnd.esios-api-v1+json,
  Content-Type: application/json,
  Host: api.esios.ree.es,
  Authorization: token="67ff456a8376fbbb16a69c06b925535675ccc05b153c04f28219a66013a810c5"
};
*/

//Definimos lo que hace el boton cuando es pulsado
button.addEventListener('click', function(name){
  fetch(urlPrecios, {Authorization: Token token='67ff456a8376fbbb16a69c06b925535675ccc05b153c04f28219a66013a810c5'})
  .then(response => response.json())
  .then(data => {

    console.log(data);

    //Creamos una variable body donde almacenamos los datos
    let body = '';
    for (let x in data){
      
      //Imprimimos los datos en consola para comprobar que son cogidos correctamente
      console.log(x+": "+data[x]['price']);
      
      //Añadimos los datos a la variable body
      body += `<tr><td>${x}</td><td>${data[x]['price']}</td></tr>`;
    }

    //Mostramos la variable body en la página
    document.getElementById('datos').innerHTML = body;
    
    /*
    console.log('Hola');
    let body = '';

    for (let i=0; i<data.length; i++){
      body += i;
      console.log(i);
    }
    console.log('Adios');

    document.getElementById('prueba').innerHTML = body;
    */

    var ctx = document.getElementById("myChart").getContext("2d");
    var myChart = new Chart(ctx, {
      type: "line",
      data: {
        labels: [
          "Monday",
          "Tuesday",
          "Wednesday",
          "Thursday",
          "Friday",
          "Saturday",
          "Sunday",
        ],
        datasets: [
          {
            label: "work load",
            data: [2, 9, 3, 17, 6, 3, 7],
            backgroundColor: "rgba(153,205,1,0.6)",
          },
          {
            label: "free hours",
            data: [2, 2, 5, 5, 2, 1, 10],
            backgroundColor: "rgba(155,153,10,0.6)",
          },
        ],
      },
    });
  })
  .catch(err => alert("Error en el acceso a los datos"));
  })