const postCustomer=async()=>{
  //let id=document.getElementById('id').value;
  let nombre=document.getElementById('customerName').value;
  let pais=document.getElementById('country').value

 //console.log(id);
 console.log(nombre);
 console.log(pais);
 var data={
   customerName: nombre,
   country: pais
 };
 console.log(data);

 let request2= await fetch("/api/v1/customers",{
   method:'POST',
   credentials:"same-origin",
   mode:"same-origin",

   headers:{
     'Content-Type':"application/json"
   },
   body:JSON.stringify({
     customerName: nombre,
     country: pais
   }),
   dataType:"json"
 }).catch(e=>
   console.log(e));
 
 if (request2.status===200){
   console.log("EXITO :)")
 }
 
}

let elementBoton3=document.getElementById('post');
elementBoton3.addEventListener("click",postCustomer);