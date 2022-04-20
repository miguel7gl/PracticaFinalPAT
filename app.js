//Boton Buscar
let button= document.querySelector('.submit');

//URLs para la búsqueda de datos
const cors = 'https://cors-anywhere.herokuapp.com/';
const urlPecioMejor = 'https://api.preciodelaluz.org/v1/prices/cheapests?zone=PCB&n=1';
const urlPrecios = 'https://api.preciodelaluz.org/v1/prices/all?zone=PCB';

//Definimos lo que hace el boton cuando es pulsado
button.addEventListener('click', function(name){
  fetch(cors+urlPrecios)
  .then(response => response.json())
  .then(data => {

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
    */
  })
  .catch(err => alert("Error en el acceso a los datos"));
})