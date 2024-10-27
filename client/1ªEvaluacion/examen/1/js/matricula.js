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
    addModule(module) {
        if (!this.modules.includes(module)) {
            this.modules.push(module);
        }
    }

    removeModule(module) {
        const index = this.modules.indexOf(module);
        if (index > -1) {
            this.modules.splice(index, 1);
        }
    }

    updatePersonalData(dni, name) {
        this.dni = dni;
        this.name = name;
    }
}