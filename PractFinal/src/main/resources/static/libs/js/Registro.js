let elementBoton3=document.getElementById('post');
//elementBoton3.addEventListener("click",postCustomer);
//elementBoton3.addEventListener("click",postDomicilio);


//Put Usuario

elementBoton3.addEventListener(
  "click",
  (putUsuario = async () => {
    let customerName=document.getElementById('customerName').value;
    let contrasena=document.getElementById('password').value;

    let user={
      customerName: customerName,
      contrasena: contrasena
    };

    console.log(customerName);
    console.log(contrasena);
    console.log(user);

    let request2= await fetch("/api/v1/customers-post",{
      method:'POST',
      credentials:"same-origin", 
      headers:{
        'Content-Type':"application/json"
      },
      body:JSON.stringify(user),
      dataType:"json"
    }).catch(e=>
      console.log(e));
    
    if (request2.status===200){
      console.log("EXITO :)")
    }
  })
);


/*
elementBoton3.addEventListener(
  "click",
  (putUsuario = async () => {
    let calle=document.getElementById('calle').value
    let numPiso=document.getElementById('numPiso').value
    let ciudad=document.getElementById('ciudad').value
    let provincia=document.getElementById('provincia').value
    let codigoPostal=document.getElementById('codigoPostal').value
    let pais=document.getElementById('pais').value

    let domicilio = {
      calle:calle,
      numPiso:numPiso,
      provincia:provincia,
      ciudad:ciudad,
      codigoPostal:codigoPostal,
      pais:pais
    }

    let request2= await fetch("/api/v1/domicilios-post",{
      method:'POST',
      credentials:"same-origin",
      mode:"same-origin",
   
      headers:{
        'Content-Type':"application/json"
      },
      body:JSON.stringify(domicilio),
      dataType:"json"
    }).catch(e=>
      console.log(e));
    
    if (request2.status===200){
      console.log("EXITO :)")
    }
  })
);


/*

const postCustomer=async()=>{
 
  let customerName=document.getElementById('customerName').value;
  let contrasena=document.getElementById('password').value;

 //console.log(id);
 console.log(customerName);
 console.log(password);

 let request2= await fetch("/api/v1/customers-post",{
   method:'POST',
   credentials:"same-origin",
   mode:"same-origin",

   headers:{
     'Content-Type':"application/json"
   },
   body:JSON.stringify({
     customerName: customerName,
     contrasena: contrasena
   }),
   dataType:"json"
 }).catch(e=>
   console.log(e));
 
 if (request2.status===200){
   console.log("EXITO :)")
 }
 
}

const postDomicilio=async()=>{

  let calle=document.getElementById('calle').value
  let numPiso=document.getElementById('numPiso').value
  let ciudad=document.getElementById('ciudad').value
  let provincia=document.getElementById('provincia').value
  let codigoPostal=document.getElementById('codigopostal').value
  let pais=document.getElementById('pais').value

 //console.log(id);
 console.log(calle);
 console.log(numPiso);
 console.log(ciudad);
 console.log(provincia);
 console.log(codigoPostal);
 console.log(pais);

 let request3= await fetch("/api/v1/domicilios-post",{
   method:'POST',
   credentials:"same-origin",
   mode:"same-origin",

   headers:{
     'Content-Type':"application/json"
   },
   body:JSON.stringify({
      calle:calle,
      numPiso:numPiso,
      provincia:provincia,
      ciudad:ciudad,
      codigoPostal:codigoPostal,
      pais:pais
   }),
   dataType:"json"
 }).catch(e=>
   console.log(e));
 
 if (request3.status===200){
   console.log("EXITO :)")
 }
}
*/