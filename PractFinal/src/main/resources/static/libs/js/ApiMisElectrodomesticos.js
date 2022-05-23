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

  let url = 'http://localhost:8080/api/v1/datos';

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

            for(i=0; i<data2.length; i++)
            {      
              if (idActual == data2[i].customerId) {
                  //Imprimimos los datos en consola para comprobar que son cogidos correctamente
                  console.log("Consumo: "+data2[i].consumo+" Customer id: "+data2[i].customerId+" ElectroId: "+data2[i].electroId+" ElectroTipo: "+data2[i].electroTipo+" PrecioConsumo: "+data2[i].precioConsumo+" TiempoUso: "+data2[i].tiempoUso);
                  
                  //Anadimos los datos a la variable body
                  body += `<tr><td>${data2[i].customerId}</td><td>${data2[i].electroTipo}</td><td>${data2[i].electroId}</td><td>${data2[i].tiempoUso}</td><td>${data2[i].consumo}</td><td>${data2[i].precioConsumo}</td></tr>`;

                  if (body==null){alert("Usted no tiene ningún electrodoméstico")}
              }
            }

            document.getElementById('datos').innerHTML = body;
          })
        })
    })
  .catch(() => alert("Error en el acceso a los datos"));
});
