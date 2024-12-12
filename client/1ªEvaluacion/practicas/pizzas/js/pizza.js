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
}


/********** METHODS **********/
const printSelect1 = () => {
    let options = "";
    pizzas.forEach(p => {
        options += `<option value="${p.codigo}">${p.nombre}</option>`;
    });
    select.innerHTML = options;
}

const printSelect = () => {
    pizzas.forEach((p) => {
        let option = document.createElement("option");
        option.value = p.codigo;
        option.text = p.nombre;
        select.appendChild(option);
    });
    select.addEventListener("change", () => {
        if (select.value === 'P0') {
            fotopizza.innerHTML = "";
        } else {
            fotopizza.innerHTML = `<img src="../img/${select.value}.jpg" alt="pizza">`;
        }
        printImport(select.value);
        printIngredients(select.value);
    });
}

const printImport = (codigo) => {
    let total = 0;
    if (select.value !== 'P0') {
        const pizza = pizzas.find(pizza => pizza.codigo == codigo);
        total = pizza.ingredientes.reduce((acc, ingrediente) => acc + Number(ingrediente.precio), 5);
    }

    importe.innerHTML = `Importe: ${total}`;
}

const printIngredients = (codigo) => {
    ingredientes.innerHTML = "";

    if (select.value !== 'P0') {
        const pizza = pizzas.find(pizza => pizza.codigo == codigo);
        let content = "<ul>";
        pizza.ingredientes.forEach((i) => {
            content += `<li>${i.ingrediente}</li>`;
        })
        content += "</ul>";
        ingredientes.innerHTML = content;
    }
}