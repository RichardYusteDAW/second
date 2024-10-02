"use strict"
let alumnos = [
    {
        'codigo': 'DAW-1-2020',
        'nombre': 'Pepe',
        'ciudad': 'Valencia',
        'calificaciones': [
            { 'asignatura': 'PRG', 'nota': 9 },
            { 'asignatura': 'GBD', 'nota': 6 },
            { 'asignatura': 'ING', 'nota': 4 },
            { 'asignatura': 'FOL', 'nota': 3 }
        ],
        'edad': 24
    },
    {
        'codigo': 'DAW-2-2020',
        'nombre': 'Juan',
        'ciudad': 'Castellon',
        'calificaciones': [
            { 'asignatura': 'DWC', 'nota': 4 },
            { 'asignatura': 'DWS', 'nota': 6 },
            { 'asignatura': 'DAW', 'nota': 7 },
            { 'asignatura': 'DIW', 'nota': 8 },
            { 'asignatura': 'ING', 'nota': 9 },
            { 'asignatura': 'TIE', 'nota': 2 }
        ],
        'edad': 28
    },
    {
        'codigo': 'DAW-1-2019',
        'nombre': 'Ana',
        'ciudad': 'Valencia',
        'calificaciones': [
            { 'asignatura': 'PRG', 'nota': 6 },
            { 'asignatura': 'GBD', 'nota': 2 },
            { 'asignatura': 'ING', 'nota': 6 },
            { 'asignatura': 'FOL', 'nota': 2 }
        ],
        'edad': 22
    },
    {
        'codigo': 'DAW-2-2020',
        'nombre': 'Maria',
        'ciudad': 'Castellon',
        'calificaciones': [
            { 'asignatura': 'DWC', 'nota': 4 },
            { 'asignatura': 'DWS', 'nota': 6 },
            { 'asignatura': 'DAW', 'nota': 7 },
            { 'asignatura': 'DIW', 'nota': 8 },
            { 'asignatura': 'ING', 'nota': 4 },
            { 'asignatura': 'TIE', 'nota': 1 }
        ],
        'edad': 30
    }
];

const notasAlumno = () => {
    let nombre = prompt("Introduce el nombre del alumno:").trim();
    const nombreMinus = nombre.toLowerCase()
    let alumno = alumnos.find(alu => alu.nombre.toLowerCase() == nombreMinus);
    let calificaciones = alumno.calificaciones;
    if (alumno) {
        const best = calificaciones.reduce((acc, calificacion) => acc.nota > calificacion.nota ? acc : calificacion);
        const worst = calificaciones.reduce((acc, calificacion) => acc.nota < calificacion.nota ? acc : calificacion);
        const avg = calificaciones.reduce((acc, calificacion) => acc + calificacion.nota, 0) / alumno.calificaciones.length;
        console.log(`La mejor nota de ${nombre} es: ${best.nota}`)
        console.log(`La peor peor de ${nombre} es: ${worst.nota}`)
        console.log(`La nota media de ${nombre} es: ${avg}`)

    } else {
        console.log("El alumno no existe")
    }
}

const subeUnPunto = () => {
    alumnos.forEach(alumno => {
        alumno.calificaciones.forEach((cal) => cal.nota += 1);
    });
    console.log(alumnos)
}

const alumnosCiudad = () => {
    let ciudad = prompt("Introduce el nombre de la ciudad:").trim();
    const ciudadMinus = ciudad.toLowerCase();
    let alumno = alumnos.filter(alu => alu.ciudad.toLowerCase() == ciudadMinus);

    if (alumno) {
        let mensaje = `Los alumnos de ${ciudad} son: `
        alumno.forEach((al) => mensaje += ` ${al.nombre}`)
        console.log(mensaje)
    } else {
        console.log("No hay alumnos en esa ciudad")

    }
}