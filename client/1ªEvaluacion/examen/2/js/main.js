/******** DOM ELEMENTS ********/
const resultados = document.getElementById('resultados');

/******** LISTENERS ********/

/******** FUNCTIONS ********/
const verTotales = () => {

    const totales = {};
    let contenido = "";

    modulos.forEach(mod => {
        if (!profesores[mod.profesor]) {
            profesores[mod.profesor] = mod.creditos;
        } else {
            profesores[mod.profesor] += mod.creditos;
        }
    });


    for (let propiedad in totales) {
        contenido += `<p>${propiedad}: ${totales[propiedad]}</p>`
    }

    resultados.innerHTML = contenido;
}