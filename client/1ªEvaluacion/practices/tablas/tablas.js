let num = null;
do {
    num = prompt('Escribe un número: ');
} while (!num)

document.addEventListener('DOMContentLoaded', function () {
    const divTablas = document.getElementById('tablas');

    let tablas = `<table border=1>
                    <tr>
                      <td></td>
                      <td></td>
                    </tr>
                    <tr>
                    <td></td>
                    <td>
                      <table border=1><tr>`
    for (let i = 1; i <= 10; i++) {
        tablas += `<td>${num} x ${i} = ${num * i}</td>`
        if ((i < 10) && (i % 2 == 0)) tablas += '</tr><tr>'
        if (i === 10) tablas += '</tr>'
    }
    // for (let i = 1; i <= 10; i++) {
    //     tablas += `<td>${num}</td><td>x</td><td>${i}</td><td>=</td><td>${num * i}</td>`
    //     if ((i < 10) && (i % 2 == 0)) tablas += '</tr><tr>'
    //     if (i === 10) tablas += '</tr>'
    // }
    tablas += '</td></tr></table>';

    divTablas.innerHTML = tablas;

});