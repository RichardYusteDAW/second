const urlArticulos = "http://localhost:3000/articulos";
const urlVendedores = "http://localhost:3000/vendedores";

// const buscarArticuloVendedor = (idVendedor) => {
//     fetch(urlArticulos)
//         .then(res => {
//             if (!res.ok) {
//                 throw new Error(`${res.status}:${res.statusText}`)
//             }
//             return res.json()
//         })
//         .then(data => {
//             const articulosFiltrados = data.filter(art =>
//                 art.vendedores.some(vendedor => vendedor.idVendedor == idVendedor)
//             );
//             console.log(articulosFiltrados);
//         })
//         .catch(e => console.log(e))
// }

// 1º Buscamos la id del vendedor
// 1-a Buscar todos los vendedores
// 1-b Filtrar por nombre


// 2º Buscamos el articulo por idVendedor
// 2-a Buscar todos los articulos
// 2-b Filtrar por idVendedor

const vendedoresFindAllByName = (nombre) => {
    fetch(urlVendedores)
        .then(res => {
            if (!res.ok) {
                throw new Error(`${res.status}: ${res.statusText}`)
            }
            return res.json();
        })
        .catch(err => console.log(err))
        .then(data => {
            const vendedoresFiltrados = data.find(vendedor => vendedor.nombre == nombre)
            if (!vendedoresFiltrados) {
                console.log("No hay ningún vendedor con ese nombre");
            } else {

                // buscarArticuloVendedor(vendedoresFiltrados.id)
                fetch(urlArticulos)
                    .then(res => {
                        if (!res.ok) {
                            throw new Error(`${res.status}: ${res.statusText}`)
                        }
                        return res.json();
                    })
                    .then(data => {
                        const articulosFiltrados = data.filter(art =>
                            art.vendedores.some(vendedor => vendedor.idVendedor == vendedoresFiltrados.id)
                        );
                        console.log(articulosFiltrados);
                    })
                    .catch(e => console.log(e))
            }
        })
}

vendedoresFindAllByName("Juan")

// ASYNC / AWAIT
// const buscarArticuloVendedor = async (idVendedor) => {
//     try {
//         const res = await fetch(urlArticulos);
//         const data = await res.json();

//         const articulosFiltrados = data.filter(art =>
//             art.vendedores.some(vendedor => vendedor.idVendedor == idVendedor)
//         );
//         return articulosFiltrados;

//     } catch (error) {
//         console.log(error);
//     }
// }

// const vendedoresFindAllByName = async (nombre) => {
//     try {
//         const res = await fetch(urlVendedores);
//         const data = await res.json();

//         const vendedoresFiltrados = data.find(vendedor => vendedor.nombre == nombre)
//         const articulosFiltrados = await buscarArticuloVendedor(vendedoresFiltrados.id)
//         console.log(articulosFiltrados);

//     } catch (error) {
//         console.log(error);
//     }
// }

// vendedoresFindAllByName("Pepe")