// Definicion clase Matricula		
class Matricula {
	dni;
	nombre;
	modulos;

	constructor() {
		this.dni = "";
		this.nombre = "";
		this.modulos = [];
	}

	anyadeModulo(codigo) {

		// Comprobar si el módulo existe
		const mod = modulos.find(mod => mod.codigo === codigo);
		if (!mod) {
			alert("Ese módulo no existe");
			return;
		}

		const modFound = this.modulos.find(mod => mod.codigo === codigo);
		if (modFound) {
			alert("Ese módulo ya está matriculado");
			return;
		}

		this.modulos.push(mod);
	}

	borraModulo(codigo) {
		const index = this.modulos.findIndex(mod => mod.codigo === codigo);
		if (index !== -1) {
			this.modulos.splice(index, 1);
		}
	}

	verMatricula() {
		const capaMatricula = document.getElementById("capaMatricula");

		let content = "<table class='table table-bordered table-striped'>";
		this.modulos.forEach(mod => {
			content += `<tr>
							<td>${mod.nombre}</td>
							<td>${mod.creditos}</td>
							<td><button id=${mod.codigo} class='btn btn-danger borrarModulo'>Borrar</button></td>
						</tr>`;
		})
		content += "</table>";
		if (this.modulos.length > 0) {
			content += `<button class="btn btn-success realizarMatricula">Realizar Matricula</button>`;
		}
		capaMatricula.innerHTML = content;

		const buttons = document.querySelectorAll(".borrarModulo");
		buttons.forEach(btn => btn.addEventListener("click", (event) => {
			this.borraModulo(Number(event.target.id));
			this.verMatricula();
		}))

		if (this.modulos.length > 0) {
			const button = document.querySelector(".realizarMatricula");
			button.addEventListener("click", () => {
				if (matricula.dni == "") {
					console.log("El dni está vacío");
					return;
				}
				if (matricula.nombre == "") {
					console.log("El nombre está vacío");
					return;
				}
				if (matricula.modulos.length == 0) {
					console.log("Los módulos están vacíos")
					return;
				}
				console.log(JSON.stringify(matricula));

				// Resetear valores:
				matricula.dni = "";
				matricula.nombre = "";
				matricula.modulos = [];
				capaMatricula.innerHTML = "";
			})
		}
	}
}