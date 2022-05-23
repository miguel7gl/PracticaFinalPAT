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
              idActual=data3[i].customerId;      //OBTENEMOS EL ID DEL USUARIO
            }
            
          }

          //POST ELECTRO
          const urlElectro = "http://localhost:8080/api/v1/electro-post"

          let electroTipo=document.getElementById('electroTipo').value;
          let tiempoUso=document.getElementById('tiempoUso').value;

          let electro={
            electroTipo: electroTipo,
            customerId: idActual,
            tiempoUso: tiempoUso
          };         
          
          console.log (electro);


          fetch(urlElectro, {
            method: "POST",
            credentials:"same-origin", 
            headers:{
                'Content-Type':"application/json"
            },
            body:JSON.stringify(electro),
        }).catch(e=>
            console.log(e));
          
          if (request2.status===200){
            console.log("EXITO :)")
          }

          
          const urlPrecio = "http://localhost:8080/api/v1/precio-post"

          let consumoMediaHora=document.getElementById('consumoMediaHora').value;
          let precioConsumo=document.getElementById('precioConsumo').value;

          let precios={
            consumoMediaHora: consumoMediaHora,
            precioConsumo: precioConsumo
          };   
          
          console.log (precio);


          fetch(urlPrecio, {
            method: "POST",
            credentials:"same-origin", 
            headers:{
                'Content-Type':"application/json"
            },
            body:JSON.stringify(precios),
        }).catch(e=>
            console.log(e));
          
          if (request2.status===200){
            console.log("EXITO :)")
          }

          const urlInfo = "http://localhost:8080/api/v1/info-post"

          let marca=document.getElementById('marca').value;
          let eficiencia=document.getElementById('eficiencia').value;

          let info={
            marca: marca,
            eficiencia: eficiencia
          };          

          console.log (info);

          fetch(urlInfo, {
            method: "POST",
            credentials:"same-origin", 
            headers:{
                'Content-Type':"application/json"
            },
            body:JSON.stringify(info),
        }).catch(e=>
            console.log(e));
          
          if (request2.status===200){
            console.log("EXITO :)")
          }
          

        
    })
  //.catch(() => alert("Error en el acceso a los datos"));
})
});
