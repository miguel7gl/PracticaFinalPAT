//FUNCIONAMIENTO DE LA BUSQUEDA DE DATOS

//Boton Buscar
let buttonActual= document.getElementById('submitActual');

//Token necesario para la aplicacion
const token = "67ff456a8376fbbb16a69c06b925535675ccc05b153c04f28219a66013a810c5";

//Variable que almacena los headers necesarios para el fetch
const hdrs = {'mode': 'no-cors', 'Accept':'application/json; application/vnd.esios-api-v2+json','Content-Type':'application/json','Host':'api.esios.ree.es','Authorization':'Token token="67ff456a8376fbbb16a69c06b925535675ccc05b153c04f28219a66013a810c5"'}

//Obtenemos el día actual
let date = new Date();
console.log(date);

let diaActual = String(date.getDate()).padStart(2, '0') + '-' + String(date.getMonth() + 1).padStart(2, '0') + '-' + date.getFullYear();
let horaActual = String(date.getHours()+':00')

console.log(diaActual);
console.log(horaActual);

//CUANDO PULSAMOS EL BOTON DEL DIA ACTUAL
buttonActual.addEventListener('click', function(name){


  //CALCULAMOS EL PRECIO A LA HORA ELEGIDA
  let horaActual=document.getElementById('hora').value;

  //url al que haremos fetch
  const urlDiaActual = "https://api.esios.ree.es/indicators/1001?start_date="+diaActual+"T00:00:00+02:00&end_date="+diaActual+"T23:50:00+02:00"

  fetch(urlDiaActual, {method: "GET", headers: hdrs})
  .then(response => response.json())
  .then(data => {

    console.log(data);

    //Creamos una variable body donde almacenamos los datos
    let body = '';
    let horasGrafico = []; //Horas para el grafico
    let datosGrafico = []; //Precios para el grafico
    let colorBarras = []; //Colores para el grafico

    //Obtenemos el día actual
    let date = new Date();
    let output = String(date.getDate()).padStart(2, '0') + '-' + String(date.getMonth() + 1).padStart(2, '0') + '-' + date.getFullYear();
    console.log(output);

    //Variable que almacena la fecha actual
    let fecha = data.indicator.values[0].datetime.substring(0,10);
    let CosteHora;
    for(i=0; i<data.indicator.values.length; i+=5)
    {    
      //console.log('Hey');
      let hora = data.indicator.values[i].datetime.substring(11,16);
      //console.log(hora);
      if (hora==horaActual)
      {
        costeHora=(data.indicator.values[i].value/10).toFixed(2);
        console.log(costeHora);
        //Imprimimos los datos en consola para comprobar que son cogidos correctamente
        console.log(data.indicator.values[i].datetime.substring(0,10)+" ("+data.indicator.values[i].datetime.substring(11,16)+"): "+data.indicator.values[i].value);
      }
    }
  }
  
  //COGEMOS LOS ELECTRODOMESTICOS DE LA PERSONA LOGEADA
  )

  const url = 'http://localhost:8080/api/v1/datos';

    fetch(url , {
        method:'GET', 
    })
    .then(response => response.json())
    .then(data => {
        console.log(data);
        console.log(data.name); //data.name es el nombre del usuario

        const url2 = 'http://localhost:8080/api/v1/customers';

        fetch(url2 , {
          method:'GET', 
        })
        .then(response => response.json())
        .then(data3 => {
          console.log(data3);

          let idActual = null;

          for(i=0; i<data3.length; i++){
            if(data3[i].customerName == data.name){
              idActual=data3[i].customerId;
            }
            
          }

          //url al que haremos fetch
          const urlElectroPrecioJoin = "http://localhost:8080/api/v1/electroPrecioJoin"

          fetch(urlElectroPrecioJoin, {method: "GET"})
          .then(response2 => response2.json())
          .then(data2 => {

            //Creamos una variable body donde almacenamos los datos
            let body = '';
            let gasto;

            for(i=0; i<data2.length; i++)
            {      
              if (idActual == data2[i].customerId) {
                  //Imprimimos los datos en consola para comprobar que son cogidos correctamente
                  console.log("Consumo: "+data2[i].consumo+" Customer id: "+data2[i].customerId+" ElectroId: "+data2[i].electroId+" ElectroTipo: "+data2[i].electroTipo+" PrecioConsumo: "+data2[i].precioConsumo+" TiempoUso: "+data2[i].tiempoUso);
                  
                  gasto=(data2[i].tiempoUso*(data2[i].consumo/30))*costeHora;
                  console.log("Gasto: "+gasto);
                  console.log("Hora: "+horaActual);
                  console.log("CosteHora: "+costeHora);
              }
            }

            document.getElementById('datos').innerHTML = (gasto/100).toFixed(2)+" €";
          })
        })
    })
})

