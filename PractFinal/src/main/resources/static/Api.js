//Boton Buscar
let button= document.getElementById('submit');

let horasGrafico = []; //Horas para el grafico
let datosGrafico = []; //Precios para el grafico
let colorBarras = []; //Colores para el grafico

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

    //Creamos una variable body donde almacenamos los datos
    let body = '';

    for(i=0; i<data.indicator.values.length; i+=5)
    {      
      //Imprimimos los datos en consola para comprobar que son cogidos correctamente
      console.log(data.indicator.values[i].datetime.substring(0,10)+" ("+data.indicator.values[i].datetime.substring(11,19)+"): "+data.indicator.values[i].value);
      
      //Añadimos los datos a la variable body
      body += `<tr><td>${data.indicator.values[i].datetime.substring(11,19)}</td><td>${data.indicator.values[i].value}</td></tr>`;
      
      datosGrafico.push(data.indicator.values[i].value); //Array con todos los precios para hacer la grafica
      horasGrafico.push(data.indicator.values[i].datetime.substring(11,16)); //Array con todas las horas
    }

    //Mostramos la variable body en la página
    document.getElementById('prueba').innerHTML = fecha;
    document.getElementById('datos').innerHTML = body;

    //Gráfica
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
    });    
  })
  .catch(err => alert("Error en el acceso a los datos"));
  })

