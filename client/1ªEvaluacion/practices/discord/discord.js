let frutas = ["manzana", "pera", "naranja", "plátano", "fresa"];
let animales = ["perro", "gato", "loro", "pez", "tortuga"];
let modulos = [
    { 'codigo': 1, 'nombre': 'Cliente', 'creditos': 10, 'profesor': 'Salva' },
    { 'codigo': 2, 'nombre': 'Servidor', 'creditos': 8, 'profesor': 'Cesar' },
    { 'codigo': 3, 'nombre': 'Interfaces', 'creditos': 6, 'profesor': 'Lorenzo' },
    { 'codigo': 4, 'nombre': 'Despliegue', 'creditos': 4, 'profesor': 'Lorenzo' },
    { 'codigo': 5, 'nombre': 'Empresa', 'creditos': 4, 'profesor': 'Eva' },
    { 'codigo': 6, 'nombre': 'Ingles', 'creditos': 2, 'profesor': 'Eva' }
];

// Elimina "naranja" del array frutas.
let copia = [...frutas];
const index = copia.findIndex(fruta => fruta == "naranja");
copia.splice(index, 1);
console.log(copia);

// Elimina el modulo "Despliegue" del array modulos.
let modulo2 = modulos.splice(0, 5);
const index2 = modulo2.findIndex(mod => mod.nombre == "Despliegue");
modulo2.splice(index2, 1);
console.log(modulo2);



// Ordena alfabéticamente el array modulos por el nombre de cada módulo.
let copia2 = modulos.slice();
copia2.sort((a, b) => {
    if (a.nombre < b.nombre) {
        return -1;
    }
    if (a.nombre > b.nombre) {
        return 1;
    }
    return 0;
});
console.log(copia2);



// Crea este un objeto totales con los nombres de los profesores y el total de sus créditos.
let totales = {};
modulos.forEach((mod) => {
    if (!totales[mod.profesor]) {
        totales[mod.profesor] = mod.creditos;
    } else {
        totales[mod.profesor] += mod.creditos;
    }
})

console.log(totales);




// Muestra por pantalla las propiedades del objeto y sus valores correspondientes.
for (const key in totales) {
    console.log(key);
    console.log(totales[key]);
}