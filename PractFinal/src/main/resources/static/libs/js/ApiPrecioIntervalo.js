//FUNCIONAMIENTO DE LA BUSQUEDA DE DATOS

//Boton Buscar
let buttonIntervalo= document.getElementById('submitIntervalo');


//Creamos el grafico vacio
let ctx = document.getElementById("myChartIntervalo").getContext("2d");
      
const graficoEjes = {
  labels: [],
  datasets: [{
    type: 'bar',
    label: 'Precio por horas',
    data: [],
    borderColor: 'rgb(255, 99, 132)',
    backgroundColor: ''
  }, {
    type: 'line',
    label: 'Precio medio',
    data: [],
    fill: false,
    borderColor: 'rgb(54, 162, 235)'
  }]
};

let myChart = new Chart(ctx, {
  type: "bar",
  data: graficoEjes,
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


//Token necesario para la aplicacion
const token = "67ff456a8376fbbb16a69c06b925535675ccc05b153c04f28219a66013a810c5";

//Variable que almacena los headers necesarios para el fetch
const hdrs = {'mode': 'no-cors', 'Accept':'application/json; application/vnd.esios-api-v2+json','Content-Type':'application/json','Host':'api.esios.ree.es','Authorization':'Token token="67ff456a8376fbbb16a69c06b925535675ccc05b153c04f28219a66013a810c5"'}

//Obtenemos el día actual
let date = new Date();
let diaActual = String(date.getDate()).padStart(2, '0') + '-' + String(date.getMonth() + 1).padStart(2, '0') + '-' + date.getFullYear();


//Funcion que actualiza el grafico
function updateGrafico(label,data1,dataMedia,color) {
  myChart.data.datasets[0].data = data1;
  myChart.data.datasets[1].data = dataMedia;
  myChart.data.labels = label;
  myChart.data.datasets[0].backgroundColor = color;
  myChart.update();
}

//CUANDO PULSAS EL BOTON DE INTERVALO
buttonIntervalo.addEventListener('click', function(name){

    //Detectamos las fechas introducidas y creamos el url al que haremos fetch
    let fechaInicio = (document.getElementById('fechaInicio').value);
    let fechaFin = (document.getElementById('fechaFin').value);

    if (fechaInicio=="" || fechaFin=="")
    {
      fechaInicio = "";
      fechaFin = "";
    }

    const urlIntervalo = "https://api.esios.ree.es/indicators/1001?start_date="+fechaInicio+"T00:00:00+02:00&end_date="+fechaFin+"T23:50:00+02:00";

    fetch(urlIntervalo, {method: "GET", headers: hdrs})
    .then(response => response.json())
    .then(data => {
  
      console.log(urlIntervalo);

      console.log(data);
  
      //Creamos una variable body donde almacenamos los datos
      let body = '';
      let horasGrafico = []; //Horas para el grafico
      let datosGrafico = []; //Precios para el grafico
      let colorBarras = []; //Colores para el grafico
  
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
      let mediaDatos = (sum / datosGrafico.length).toFixed(2);
  
      let mediaDatosGrafico = [];
      for(i=0; i<datosGrafico.length; i++)
      {
        mediaDatosGrafico.push(mediaDatos);
      }
  
      //Mostramos la variable body en la página
      document.getElementById('datos').innerHTML = body;
  
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

      //Actualizamos grafico con los nuevos datos
      updateGrafico(horasGrafico,datosGrafico,mediaDatosGrafico,colorBarras);       
    })
    .catch(() => alert("Error en el acceso a los datos"));
    })