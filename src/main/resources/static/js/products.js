let productos;
// Aquí se debe cambiar el URL del servicio en el BackEnd
const URL_MAIN ='/api/products/';
function addItems(div_Productos) {
    fetch(URL_MAIN, {
        method: 'get'
    }).then(function(response) {
        response.json().then(function (json) {
            console.log(json);
            console.log(json.length);
            productos=json;
            Array.from(json).forEach((p, index) => {
                div_Productos.innerHTML += `
                    <div class="col-md-4">
                    <div class="card mb-4 shadow-sm">
                        <img class="bd-placeholder-img card-img-top" role="img" src="/img/${p.url_image}" />
                        <div class="card-body">
                        <p class="card-text"><strong>${p.name}</strong></p>
                        <p class="card-text">${p.description}</p>
                        <div class="d-flex justify-content-between align-items-center">
                            <div class="btn-group">
                            <button type="button" class="btn btn-sm btn-outline-secondary" id="btnVer_${p.id}" onclick="view(${index});">Ver</button>
                            <button type="button" class="btn btn-sm btn-outline-secondary">Agregar</button>
                            </div>
                            <small class="text-muted">$ ${p.price} MXN</small>
                        </div>
                        </div>
                    </div>
                    </div>
                `;
            }); // foreach
        });//then
    }).catch(function(err) {
        console.log(err);
    });
    console.log(document.getElementById("div_Productos"));
   
}// addItems

window.addEventListener("load", function (){
    let div = document.getElementById("div_Productos");
    addItems(div);
   
});

function view(index) {
    // console.log(index);
    // console.table(productos[index]);
    document.getElementById("productTitleModal").innerHTML=productos[index].name;
    document.getElementById("productBodyModal").innerHTML=`${productos[index].description}  <img class="bd-placeholder-img card-img-top" role="img" src="/img/${productos[index].url_image}" />
    <strong>$ ${productos[index].price} MXN<strong>`;
    $("#productModal").modal("show");
}// view

/////// El siguiente código agrega un nuevo producto mediante un POST
// const data =     {nombre: "Cuaderno doble raya",
//     descripcion: "Cuaderno doble raya Norma",
//     precio: 56.0,
//     imagen: "cuadernodobleraya.jpg"
// };

// fetch(URL_MAIN, {
 //  method: 'POST', // or 'PUT'
 //  headers: {
 //    'Content-Type': 'application/json',
  // },
 //  body: JSON.stringify(data),
 //})
 //.then(response => response.json())
 //.then(data => {
 //  console.log('Success:', data);
 //})
 //.catch((error) => {
 //  console.error('Error:', error);
 //});
 