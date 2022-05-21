//Boton Buscar
// let buttonActual= document.getElementById('submitActual');

const getTodosElectrodomesticos = async () => {
    let base64 = "QW5hIFRydWppbGxvOjI=";

    let url = 'http://localhost:8080/api/v1/electroPrecioJoin';

    // let headers = new Headers();

    // headers.append('Authorization', base64);

    fetch(url , {
        method:'GET', 
        // headers: new Headers({
        //     'Authorization': 'Basic '+btoa('Ana Trujillo:2'),
        // })
        // mode: 'cors',
        // cache: 'default',
        // credentials: 'include',
    })
    .then(response => response.json())
    .then(data => {
        console.log(data);
    })
}


// buttonActual.addEventListener('click', function(name){

//   //url al que haremos fetch
//   const urlElectroPrecioJoin = "http://localhost:8080/api/v1/electroPrecioJoin"

//   fetch(urlElectroPrecioJoin, {method: "GET"})
//   .then(response => response.json())
//   .then(data => {

//     console.log(data);

//     //Creamos una variable body donde almacenamos los datos
//     let body = '';

//     for(i=0; i<data.length; i++)
//     {      
//       //Imprimimos los datos en consola para comprobar que son cogidos correctamente
//       console.log(data.indicator.values[i].datetime.substring(0,10)+" ("+data.indicator.values[i].datetime.substring(11,16)+"): "+data.indicator.values[i].value);
      
//       //Anadimos los datos a la variable body
//       body += `<tr><td>${data.indicator.values[i].datetime.substring(11,16)}</td><td>${data.indicator.values[i].value}</td><td>${(data.indicator.values[i].value/10).toFixed(2)}</td></tr>`;
//     }

//     document.getElementById('datos').innerHTML = body;
//   })
//   .catch(() => alert("Error en el acceso a los datos"));
// });
