class Matricula {

    // Atributes
    dni;
    name;
    modules;

    // Constructor
    constructor() {
        this.dni = null;
        this.name = null
        this.modules = [];
    }

    // Methods
    addModule(codigo) {
        // Check module exists
        const modulo = modulos.find(mod => mod.codigo == codigo);
        if (!modulo) {
            console.log("Module not found");
            return;
        }

        // Check module is already added
        if (!this.modules.find(mod => mod.codigo == codigo)) {
            this.modules.push(modulo);
        }
    }

    removeModule(codigo) {
        // Check module exists
        const modulo = modulos.find(mod => mod.codigo == codigo);
        if (!modulo) {
            console.log("Module not found");
            return;
        }

        const index = this.modules.indexOf(modulo);
        if (index > -1) {
            this.modules.splice(index, 1);
        }
    }

    updatePersonalData(dni, name) {
        if (dni.trim() == "" || name.trim() == "") {
            console.log("Datos personales no válidos");
            return;
        }
        this.dni = dni;
        this.name = name;
    }
}