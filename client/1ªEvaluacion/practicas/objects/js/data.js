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
    let alumno = alumnos.find(alu => alu.nombre.toLowerCase() == nombre.toLowerCase());
    let calificaciones = alumno.calificaciones;
    let notaMax = 0;
    let notaMin = 10;
    let acc = 0;
    if (alumno) {
        calificaciones.forEach((n) => {
            if (n.nota > notaMax) notaMax = n.nota;
            if (n.nota < notaMin) notaMin = n.nota;
            acc += n.nota;
        })
        const avg = acc / calificaciones.length

        console.log(`La mejor nota de ${nombre} es: ${notaMax}`)
        console.log(`La peor peor de ${nombre} es: ${notaMin}`)
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
    let alumno = alumnos.filter(alu => alu.ciudad.toLowerCase() == ciudad.toLowerCase());

    if (alumno.length > 0) {
        let mensaje = `Los alumnos de ${alumno[0].ciudad} son: `
        alumno.forEach((al) => mensaje += ` ${al.nombre}`)
        console.log(mensaje)
    } else {
        console.log("No hay alumnos en esa ciudad")
    }
}

const alumnosCurso = () => {
    let codigo = prompt(`Introduce el código del curso:
    DAW-1-2019
    DAW-2-2019
    DAW-1-2020
    DAW-2-2020`).trim();
    let alumno = alumnos.filter(alu => alu.codigo.toLowerCase() == codigo.toLowerCase());

    if (alumno.length > 0) {
        let mensaje = `Los alumnos que cursan ${alumno[0].codigo} son: `
        alumno.forEach((al) => mensaje += ` ${al.nombre}`)
        console.log(mensaje)
    } else {
        console.log("No hay alumnos realizando ese curso")
    }
}

const ordenaEdad = () => {
    alumnos.sort((a, b) => a.edad - b.edad);
    console.log(alumnos);
};

const ordenaNombreAsc = () => {
    let alumnosOrdenado = alumnos.sort((a, b) => {
        if (a.nombre > b.nombre) return 1;
        if (a.nombre < b.nombre) return -1;
        return 0;
    });
    console.log(alumnosOrdenado);
};

const ordenaNombreDesc = () => {
    let alumnosOrdenado = alumnos.sort((a, b) => {
        if (a.nombre < b.nombre) return 1;
        if (a.nombre > b.nombre) return -1;
        return 0;
    });
    console.log(alumnosOrdenado);
};

const borraAlumno = () => {
    let nombre = prompt("Introduce el nombre del alumno:").trim();
    let alumnoIndex = alumnos.findIndex(alu => alu.nombre.toLowerCase() == nombre.toLowerCase());

    if (alumnoIndex == -1) return console.log("El alumno no existe");
    alumnos.splice(alumnoIndex, 1)
    console.log(alumnos);
};

const nuevoAlumno = () => {
    const codigo = prompt("Introduce un código:");
    const nombre = prompt("Introduce un nombre:");
    const ciudad = prompt("Introduce un ciudad:");
    const edad = parseInt(prompt("Introduce un edad:"));
    const calificaciones = []

    const alumno = { codigo, nombre, ciudad, calificaciones, edad }
    alumnos.push(alumno);
    console.log(alumnos);
};

const nuevaAsignatura = () => {
    let nombre = prompt("Introduce el nombre del alumno:").trim();
    let alumno = alumnos.find(alu => alu.nombre.toLowerCase() == nombre.toLowerCase());

    if (alumno) {
        let asignatura = prompt("Introduce el nombre de la asignatura:").trim();
        let nota = parseInt(prompt("Introduce la nota de la asignatura:"));
        if (nota < 0) nota = 0;
        if (nota > 10) nota = 10;
        let calificaciones = alumno.calificaciones
        const calificacion = calificaciones.find((cal) => cal.asignatura.toLowerCase() == asignatura.toLowerCase())

        if (calificacion) {
            calificacion.nota = nota
        } else {
            calificaciones.push({ asignatura, nota })
        }
        console.log(alumno)
    } else {
        console.log("El alumno no existe")
    }
};