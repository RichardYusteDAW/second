import { alumnos } from './data.mjs';

const notasAlumno = () => {
    const nombreAlumno = "Pepe";

    const alumno = alumnos.find(alumno => alumno.nombre == nombreAlumno);
    let calificaciones;
    let notaMedia = 0;
    let notaMaxima = 0;
    let notaMinima = 10;
    let totalNotas = 0;

    if (alumno) {
        calificaciones = alumno.calificaciones;
        calificaciones.forEach(cal => {
            notaMedia += cal.nota;
            if (cal.nota > notaMaxima) notaMaxima = cal.nota;
            if (cal.nota < notaMinima) notaMinima = cal.nota;
            totalNotas++;
        })

        console.log("La nota media es:", notaMedia / totalNotas);
        console.log("La nota máxima es:", notaMaxima);
        console.log("La nota mínima es:", notaMinima);
    }
    else
        console.log("El alumno no existe");
};

const subeUnPunto = () => {
    let alumnosCopy = alumnos.slice();
    alumnosCopy.forEach(alumno => {
        alumno.calificaciones.forEach(cal => cal.nota++);
    })
    console.log(JSON.stringify(alumnosCopy));
};

const alumnosCiudad = () => {
    const ciudad = "Valenci";
    const alumnosFiltrados = alumnos.filter(alumno => alumno.ciudad == ciudad);

    if (alumnosFiltrados.length > 0) {
        let nombres = [];
        alumnosFiltrados.forEach(alumno => nombres.push(alumno.nombre));

        console.log(`Los alumnos de ${ciudad} son: ${nombres}`);
    } else {
        console.log("No existen alumnos en esa ciudad");
    }

};
const ordenaEdad = () => {
    let alumnosCopy = [...alumnos];
    let alumnosOrdenados = alumnosCopy.sort((a, b) => a.edad - b.edad);
    console.log(JSON.stringify(alumnosOrdenados));
};

const ordenaNombreDesc = () => {
    let alumnosCopy = alumnos.concat();
    let alumnosOrdenados = alumnosCopy.sort((a, b) => {
        if (a.nombre > b.nombre) return -1;
        if (a.nombre < b.nombre) return 1;
        return 0;
    });
    console.log(alumnosOrdenados);
};
const borraAlumno = () => {
    let nombre = "Pepe";
    let alumnosCopy = Array.from(alumnos);
    let index = alumnosCopy.findIndex(al => al.nombre == nombre);
    if (index != -1)
        alumnosCopy.splice(index, 1);
    console.log(JSON.stringify(alumnosCopy));

};
const nuevoAlumno = () => {
    const codigo = 'DAW-1-2024';
    const nombre = "Richard";
    const ciudad = "Ibiza";
    const calificaciones = [];
    const edad = 42;

    const alumno = { codigo, nombre, ciudad, calificaciones, edad };
    alumnos.push(alumno);
    console.log(alumnos);
};
const nuevaAsignatura = () => {
    const nombre = "Pepe";
    const asignatura = 'PRG';
    const nota = 10;

    const alumno = alumnos.find(a => a.nombre = nombre);

    if (alumno) {
        var asignaturaEncontrada = alumno.calificaciones.find(cal => cal.asignatura == asignatura);
        if (asignaturaEncontrada) {
            asignaturaEncontrada.nota = nota;
        } else {
            alumno.calificaciones.push({ asignatura, nota });
        }
    } else {
        console.log("El alumno no existe");
    }
    console.log(JSON.stringify(alumnos));
};

/*********** FUNCTION CALLS ************/
nuevaAsignatura();