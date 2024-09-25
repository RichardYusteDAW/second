document.addEventListener('DOMContentLoaded', function () {

    /************ DOM ELEMENTS ************/
    const ul = document.querySelector('ul');
    const createButton = document.getElementById('create');
    const findButton = document.getElementById('find');
    const deleteButton = document.getElementById('delete');

    /************ DATA ************/
    let students = ["Pepe", "Juan", "Luis", "Ana", "Maria", "Rosa", "Lola", "Manuel", "Antonio", "Pedro"];

    /************ FUNCTIONS ************/
    const arrayToHTMLList = () => {
        let list = '';
        students.forEach(student => {
            list += `<li>${student}</li>`;
        });
        return list;
    };

    const createStudent = () => {
        let student = prompt('Introduce un nombre');
        students.push(student);
        ul.innerHTML = arrayToHTMLList();
    };

    const findStudent = () => {
        let student = prompt('Introduce un nombre');
        let index = students.indexOf(student);
        (index === -1)
            ? alert('El nombre no se encuentra en la lista')
            : alert('El nombre se encuentra en la posición: ' + (index + 1));
    }

    const deleteStudent = () => {
        let student = prompt('Introduce un nombre');
        let index = students.indexOf(student);
        if (index === -1) {
            alert('El nombre no se encuentra en la lista');
        } else {
            students.splice(index, 1);
            ul.innerHTML = arrayToHTMLList();
        }
    }

    /************ INIT ************/
    ul.innerHTML = arrayToHTMLList();

    /************ EVENT LISTENERS ************/
    createButton.addEventListener('click', createStudent);
    findButton.addEventListener('click', findStudent);
    deleteButton.addEventListener('click', deleteStudent);
});