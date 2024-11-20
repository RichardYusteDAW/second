/********** DOM ELEMENTS **********/
const btnNuevo = document.getElementById('btnNuevo');
const divArticulos = document.getElementById('divArticulos');
const dialogNuevo = document.getElementById('dialogNuevo');
const formNuevo = document.getElementById('formNuevo');
const dialogModificar = document.getElementById('dialogModificar');
const formModificar = document.getElementById('formModificar');
const btnCancelarModificar = document.getElementById('btnCancelarModificar');


/********** URL **********/
const URL = 'http://localhost:3000/articulos';

/********** WINDOW ONLOAD **********/
window.onload = () => {
    paintTable();
}

/********** FUNCTIONS **********/
const paintTable = () => {
    const options = {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        },
        body: {}
    }
    fetch(URL, options)
        .then(response => response.json())
        .then(data => {
            let table = `<table class="table">
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Precio</th>
                            <th></th>
                            <th></th>
                        </tr>`;

            data.forEach(articulo => {
                table += `
            <tr>
                <td>${articulo.id}</td>
                <td>${articulo.nombre}</td>
                <td>${articulo.precio}</td>
                <td><button value="${articulo.id}" class="btn btn-primary modificar">Modificar</button></td>
                <td><button value="${articulo.id}" class="btn btn-danger eliminar">Eliminar</button></td>
            </tr>`;
            });

            table += `</table>`;

            divArticulos.innerHTML = table;

            const btnsModificar = document.querySelectorAll('.modificar');
            const btnsEliminar = document.querySelectorAll('.eliminar');

            btnsModificar.forEach(btn => {
                btn.addEventListener('click', () => {
                    fetch(URL + '/' + btn.value)
                        .then(response => response.json())
                        .then(data => {
                            formModificar.id.value = data.id;
                            formModificar.nombre.value = data.nombre;
                            formModificar.precio.value = data.precio;
                            dialogModificar.showModal();
                        });
                });
            });

            btnsEliminar.forEach(btn => {
                btn.addEventListener('click', () => {
                    deleteArticle(btn.value);
                });
            });
        });
}

const deleteArticle = (id) => {
    const options = {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ id })
    }
    fetch(URL + '/' + id, options)
        .then(response => response.json())
        .then(data => {
            paintTable();
        });
}


/********** LISTENERS **********/
btnNuevo.addEventListener('click', () => {
    dialogNuevo.showModal();
});

formNuevo.addEventListener('submit', (e) => {
    e.preventDefault();

    const nombre = formNuevo.nombre.value;
    const precio = formNuevo.precio.value;
    const options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ nombre, precio })
    }

    fetch(URL, options)
        .then(response => response.json())
        .then(data => {
            dialogNuevo.close();
            paintTable();
        });
});

formModificar.addEventListener('submit', (e) => {
    e.preventDefault();

    const id = formModificar.id.value;
    const nombre = formModificar.nombre.value;
    const precio = formModificar.precio.value;
    const options = {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ nombre, precio })
    }

    fetch(`${URL}/${id}`, options)
        .then(response => response.json())
        .then(data => {
            dialogModificar.close();
            paintTable();
        });
});

btnCancelarModificar.addEventListener('click', () => {
    dialogModificar.close();
});