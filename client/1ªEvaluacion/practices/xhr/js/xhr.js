/********** DOM ELEMENTS **********/
const btnGetAll = document.querySelector(".btn-primary");
const btnFindById = document.querySelector(".btn-dark");
const btnAdd = document.querySelector(".btn-success");
const btnUpdate = document.querySelector(".btn-secondary");
const btnDelete = document.querySelector(".btn-danger");
const main = document.querySelector("main");


/********** FUNCTIONS **********/
const URL = "http://localhost:3000/articulos";

const getAll = () => {
    const xhr = new XMLHttpRequest();
    xhr.open("GET", URL);
    xhr.responseType = "json";
    xhr.send();
    xhr.onload = () => {
        if (xhr.status === 200) {
            let articulos = xhr.response;
            let content = `<table class="table table-striped">
                                <tr>
                                    <th>ID</th>
                                    <th>NOMBRE</th>
                                    <th>PRECIO</th>
                                </tr>`;

            articulos.forEach(a => {
                content += `<tr>
                                <td>${a.id}</td>
                                <td>${a.nombre}</td>
                                <td>${a.precio}</td>
                            </tr>`;
            });
            content += '</table>';
            main.innerHTML = content;

        } else {
            console.error("Error: ", xhr.status);
        }
    }
    xhr.error = () => {
        console.error("Error: ", xhr.status);
    }
};

const findById = () => {
    const id = prompt("Dime el ID del articulo");
    const xhr = new XMLHttpRequest();
    xhr.open("GET", `${URL}/${id}`);
    xhr.responseType = "json";
    xhr.send();
    xhr.onload = () => {
        if (xhr.status === 200) {
            let articulo = xhr.response;
            let content = `<table class="table table-striped">
                                <tr>
                                    <th>ID</th>
                                    <th>NOMBRE</th>
                                    <th>PRECIO</th>
                                </tr>
                                <tr>
                                    <td>${articulo.id}</td>
                                    <td>${articulo.nombre}</td>
                                    <td>${articulo.precio}</td>
                                </tr>
                            </table>`;
            main.innerHTML = content;
        } else {
            main.innerHTML = `<div class="alert alert-danger" role="alert">
                                Articulo no encontrado
                            </div>`;
        }
    }
    xhr.error = () => {
        console.error("Error: ", xhr.status);
    }
};

const add = () => {
    event.preventDefault();
    const nombre = prompt("Dime el nombre del articulo");
    const precio = prompt("Dime el precio del articulo");
    const body = JSON.stringify({ nombre, precio });

    const xhr = new XMLHttpRequest();
    xhr.open("POST", URL);
    xhr.responseType = "json";
    xhr.send(body);
    xhr.onload = () => {
        if (xhr.status === 201) {
            let articulo = xhr.response;
            let content = `<div class="alert alert-success" role="alert">
                                El articulo ha sido actualizado
                            </div>
                            <table class="table table-striped">
                                <tr>
                                    <th>ID</th>
                                    <th>NOMBRE</th>
                                    <th>PRECIO</th>
                                </tr>
                                <tr>
                                    <td>${articulo.id}</td>
                                    <td>${articulo.nombre}</td>
                                    <td>${articulo.precio}</td>
                                </tr>
                            </table>`;
            main.innerHTML = content;
        } else {
            main.innerHTML = `<div class="alert alert-danger" role="alert">
                                Error al añadir el articulo
                            </div>`;
        }
    }
    xhr.error = () => {
        console.error("Error: ", xhr.status);
    }
}

const update = () => {
    const id = prompt("Dime el ID del articulo");
    const nombre = prompt("Dime el nombre del articulo");
    const precio = prompt("Dime el precio del articulo");
    const body = JSON.stringify({ nombre, precio });

    const xhr = new XMLHttpRequest();
    xhr.open("PUT", `${URL}/${id}`);
    xhr.responseType = "json";
    xhr.send(body);
    xhr.onload = () => {
        if (xhr.status === 200) {
            let articulo = xhr.response;
            let content = `<div class="alert alert-success" role="alert">
                                El articulo ha sido actualizado
                            </div>
                            <table class="table table-striped">
                                <tr>
                                    <th>ID</th>
                                    <th>NOMBRE</th>
                                    <th>PRECIO</th>
                                </tr>
                                <tr>
                                    <td>${articulo.id}</td>
                                    <td>${articulo.nombre}</td>
                                    <td>${articulo.precio}</td>
                                </tr>
                            </table>`;
            main.innerHTML = content;
        } else {
            main.innerHTML = `<div class="alert alert-danger" role="alert">
                                Error al actualizar el articulo
                            </div>`;
        }
    }
}

const remove = () => {
    const id = prompt("Dime el ID del articulo");
    const xhr = new XMLHttpRequest();
    xhr.open("DELETE", `${URL}/${id}`);
    xhr.responseType = "json";
    xhr.send();

    xhr.onload = () => {
        if (xhr.status === 200) {
            main.innerHTML = `<div class="alert alert-success" role="alert">
                                El articulo ha sido eliminado
                            </div>`;
        } else {
            main.innerHTML = `<div class="alert alert-danger" role="alert">
                                Error al eliminar el articulo
                            </div>`;
        }
    }
    xhr.error = () => {
        console.error("Error: ", xhr.status);
    }
}


/********** LISTENERS **********/
btnGetAll.addEventListener("click", getAll);
btnFindById.addEventListener("click", findById);
btnAdd.addEventListener("click", add);
btnUpdate.addEventListener("click", update);
btnDelete.addEventListener("click", remove);