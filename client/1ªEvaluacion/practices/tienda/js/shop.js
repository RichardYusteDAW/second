let cart;


/******************WINDOW/ONLOAD******************/
window.onload = () => {
    // 1º Create cart
    cart = new Cart();

    // 2º Show articles
    displayArticles();

    // 3º Insert options in select
    createCriteriaList();

    // 4º DOM Elements
    const cartImg = document.getElementById("cart");
    const dialog = document.getElementById("miDialogo");
    const btnCierraDialog = document.getElementById("btnCierraDialog");
    const btnEfectuaPedido = document.getElementById("btnEfectuaPedido");

    // 5º Listeners
    cartImg.addEventListener("click", viewCart)
    btnCierraDialog.addEventListener("click", () => dialog.close())
    btnEfectuaPedido.addEventListener("click", placeOrder)
}


/******************METHODS/******************/
const createCriteriaList = () => {
    const criteria = ["Sin ordenar", "Ascendente por precio", "Descendente por precio"]
    const select = document.getElementById("criteriosOrdenacion");
    let options = ""
    for (let i = 0; i < criteria.length; i++) {
        options += `<option value="${i}">${criteria[i]}</option>`;
    }
    select.innerHTML = options;

    select.addEventListener("change", (event) => {
        displayArticles(event.target.value);
    })
}


const displayArticles = (order) => {
    const container = document.getElementById("contenedor");
    let articles = "";

    let copyListaArticulos = listaArticulos.slice();

    if (order === "1") {
        copyListaArticulos.sort((a, b) => a.price - b.price)
    } else if (order === "2") {
        copyListaArticulos.sort((a, b) => b.price - a.price)
    }

    copyListaArticulos.forEach(a => {
        articles += `<div class="col">
                        <div class="card" style="display: flex;">
                            <img src="assets/${a.code}.jpg" class="card-img-top" alt="${a.name}">
                            <div class="card-body">
                            <h5 class="card-title">${a.name}</h5>
                            <p class="card-text">${a.description}</p>
                            <p class="card-text text-center"><b>${a.price}€</b></p>
                            </div>
                            <button value="${a.code}" class="btn btn-success">Comprar</button>
                        </div>
                    </div>`
    });
    container.innerHTML = articles;

    const buttons = document.querySelectorAll(".btn-success");
    buttons.forEach(b => {
        b.addEventListener("click", () => {
            addArticleToCart(b.value);
        })
    })
}


const addArticleToCart = (code) => {
    const article = listaArticulos.find(a => a.code === code);
    if (article) cart.add(article);
}


const viewCart = () => {
    if (cart.getTotalArticles() === 0) {
        alert("El carrito está vacío")
        return;
    }

    cart.show();
}


const placeOrder = () => {
    console.log(JSON.stringify(cart.articles))
}