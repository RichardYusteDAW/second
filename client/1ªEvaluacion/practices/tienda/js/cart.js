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
        let foundArticle = this.articles.find(a => a.id === article.id)

        if (foundArticle)
            foundArticle.units++;
        else
            this.articles.push(article)

    }

    delete(id) {
        const index = this.articles.findIndex((a) => a.id === id);

        if (index !== -1) {
            this.articles.splice(index, 1);
        }
    }

    update(id, n) {
        let article = this.articles.find(article => article.id === id);
        if (article) article.units += n;
    }

    show() {

    }
}