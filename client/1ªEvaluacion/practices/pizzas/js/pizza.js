/********** DOM ELEMENTS **********/
let select;
let fotopizza;
let ingredientes;
let importe;


/********** WINDOW / ONLOAD **********/
window.onload = () => {

    // DOM Elements
    select = document.getElementById("lista");
    fotopizza = document.getElementById("fotopizza");
    ingredientes = document.getElementById("ingredientes");
    importe = document.getElementById("importe");

    // Methods
    printSelect();

    // Listeners
    select.addEventListener("change", () => {
        if (select.value != 'P0') {
            fotopizza.innerHTML = `<img src="../img/${select.value}.jpg" alt="pizza">`;
        }
    });
}


/********** METHODS **********/
const printSelect = () => {
    let options = "";
    pizzas.forEach(p => {
        options += `<option value="${p.codigo}">${p.nombre}</option>`;
    });
}