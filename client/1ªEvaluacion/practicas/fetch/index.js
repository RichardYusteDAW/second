/****************DATA ****************/
const provURL = "http://localhost:3000/proveedores";
const artURL = "http://localhost:3000/articulos";


// Obtener todos los proveedores
fetch(provURL)
    .then(res => res.json())
    .then(data => console.log(data));

const getProveedores = async () => {
    const res = await fetch(provURL);
    const data = await res.json();
    console.log(data);
}
getProveedores();


// Obtener todos los artículos
fetch(artURL)
    .then(res => res.json())
    .then(data => console.log(data));

const getArticulos = async () => {
    const res = await fetch(artURL);
    const data = await res.json();
    console.log(data);
}
getArticulos();


// Obtener los datos del proveedor 2
const findProveedorById = async (id) => {
    const res = await fetch(`${provURL}/${id}`);
    const data = await res.json();
    console.log(data);
}
findProveedorById(2);


// Borrar el proveedor 9
const deleteProveedor = async (id) => {
    const params = {
        method: "DELETE"
    };
    const res = await fetch(`${provURL}/${id}`, params);
    if (res.ok) {
        console.log("Proveedor eliminado");
    } else if (res.status === 404) {
        console.log("Proveedor no encontrado");
    } else {
        console.log("Error al eliminar el proveedor");
    }
}
deleteProveedor(9);


// Obtener los datos del articulo 7
const findArticuloById = async (id) => {
    const res = await fetch(`${artURL}/${id}`);
    if (res.ok) {
        const data = await res.json();
        console.log(data);
    } else if (res.status === 404) {
        console.log("Articulo no encontrado");
    } else {
        console.log("Error al obtener el articulo");
    }
}
findArticuloById(7);


// Añadir el articulo con id 4, con nombre “Portátil Toshiba i7" y precio 900
const createArticle = async (id) => {
    const params = {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            id,
            nombre: "Portátil Toshiba i7",
            precio: 900
        })
    };
    const res = await fetch(artURL, params);

    if (res.status === 201) {
        const data = await res.json();
        console.log("Articulo creado", data);
    } else if (res.status === 409) {
        console.log("El articulo ya existe");
    } else {
        console.log("Error al crear el articulo");
    }
}
createArticle("4");


// Obtener todos los artículos
getArticulos();

// Modificar el artículo con id 4 cambiándole el nombre a “Monitor Plasma”
const updateArticle = async (id, nombre) => {
    const params = {
        method: "PATCH",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ nombre })
    };
    const res = await fetch(`${artURL}/${id}`, params);
    if (res.ok) {
        console.log("Articulo actualizado");
    } else if (res.status === 404) {
        console.log("Articulo no encontrado");
    } else {
        console.log("Error al actualizar el articulo");
    }
}
updateArticle("4", "Monitor Plasma");

// Eliminar el articulo con id 4
const deleteArticle = async (id) => {
    const params = {
        method: "DELETE"
    };
    const res = await fetch(`${artURL}/${id}`, params);
    if (res.ok) {
        console.log("Articulo eliminado");
    } else if (res.status === 404) {
        console.log("Articulo no encontrado");
    } else {
        console.log("Error al eliminar el articulo");
    }
}
deleteArticle("4");
getArticulos();


// Crear un artículo sin id y con nombre “Disco Duro" y precio 100
const createArticleWithoutId = async (nombre, precio) => {
    const params = {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ nombre, precio })
    };
    const res = await fetch(artURL, params);
    if (res.status === 201) {
        const data = await res.json();
        console.log("Articulo creado", data);
    } else if (res.status === 409) {
        console.log("El articulo ya existe");
    } else {
        console.log("Error al crear el articulo");
    }
}
createArticleWithoutId("Disco Duro", 100);
getArticulos();

// Eliminar el articulo creado inicialmente sin id
deleteArticle("43c9");
getArticulos();