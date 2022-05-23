//Boton Buscar
let buttonActual= document.getElementById('submitActual');


//VER EL USUARIO LOGGEADO



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

          console.log(data3[2].customerId);
          let body = '';

          for(i=0; i<data3.length; i++){
            if(data3[i].customerName == data.name){
              //idActual=data3[i].customerId;
              
              console.log(data3[i]);
              body += `<tr><td>${data3[i].customerName}</td><td>${(data3[i].password)}</td></tr>`;
              document.getElementById('datos').innerHTML = body;
            }
        }         
    })
//.catch(() => alert("Error en el acceso a los datos"));  
})


/*



//VER TODOS LOS USUARIOS


  
          const url2 = 'http://localhost:8080/api/v1/customers';
  
          fetch(url2 , {
            method:'GET', 
          })
          .then(response => response.json())
          .then(data3 => {
            //console.log(data3);
  
            //console.log(data3[2].customerId);
            let body = '';
  
            for(i=0; i<data3.length; i++){
              
                //idActual=data3[i].customerId;
                //document.getElementById('id').innerHTML = data3[i].customerId; 
                //document.getElementById('nombre').innerHTML = data3[i].customerName; 
                //document.getElementById('password').innerHTML = data3[i].password; 
                console.log(data3[i]);
                body += `<tr><td>${data3[i].customerId}</td><td>${data3[i].customerName}</td><td>${(data3[i].password)}</td></tr>`;
                
              
            } 
            document.getElementById('datos').innerHTML = body;
             
          })
      //.catch(() => alert("Error en el acceso a los datos"));  



*/
