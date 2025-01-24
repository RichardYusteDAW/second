const button = document.querySelector('button#girar');
const divgirar = document.querySelector('.girar');

button.addEventListener('click', () => {
    // if (divgirar.classList.contains('girar_animacion')) {
    //     divgirar.classList.remove('girar_animacion');
    //     void divgirar.offsetWidth;
    // }
    divgirar.classList.add('girar_animacion');
});