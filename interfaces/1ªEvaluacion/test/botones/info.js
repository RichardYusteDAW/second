const title = document.querySelector('h1');
const buttons = document.querySelectorAll('button');
const reset = document.getElementById('reset');
const message = `Hello, You want more information about me?`;

const showMessage = (cont) => {
    title.textContent = message + ` cont: ${cont}`;
};

const resetText = () => {
    title.textContent = '';
}

let cont = 1;
buttons.forEach(button => {
    button.addEventListener('click', () => {
        showMessage(cont);
        cont++;
    });
});

reset.addEventListener('click', resetText);