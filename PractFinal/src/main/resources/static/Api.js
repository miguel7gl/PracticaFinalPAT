//Boton Buscar
let button= document.getElementById('submit');

let datosGrafico = [];

//URLs para la búsqueda de datos
const urlPrecios = 'https://api.esios.ree.es/indicators/';
const url2 = "https://api.esios.ree.es/archives?date=2015-09-15T23:59:59+00:00";
const token = "67ff456a8376fbbb16a69c06b925535675ccc05b153c04f28219a66013a810c5";

const url = 'https://api.esios.ree.es/indicators/1001'
const hdrs = {'Accept':'application/json; application/vnd.esios-api-v2+json','Content-Type':'application/json','Host':'api.esios.ree.es','Authorization':'Token token="67ff456a8376fbbb16a69c06b925535675ccc05b153c04f28219a66013a810c5"'}

//Definimos lo que hace el boton cuando es pulsado
button.addEventListener('click', function(name){
  fetch(url, {method: "GET", headers: hdrs})
  .then(response => response.json())
  .then(data => {

    console.log(typeof data.indicator.values[0].datetime);
    console.log(data);
    console.log(data.indicator.id);

    let datos = '';
    let hora = '';
    let precio = '';

    //Creamos una variable body donde almacenamos los datos
    let fecha = data.indicator.values[0].datetime.substring(0,10);
    let body = '';

    for(i=0; i<data.indicator.values.length; i+=5)
    {      
      //Imprimimos los datos en consola para comprobar que son cogidos correctamente
      console.log(data.indicator.values[i].datetime.substring(0,10)+" ("+data.indicator.values[i].datetime.substring(11,19)+"): "+data.indicator.values[i].value);
      
      //Añadimos los datos a la variable body
      body += `<tr><td>${data.indicator.values[i].datetime.substring(11,19)}</td><td>${data.indicator.values[i].value}</td></tr>`;
      datosGrafico.push(data.indicator.values[i].value);
    }

    //Mostramos la variable body en la página
    document.getElementById('prueba').innerHTML = fecha;
    document.getElementById('datos').innerHTML = body;

    //Gráfica
    var ctx = document.getElementById("myChart").getContext("2d");
    var m = Math.min.apply(null, datosGrafico);
    console.log(m)

    var myChart = new Chart(ctx, {
      type: "line",
      data: {
        labels: ["00:00","01:00","02:00","03:00","04:00","05:00","06:00",
                 "07:00","08:00","09:00","10:00","11:00","12:00","13:00",
                 "14:00","15:00","16:00","17:00","18:00","19:00","20:00",
                 "21:00","22:00","23:00"],
        datasets: [
          {
            label: "Precio por horas",
            data: datosGrafico,
            backgroundColor: "rgba(153,205,1,0.6)",
          },
        ],
      },  
    });    
  })
  .catch(err => alert("Error en el acceso a los datos"));
  })