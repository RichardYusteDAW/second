const button = document.querySelector('button');
const divgirar = document.querySelector('.girar');

button.addEventListener('click', () => {
    divgirar.classList.remove('girar_animacion');
    void divgirar.offsetWidth;
    divgirar.classList.add('girar_animacion');
});