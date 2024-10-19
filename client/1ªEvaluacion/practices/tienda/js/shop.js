let cart;
let dialog;


/******************WINDOW/ONLOAD******************/
window.onload = () => {
    // 1º Create cart
    cart = new Cart(1);

    // 2º Show articles
    displayArticles();

    // 3º Insert options in select
    createCriteriaList();

    // 4º DOM Elements
    const cartImg = document.getElementById("cart");
    dialog = document.getElementById("miDialogo");
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
        displayArticles2(event.target.value);
    })
}


const displayArticles = (order) => {

    let copyListaArticulos = listaArticulos.slice();
    if (order === "1") {
        copyListaArticulos.sort((a, b) => a.price - b.price)
    } else if (order === "2") {
        copyListaArticulos.sort((a, b) => b.price - a.price)
    }

    let articles = "";
    copyListaArticulos.forEach(a => {
        articles += `
            <div class="col">
                <div class="card" style="display: flex;">
                    <img src="assets/${a.code}.jpg" class="card-img-top" alt="${a.name}"></img>
                    <div class="card-body">
                        <h5 class="card-title">${a.name}</h5>
                        <p class="card-text">${a.description}</p>
                        <p class="card-text text-center"><b>${a.price}€</b></p>
                    </div>
                    <button value="${a.code}" class="btn btn-success">Comprar</button>
                </div>
            </div>`
    });
    const container = document.getElementById("contenedor");
    container.innerHTML = articles;

    const buttons = document.querySelectorAll(".btn-success");
    buttons.forEach(b => {
        b.addEventListener("click", () => {
            addArticleToCart(b.value);
        })
    })
}

// Display with appendChild
const displayArticles2 = (order) => {

    let copyListaArticulos = listaArticulos.slice();
    if (order === "1") {
        copyListaArticulos.sort((a, b) => a.price - b.price)
    } else if (order === "2") {
        copyListaArticulos.sort((a, b) => b.price - a.price)
    }

    copyListaArticulos.forEach(a => {

        const colDiv = document.createElement('div');
        colDiv.className = 'col';

        const cardDiv = document.createElement('div');
        cardDiv.style.display = 'flex';

        const img = document.createElement('img');
        img.src = `assets/${a.code}.jpg`;
        img.className = 'card-img-top';
        img.alt = `${a.name}`;

        const cardBodyDiv = document.createElement('div');
        cardBodyDiv.className = 'card-body';

        const titleH5 = document.createElement('h5');
        titleH5.className = 'card-title';
        titleH5.textContent = a.name;


        const descP = document.createElement('p');
        descP.className = 'card-text';
        descP.textContent = a.description;

        const priceP = document.createElement('p');
        priceP.className = 'card-text text-center';
        priceP.textContent = `${a.price}€`;

        const button = document.createElement('button');
        button.className = 'btn btn-success';
        button.textContent = 'Comprar';
        button.onclick = `addArticleToCart(${a.code})`;

        // Appends:
        cardBodyDiv.appendChild(titleH5);
        cardBodyDiv.appendChild(descP);
        cardBodyDiv.appendChild(priceP);

        cardDiv.appendChild(img);
        cardDiv.appendChild(cardBodyDiv);
        cardDiv.appendChild(button);

        colDiv.appendChild(cardDiv);
    });
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
    const order = {
        "id": cart.id,
        "articles": cart.articles,
        "total": cart.getTotal()
    }
    console.log(order);
    dialog.close();
}