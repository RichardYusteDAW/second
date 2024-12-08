/********** DOM ELEMENTS **********/
const cart = new Cart(1);

const criteriosOrdenacion = document.getElementById("criteriosOrdenacion");
const cartImg = document.getElementById("cart");
const contenedor = document.getElementById("contenedor");
const miDialogo = document.getElementById("miDialogo");
const dialogContent = document.getElementById("dialogContent");
const total = document.getElementById("total");
const btnCierraDialog = document.getElementById("btnCierraDialog");
const btnEfectuaPedido = document.getElementById("btnEfectuaPedido");



/********** FUNCTIONS **********/
// -----SELECT-----
const createSelect = () => {
    const criteria = ["Sin ordenar", "Ascendente por precio", "Descendente por precio"]
    let content = "";
    for (let i = 0; i < criteria.length; i++) {
        content += `<option value="${i}">${criteria[i]}</option>`;
    }

    return content;
}

const showSelect = () => {
    criteriosOrdenacion.innerHTML = createSelect();
}

// ------CART------
const createCart = (cart) => {
    let content = `<table class='table'>
                           <tr>
                               <th></th>
                               <th>Nombre</th>
                               <th>Descripción</th>
                               <th>Precio</th>
                               <th>Unidades</th>
                               <th>Total</th>
                               <th></th>
                           </tr>`;
    cart.articles.forEach(a => {
        content += `<tr>
        <td><img src="assets/${a.code}.jpg" alt="${a.name}" style="width: 100px;"></td>
        <td>${a.name}</td>
        <td>${a.description}</td>
        <td>${a.price}€</td>
        <td>${a.units}</td>
        <td>${a.total}€</td>
        <td>
            <button class="btn btn-primary" onclick="modificaUnidades('${a.code}',1)">+</button>
            <button class="btn btn-warning" onclick="modificaUnidades('${a.code}',-1)">-</button>
            <button class="btn btn-danger" onclick="borraArticulo('${a.code}')">Delete</button>
        </td>
    </tr>`
    });
    content += "</table>";
    return content;
}

const showCart = (cart) => {
    const dialogContent = document.getElementById("dialogContent");
    const total = document.getElementById("total");
    dialogContent.innerHTML = createCart(cart);
    total.innerHTML = cart.getTotal();
    miDialogo.showModal();
}

const modificaUnidades = (code, units) => {
    cart.modificaUnidades(code, units);
    showCart(cart);
}
const borraArticulo = (code) => {
    cart.borraArticulo(code);
    showCart(cart);
}


// -----ARTICLES-----
const createArticle = (article) => {
    return `<div class="col">
                <div class="card" style="display: flex;">
                    <img src="assets/${article.code}.jpg" class="card-img-top" alt="${article.name}"></img>
                    <div class="card-body">
                        <h5 class="card-title">${article.name}</h5>
                        <p class="card-text">${article.description}</p>
                        <p class="card-text text-center"><b>${article.price}€</b></p>
                    </div>
                    <button value="${article.code}" class="btn btn-success comprar">Comprar</button>
                </div>
            </div>`;
}

const showArticles = (order) => {
    let listaArticulosCopy = listaArticulos.slice();
    if (order == "1") {
        listaArticulosCopy.sort((a, b) => a.price - b.price);
    } else if (order == "2") {
        listaArticulosCopy.sort((a, b) => b.price - a.price);
    }

    let content = "";
    listaArticulosCopy.forEach(art => {
        content += createArticle(art)
    })
    contenedor.innerHTML = content;

    // Listeners
    const buttons = document.querySelectorAll(".comprar");
    buttons.forEach(button => {
        button.addEventListener("click", (event) => {
            const art = listaArticulos.find(art => art.code == event.target.value)
            cart.anyadeArticulo(art);
            showCart(cart);
        })
    })
}


/********** EVENT LISTENERS **********/
showSelect();
showArticles();

criteriosOrdenacion.addEventListener("change", (event) => {
    showArticles(event.target.value);
})

cartImg.addEventListener("click", () => {
    showCart(cart);
})

btnCierraDialog.addEventListener("click", () => {
    miDialogo.close();
})