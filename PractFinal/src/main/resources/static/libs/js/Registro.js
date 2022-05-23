const postCustomer=async()=>{
 
  let customerName=document.getElementById('customerName').value;
  let password=document.getElementById('password').value;

  let calle=document.getElementById('calle').value
  let numPiso=document.getElementById('numPiso').value
  let ciudad=document.getElementById('ciudad').value
  let provincia=document.getElementById('provincia').value
  let codigoPostal=document.getElementById('codigoPostal').value
  let pais=document.getElementById('pais').value

 //console.log(id);
 console.log(customerName);
 console.log(password);

 console.log(calle);
 console.log(numPiso);
 console.log(ciudad);
 console.log(provincia);
 console.log(codigoPostal);
 console.log(pais);

 var data={
   customerName: customerName,
   password: password,
   calle:calle,
   numPiso:numPiso,
   ciudad:ciudad,
   provincia:provincia,
   codigoPostal:codigoPostal,
   pais:pais
 };
 console.log(data);

 let request2= await fetch("/api/v1/customers-post",{
   method:'POST',
   credentials:"same-origin",
   mode:"same-origin",

   headers:{
     'Content-Type':"application/json"
   },
   body:JSON.stringify(data
   ),
   dataType:"json"
 }).catch(e=>
   console.log(e));
 
 if (request2.status===200){
   console.log("EXITO :)")
 }
 
}

let elementBoton3=document.getElementById('post');
elementBoton3.addEventListener("click",postCustomer);