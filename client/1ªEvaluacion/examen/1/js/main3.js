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

    return content;
}

const paintProfesorList = () => {
    listaProfes.innerHTML = createProfesorList();
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
            matricula.addModule(event.target.id);
            paintMatricula();
        })
    })
}

// MATRICULA
const createMatricula = () => {
    let content = "<table class='table table-bordered table-striped'>";
    matricula.modules.forEach(mod => {
        content += `<tr>
                        <td>${mod.nombre}</td>
                        <td>${mod.creditos}</td>
                        <td><button id=${mod.codigo} class='btn btn-danger removeMatricula'>Borrar</button></td>
                    </tr>`
    })
    return content;
}

const paintMatricula = () => {
    capamatricula.innerHTML = createMatricula();

    const buttons = document.querySelectorAll(".removeMatricula");
    buttons.forEach(btn => {
        btn.addEventListener("click", (event) => {
            matricula.removeModule(event.target.id);
            paintMatricula();
        })
    })
}

const finishMatricula = () => {
    if (matricula.dni == null) {
        console.log("No puedes matricularte sin dni");
        return;
    }
    if (matricula.name == null) {
        console.log("No puedes matricularte sin nombre");
        return;
    }

    if (matricula.modules.length == 0) {
        console.log("No puedes matricularte sin módulos");
        return;
    }

    console.log(matricula);

    // Reset
    matricula.dni = null;
    matricula.name = null;
    matricula.modules = [];
    capamatricula.innerHTML = "";
}


/********** LSITENERS **********/
paintProfesorList();
paintModules("Todos");

btnAbreDatosPersonales.addEventListener("click", () => {
    formDatos.showModal();
})

btnCierraDatosPersonales.addEventListener("click", () => {
    matricula.updatePersonalData(dni.value, nombre.value);
    formDatos.close();
})

listaProfes.addEventListener("change", (event) => {
    paintModules(event.target.value)
})

btnEfectuarMatricula.addEventListener("click", () => {
    finishMatricula();
})