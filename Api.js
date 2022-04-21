//Boton Buscar
let button= document.getElementById('submit');


//URLs para la búsqueda de datos
const cors = 'https://cors-anywhere.herokuapp.com/';
const urlPrecios = 'https://api.esios.ree.es/indicators/';
const url2 = "https://api.esios.ree.es/archives?date=2015-09-15T23:59:59+00:00";
const token = "67ff456a8376fbbb16a69c06b925535675ccc05b153c04f28219a66013a810c5";

const url = 'https://api.esios.ree.es/indicators/1001'
const hdrs = {'mode': 'no-cors', 'Accept':'application/json; application/vnd.esios-api-v2+json','Content-Type':'application/json','Host':'api.esios.ree.es','Authorization':'Token token="67ff456a8376fbbb16a69c06b925535675ccc05b153c04f28219a66013a810c5"'}

//const urlprueba = "https://api.esios.ree.es/indicators/1001?start_date=01-01-2014T00:00:00+02:00&end_date=01-01-2014T23:50:00+02:00&geo_agg=sum&geo_ids&time_trunc=hour&time_agg=&locale=es";
const urlintervalo = "https://api.esios.ree.es/indicators/1001?start_date=21-04-2022T00:00:00+02:00&end_date=21-04-2022T23:50:00+02:00";

//Definimos lo que hace el boton cuando es pulsado
button.addEventListener('click', function(name){
  fetch(urlintervalo, {method: "GET", headers: hdrs})
  .then(response => response.json())
  .then(data => {

    console.log(data);

    //Creamos una variable body donde almacenamos los datos
    let body = '';
    let horasGrafico = []; //Horas para el grafico
    let datosGrafico = []; //Precios para el grafico
    let colorBarras = []; //Colores para el grafico

    //Variable que almacena la fecha actual
    let fecha = data.indicator.values[0].datetime.substring(0,10);

    for(i=0; i<data.indicator.values.length; i+=5)
    {      
      //Imprimimos los datos en consola para comprobar que son cogidos correctamente
      console.log(data.indicator.values[i].datetime.substring(0,10)+" ("+data.indicator.values[i].datetime.substring(11,16)+"): "+data.indicator.values[i].value);
      
      //Anadimos los datos a la variable body
      body += `<tr><td>${data.indicator.values[i].datetime.substring(11,16)}</td><td>${data.indicator.values[i].value}</td><td>${(data.indicator.values[i].value/10).toFixed(2)}</td></tr>`;
      
      datosGrafico.push(data.indicator.values[i].value); //Array con todos los precios para hacer la grafica
      horasGrafico.push(data.indicator.values[i].datetime.substring(0,10)+": "+data.indicator.values[i].datetime.substring(11,16)); //Array con todas las horas
    }

    let sum = datosGrafico.reduce((previous, current) => current += previous);
    let mediaDatos = sum / datosGrafico.length;

    let mediaDatosGrafico = [];
    for(i=0; i<datosGrafico.length; i++)
    {
      mediaDatosGrafico.push(mediaDatos);
    }

    //Mostramos la variable body en la página
    document.getElementById('prueba').innerHTML = fecha;
    document.getElementById('datos').innerHTML = body;

    //Grafica
    let ctx = document.getElementById("myChart").getContext("2d");
    
    //Obtenemos el dato minimo y su indice
    let datoMin = Math.min.apply(null, datosGrafico);
    let indexMin = datosGrafico.indexOf(datoMin);

    //Obtenemos el vlor maximo y su indice
    let datoMax = Math.max.apply(null, datosGrafico);
    let indexMax = datosGrafico.indexOf(datoMax);

    //Creamos un array con los colores de las barras:
    //  - Si coincide con el indice minimo se pone en verde
    //  - Si coincide con el indice maximo se pone en rojo
    //  - Si no coincide con ninguno se pone de amarillo
    for(i=0; i<data.indicator.values.length; i++)
    {
      if(i==indexMin)
      {
        colorBarras.push("rgba(112, 255, 51,0.6)");
      }
      else if(i==indexMax)
      {
        colorBarras.push("rgba(255, 87, 51,0.6)");
      }
      else
      {
        colorBarras.push("rgba(255, 195, 0,0.6)");
      }
    }

    
    //Aqui creamos la grafica
    let myChart = new Chart(ctx, {
      type: "bar",
      data: {
        labels: horasGrafico,
        datasets: [
          {
            label: "Precio por horas",
            data: datosGrafico,
           backgroundColor: colorBarras
          },
        ],
      },
      options: {
        scales: {
            xAxes: [{
                ticks: {
                    autoSkip: false,
                    maxRotation: 90,
                    minRotation: 90
                }
            }]
        }
    }  
    }); 

  })
  .catch(() => alert("Error en el acceso a los datos"));
  })

