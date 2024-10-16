class Cart {

    // atributes
    id;
    articles;

    // constructor
    constructor(id) {
        this.id = id;
        this.articles = [];
    }

    // methods
    add(article) {
        const { code, name, description, price } = article;
        let foundArticle = this.articles.find(a => a.code === code)

        if (foundArticle)
            this.update(code, 1);
        else
            this.articles.push({
                code,
                name,
                description,
                price,
                units: 1,
                total: price
            });
    }

    delete(code) {
        const index = this.articles.findIndex((a) => a.code === code);

        if (index !== -1) {
            this.articles.splice(index, 1);
            this.show();
        }
    }

    update(code, n) {
        let article = this.articles.find(article => article.code === code);
        if (article) {
            article.units += n;
            if (article.units < 1) {
                this.delete(code);
            } else {
                article.total = article.price * article.units
            }
            this.show();
        }
    }

    show() {
        const dialog = document.getElementById("miDialogo");
        const dialogContent = document.getElementById("dialogContent");

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
        this.articles.forEach(a => {
            content += `<tr>
                            <td><img src="assets/${a.code}.jpg" alt="${a.name}" style="width: 100px;"></td>
                            <td>${a.name}</td>
                            <td>${a.description}</td>
                            <td>${a.price}€</td>
                            <td>${a.units}</td>
                            <td>${a.total}€</td>
                            <td>
                                <button class="btn btn-primary" onclick="cart.update('${a.code}',1)">+</button>
                                <button class="btn btn-warning" onclick="cart.update('${a.code}',-1)">-</button>
                                <button class="btn btn-danger" onclick="cart.delete('${a.code}')">Delete</button>
                            </td>
                        </tr>`
        });
        content += "</table>";

        dialogContent.innerHTML = content;

        dialog.showModal();
    }
}