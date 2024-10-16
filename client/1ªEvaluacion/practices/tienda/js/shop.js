const criteria = ["Sin ordenar", "Ascendente por precio", "Descendente por precio"]
let cart;

const createCriteriaList = () => {
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
        copyListaArticulos.sort((a, b) => a.precio - b.precio)
    } else if (order === "2") {
        copyListaArticulos.sort((a, b) => b.precio - a.precio)
    }

    copyListaArticulos.forEach(a => {
        articles += `<div class="col">
                        <div class="card" style="display: flex;">
                            <img src="assets/${a.codigo}.jpg" class="card-img-top" alt="${a.nombre}">
                            <div class="card-body">
                            <h5 class="card-title">${a.nombre}</h5>
                            <p class="card-text">${a.description}</p>
                            <p class="card-text text-center"><b>${a.precio}€</b></p>
                            </div>
                            <button id="m1" class="btn btn-success">Comprar</button>
                        </div>
                    </div>`
    });
    container.innerHTML = articles;
}


const addArticleToCart = () => {

}


const viewCart = () => {
    cart.show();
}

const placeOrder = () => {

}

window.onload = () => {
    cart = new Cart();
    displayArticles();
    createCriteriaList();

    const cartImg = document.getElementById("cart");
    cartImg.addEventListener("click", viewCart)
}