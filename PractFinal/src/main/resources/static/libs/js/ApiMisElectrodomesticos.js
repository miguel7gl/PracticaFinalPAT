//Boton Buscar
let buttonActual= document.getElementById('submitActual');

const getMisElectrodomesticos = async () => {
    let url = 'http://localhost:8080/api/v1/datos';

    fetch(url , {
        method:'GET', 
    })
    .then(response => response.json())
    .then(data => {
        console.log(data);
        console.log(data.name);
    })
}


buttonActual.addEventListener('click', function(name){

  //url al que haremos fetch
  const urlElectroPrecioJoin = "http://localhost:8080/api/v1/electroPrecioJoin"

  fetch(urlElectroPrecioJoin, {method: "GET"})
  .then(response => response.json())
  .then(data => {

    console.log(data);

    //Creamos una variable body donde almacenamos los datos
    let body = '';

    for(i=0; i<data.length; i++)
    {      
        //Imprimimos los datos en consola para comprobar que son cogidos correctamente
        console.log("Consumo: "+data[i].consumo+" Customer id: "+data[i].customerId+" ElectroId: "+data[i].electroId+" ElectroTipo: "+data[i].electroTipo+" PrecioConsumo: "+data[i].precioConsumo+" TiempoUso: "+data[i].tiempoUso);
        
        //Anadimos los datos a la variable body
        body += `<tr><td>${data[i].consumo}</td><td>${data[i].customerId}</td><td>${data[i].electroId}</td><td>${data[i].electroTipo}</td><td>${data[i].precioConsumo}</td><td>${data[i].tiempoUso}</td></tr>`;
    }

    document.getElementById('datos').innerHTML = body;
  })
  .catch(() => alert("Error en el acceso a los datos"));
});
