/********** DOM ELEMENTS *********/
let lista = document.getElementById('lista')
let fotopizza = document.getElementById('fotopizza')
let ingredientes = document.getElementById('ingredientes')
let importe = document.getElementById('importe')


/********** FUNCTIONS *********/
const createSelect = () => {
    pizzas.forEach(pizza => {
        let option = document.createElement('option');
        option.id = pizza.codigo;
        option.value = pizza.codigo;
        option.textContent = pizza.nombre;
        lista.appendChild(option);
    });
}

const calculateTotal = (codigo) => {
    let total = 0;
    if (codigo != 'P0') {
        total = 5;
    }
    let selectedPizza = pizzas.find(p => p.codigo === codigo);
    selectedPizza.ingredientes.forEach(i => total += Number(i.precio));
    importe.textContent = "Importe: " + total + " €";
}

const loadImg = (codigo) => {

    const img = document.querySelector('img');
    if (img) {
        fotopizza.removeChild(img);
    }
    if (codigo != 'P0') {
        let pizza = document.createElement('img');
        pizza.src = `img/${codigo}.jpg`;
        fotopizza.appendChild(pizza);
    }
}

const loadIngredients = (codigo) => {
    const lis = document.querySelectorAll('li');
    if (lis) {
        lis.forEach(li => ingredientes.removeChild(li));
    }

    let selectedPizza = pizzas.find(p => p.codigo === codigo);
    selectedPizza.ingredientes.forEach(i => {
        let li = document.createElement('li');
        li.textContent = i.ingrediente;
        ingredientes.appendChild(li);
    });
}

/********** LISTENERS *********/
createSelect();
calculateTotal('P0');
lista.addEventListener('change', (e) => {
    const codigo = e.target.value;
    calculateTotal(codigo);
    loadImg(codigo);
    loadIngredients(codigo);
});

