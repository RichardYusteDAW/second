/********** DOM ELEMENTS **********/
const matricula = new Matricula();

const btnAbreDatosPersonales = document.getElementById("btnAbreDatosPersonales");
const listaProfes = document.getElementById("listaProfes");
const contenedor = document.getElementById("contenedor");
const capamatricula = document.getElementById("capamatricula");
const btnEfectuarMatricula = document.getElementById("btnEfectuarMatricula");
const formDatos = document.getElementById("formDatos");
const dni = document.getElementById("dni");
const nombre = document.getElementById("nombre");
const btnCierraDatosPersonales = document.getElementById("btnCierraDatosPersonales");



/********** METHODS **********/

// SELECT
const createProfesorList = () => {
    let profesorList = new Set();
    profesorList.add("Todos");
    modulos.forEach(mod => profesorList.add(mod.profesor));

    let content = "";
    profesorList.forEach(prof => {
        content += `<option value="${prof}">${prof}</option>`
    })
    listaProfes.innerHTML = content;
}


// MODULOS
const crearModulo = (m) => {
    return `<div class="col">
                <div class="card">
                    <img src="assets/${m.nombre.toLowerCase()}.png" class="card-img-top"/>
                    <div class="card-body">
                        <h5 class="card-title">${m.nombre}</h5>
                    </div>
                    <button id=${m.codigo} class="btn-success matricular">Matricular</button>
                </div>
            </div>`
}

const paintModules = (profesor) => {

    let modulosFiltered = modulos.slice();

    if (profesor != "Todos") {
        modulosFiltered = modulos.filter(mod => mod.profesor == profesor);
    }

    let content = "";
    modulosFiltered.forEach(mod => content += crearModulo(mod))
    contenedor.innerHTML = content;

    const buttons = document.querySelectorAll(".matricular");
    buttons.forEach(btn => {
        btn.addEventListener("click", (event) => {
            matricula.createModule(event.target.id)
            paintModulesSelected();
        })
    })
}

const paintModulesSelected = () => {
    let content = "";
    matricula.modules.forEach(mod => {
        content += crearModulo(mod);
    })
    capamatricula.innerHTML = content;

    const buttons = document.querySelectorAll("#capamatricula .matricular")
    buttons.forEach(btn => {
        btn.textContent = "Eliminar"
        btn.addEventListener("click", (event) => {
            matricula.deleteModule(event.target.id)
            paintModulesSelected();
        })
    });
}



/********** LSITENERS **********/
createProfesorList();
paintModules("Todos");

listaProfes.addEventListener("change", (event) => {
    paintModules(event.target.value)
})

btnAbreDatosPersonales.addEventListener("click", () => {
    formDatos.showModal();
})

btnCierraDatosPersonales.addEventListener("click", () => {
    matricula.dni = dni.value;
    matricula.nombre = nombre.value;
    formDatos.close();
})

btnEfectuarMatricula.addEventListener("click", () => {
    console.log(JSON.stringify(matricula));

    matricula.dni = "";
    matricula.nombre = "";
    matricula.modules = [];
    capamatricula.innerHTML = "";
})