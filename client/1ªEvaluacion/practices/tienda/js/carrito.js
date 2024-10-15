class carrito {

    // atributos
    id;
    articulos = [];

    // constructor
    constructor(id) {
        this.id = id;
    }

    // methods
    add(articulo) {
        this.articulos.push(articulo)
    }

    delete(id) {
        const index = this.articulos.findIndex((a) => a.id === id);

        if (index !== -1) {
            this.articulos.splice(index, 1);
        }
    }

    update(id, units) {
        const articulo = this.articulos.find(articulo => articulo.id === id);
        if (articulo) articulo.units = units;
    }

    show() { }

}