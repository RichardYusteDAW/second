let num = null;
do {
  num = prompt('Escribe un número: ');
} while (!num)

document.addEventListener('DOMContentLoaded', function () {
  // DOM elements
  const divFecha = document.getElementById('fecha');
  const divTablas = document.getElementById('tablas');
  const divCalendario = document.getElementById('calendario');

  // Date
  const fecha = new Date();
  const dias = ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'];
  const meses = ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosoto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'];
  const mensajeFecha = `Hoy es ${dias[fecha.getDay()]} de ${meses[fecha.getMonth()]} de ${fecha.getFullYear()}`;

  divFecha.innerHTML = mensajeFecha;
  // divFecha.innerHTML = `Hoy es ${fecha.toLocaleDateString('es-ES', {
  //   weekday: 'long',
  //   day: 'numeric',
  //   month: 'long',
  //   year: 'numeric'
  // })}`;


  // Calendario
  const firstDay = new Date(fecha.getFullYear(), fecha.getMonth(), 1).getDay();
  const daysOfWeak = [1, 2, 3, 4, 5, 6, 0];
  const lastDays = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
  const holes = daysOfWeak.indexOf(firstDay);
  const totalDays = holes + lastDays[fecha.getMonth()];

  let calendario = `<table border=1><tr>`
  const header = ['L', 'M', 'X', 'J', 'V', 'S', 'D'];
  for (let i = 0; i < header.length; i++) {
    calendario += `<th>${header[i]}</th>`
  }
  calendario += '</tr><tr>'

  let cont = 0;
  for (let i = 1; i <= totalDays; i++) {
    if (i <= holes) {
      calendario += `<td></td>`
      cont++;
    } else {
      calendario += `<td>${i - holes}</td>`
      if ((i < totalDays) && (i % 7 == 0)) calendario += '</tr><tr>'
    }
  }
  calendario += '</tr>'
  calendario += '</td></tr></table>';

  divCalendario.innerHTML = calendario;


  // Tables
  let tablas = `<table border=1><tr>`
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