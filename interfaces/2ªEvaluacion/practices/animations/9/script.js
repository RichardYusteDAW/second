const boton = document.querySelector('button');
const icon = document.querySelector('i');

boton.addEventListener('click', () => {
    icon.classList.remove('rojo');
});