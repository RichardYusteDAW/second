/********** DOM ELEMENTS **********/
let matricula;
let btnAbreDatosPersonales;
let selectListaProfes;
let contenedorModulos;
let capamatricula;
let btnEfectuarMatricula;
let dialog;
let dni;
let nombre;
let btnCierraDatosPersonales;



/********** WINDOW / ONLOAD **********/
window.onload = () => {
    matricula = new Matricula();

    // DOM Elelements 
    btnAbreDatosPersonales = document.getElementById('btnAbreDatosPersonales');
    selectListaProfes = document.getElementById("listaProfes");
    contenedorModulos = document.getElementById("contenedor");
    capamatricula = document.getElementById("capamatricula");
    btnEfectuarMatricula = document.getElementById('btnEfectuarMatricula');
    dialog = document.getElementById('formDatos');
    dni = document.getElementById('dni');
    nombre = document.getElementById('nombre');
    btnCierraDatosPersonales = document.getElementById('btnCierraDatosPersonales');

    // Listeners
    btnAbreDatosPersonales.addEventListener('click', verDatosPersonales);
    selectListaProfes.addEventListener("change", (event) => pintarModulos(event.target.value));
    btnEfectuarMatricula.addEventListener('click', efectuarMatricula);
    btnCierraDatosPersonales.addEventListener('click', modificarDatosPersonales);

    // Methods
    crearListaProfesores();
    pintarModulos("Todos");
    modificarDatosPersonales();
};




/********** METHODS **********/
const crearListaProfesores = () => {
    let options = "";
    const arrayProfes = []

    options += `<option id="Todos" value="Todos">Todos</option>`
    modulos.forEach((m) => {
        const prof = m.profesor;
        if (!arrayProfes.includes(prof)) {
            arrayProfes.push(prof);
            options += `<option id="${prof}" value="${prof}">${prof}</option>`
        }
    });

    selectListaProfes.innerHTML = options;
};

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

const pintarModulos = (profesor) => {
    /*
    1º Creamos una copia del array de datos para elegir la opción que mejor nos convenga.
    2º Añadimos el contenido al contenedor correspondiente
    3º Creamos los listeners de los botones que tienen esas cards.
    */
    let modulosFiltrados;
    let contenido = "";

    if (profesor === "Todos") {
        modulosFiltrados = modulos;
    } else {
        modulosFiltrados = modulos.filter(m => m.profesor === profesor);
    }

    modulosFiltrados.forEach((m) => {
        contenido += crearModulo(m);
    })
    contenedorModulos.innerHTML = contenido;

    const buttons = document.querySelectorAll('.matricular');
    buttons.forEach((button) => {
        button.addEventListener('click', (event) => {
            const module = modulos.find(m => m.codigo == event.target.id);
            agregarModulo(module);
        })
    })
};

const agregarModulo = (modulo) => {
    matricula.addModule(modulo);
    pintarModulosSeleccionados();
}

const pintarModulosSeleccionados = () => {
    // Pinta los módulos seleccionados.
    let contenido = "";
    matricula.modules.forEach((m) => {
        contenido += crearModulo(m);
    })
    capamatricula.innerHTML = contenido;

    // Elimina los botones ya que esta sección no los necesita.
    const buttons = capamatricula.querySelectorAll('.matricular');
    buttons.forEach(b => b.remove());
}

const verDatosPersonales = () => {
    dialog.showModal();
}

const modificarDatosPersonales = () => {
    matricula.dni = dni.value;
    matricula.name = nombre.value;
    dialog.close()
}

const efectuarMatricula = () => {
    /*
    1º Comprobar que los campos no están vacíos
    2º Mostrar matrícula por consola.
    3º Eliminar los datos de matricula.
    */
    if (matricula.dni && matricula.name && matricula.modules.length > 0) {
        console.log(JSON.stringify(matricula));
        matricula.dni = null;
        matricula.name = null;
        matricula.modules = [];
    }
}