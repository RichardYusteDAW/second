/********** DOM ELEMENTS **********/
const matricula = new Matricula();

const btnAbreDatosPersonales = document.getElementById("btnAbreDatosPersonales");
const contenedor = document.getElementById("contenedor");
const dialogDatos = document.getElementById("dialogDatos");
const dni = document.getElementById("dni");
const nombre = document.getElementById("nombre");
const btnCierraDatosPersonales = document.getElementById("btnCierraDatosPersonales");

/********** METHODS **********/
/* 
<div class="card">
    <img src="assets/${mod.nombre.toLowerCase()}.png"/>
    <button id=${mod.codigo} class="btn-primary">${mod.nombre}</button>
</div> 
*/
const pintarModulos = () => {
    modulos.forEach(mod => {
        const card = document.createElement("div");
        card.classList.add("card");

        const img = document.createElement("img");
        img.src = `assets/${mod.nombre.toLowerCase()}.png`;

        const btn = document.createElement("button");
        btn.id = mod.codigo;
        btn.classList.add("btn-primary");
        btn.textContent = mod.nombre;
        btn.onclick = (event) => {
            anyadeModulo(event.target.id)
        };


        card.appendChild(img);
        card.appendChild(btn);
        contenedor.appendChild(card);
    })
}

const anyadeModulo = (codigo) => {
    matricula.anyadeModulo(Number(codigo));
    matricula.verMatricula();
}


/********** LSITENERS **********/
pintarModulos();

btnAbreDatosPersonales.addEventListener("click", () => {
    dialogDatos.showModal();
})

btnCierraDatosPersonales.addEventListener("click", () => {
    matricula.dni = dni.value;
    matricula.nombre = nombre.value;
    dialogDatos.close();
})