const btn = document.querySelector('button');
const astronauta = document.querySelector('.astronauta');
btn.addEventListener('click', () => {
    astronauta.classList.remove('movimiento');
    setTimeout(() => {
        astronauta.classList.add('movimiento');
    }, 0);
});