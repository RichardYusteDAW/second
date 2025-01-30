const btn = document.querySelector('button');
const bola = document.querySelector('.bola');
btn.addEventListener('click', () => {
    bola.classList.remove('movimiento');
    setTimeout(() => {
        bola.classList.add('movimiento');
    }, 0);
});