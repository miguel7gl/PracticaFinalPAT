//Boton Buscar
let button= document.getElementById('submit');

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
    }

    //Mostramos la variable body en la página
    document.getElementById('prueba').innerHTML = fecha;
    document.getElementById('datos').innerHTML = body;
    
  })
  .catch(err => alert("Error en el acceso a los datos"));
  })