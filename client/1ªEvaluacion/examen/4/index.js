const { modulos } = require('./datos.js');

// Añadir un Módulo: Añade un nuevo módulo al array modulos con detalles como código, nombre, créditos y profesor.
const newModule = {
    'codigo': 7,
    'nombre': 'New',
    'creditos': 10,
    'profesor': 'Richard'
}
modulos.push(newModule);
console.log(modulos);


// Eliminar un Módulo por Código: Crea una función que elimine un módulo del array modulos utilizando su código.
const codigo = 7;
const index = modulos.findIndex(mod => mod.codigo === codigo);
modulos.splice(index, 1);
console.log(modulos);


// Eliminar un Módulo por Nombre: Crea una función que elimine un módulo del array modulos utilizando su nombre.
modulos.push(newModule);
console.log(modulos);
const nombre = "Richard";
const index2 = modulos.findIndex(mod => mod.nombre === nombre);
modulos.splice(index, 1);
console.log(modulos)


// Encontrar Módulos por Profesor: Escribe una función que devuelva todos los módulos que enseña un determinado profesor.
const findByTeacher = (teacher) => {
    return modulos.filter(m => m.profesor === teacher);
}

console.log(findByTeacher("Lorenzo"));


// Sumar los Créditos de un Profesor: Crea una función que sume todos los créditos de los módulos que imparte un profesor específico.
const creditSum = (teacher) => {
    return modulos.reduce((acc, mod) => {
        if (mod.profesor === teacher) {
            return acc + mod.creditos;
        }
        return acc;
    }, 0)
}

// const creditSum = (teacher) => {
//     let cont = 0;
//     modulos.forEach(mod => {
//         if (mod.profesor === teacher) {
//             cont += mod.creditos
//         }
//     })
//     return cont;
// }

console.log(creditSum('Eva'));


// Listar Todos los Profesores: Escribe una función que liste todos los profesores únicos del array modulos.
const teacherList = () => {
    const teacherSet = new Set();
    modulos.forEach(mod => teacherSet.add(mod.profesor))
    return teacherSet;
}
console.log(teacherList());



// Sumar los Créditos de Todos los Módulos: Crea una función que sume los créditos de todos los módulos.
const totalCredits = () => {
    return modulos.reduce((acc, mod) => acc + mod.creditos, 0)
}
console.log(totalCredits());


// Actualizar Créditos de un Módulo: Escribe una función para actualizar el número de créditos de un módulo específico.
const updateCredits = (mod, credits) => {
    const index = modulos.findIndex(m => m.nombre === mod)
    modulos[index].creditos = credits;
}

updateCredits('Ingles', 7)
console.log(modulos);


// Contar Módulos por Profesor: Crea una función que cuente cuántos módulos enseña cada profesor.
const modByTeacher = () => {
    const obj = {};

    modulos.forEach(mod => {
        if (!obj[mod.profesor]) {
            obj[mod.profesor] = 1;
        } else {
            obj[mod.profesor] += 1;
        }
    })
    return obj;
}
console.log(modByTeacher());


// Agregar un Nuevo Campo a Cada Módulo: Añade un campo nuevo, como departamento, a cada objeto del array modulos.
const addField = (field) => {
    modulos.forEach(mod => mod[field] = "")
}

addField("departamento")
console.log(modulos);