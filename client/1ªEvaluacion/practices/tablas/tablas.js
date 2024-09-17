let num = null;
do {
    num = prompt('Escribe tu nombre: ');
} while (!num);

document.addEventListener('DOMContentLoaded', function () {
    const divTablas = document.getElementById('tablas');

    let tablas = '<table border="1"><tr>'
    for (let i = 1; i <= 10; i++) {
        tablas += `<td>${num} x ${i} = ${num * i}</td>`;
        if ((i < 10) && (i % 2 === 0)) tablas += '</tr><tr>';
        if (i === 10) tablas += '</tr>';
    }
    tablas += '</table>';
    divTablas.innerHTML = tablas;
});