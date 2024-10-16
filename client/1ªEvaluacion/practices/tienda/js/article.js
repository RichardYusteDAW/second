class Article {
    id;
    name;
    description;
    price;
    units;
    total;

    constructor(id, name, description, price, units) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.units = units;
        this.total = price * units;
    }
}