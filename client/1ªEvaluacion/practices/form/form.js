/*************** DOM Elements ***************/
const nameInput = document.getElementById("name");
const nameErrorDiv = document.getElementById("errorName");
const emailInput = document.getElementById("email");
const emailErrorDiv = document.getElementById("errorEmail");
const button = document.getElementById("btn");



/*************** Mehods ***************/
const isEmpty = (text) => {
    return text.trim() == "";
}

const lessThan5 = (text) => {
    return text.length <= 5;
}

const isEmail = (email) => {
    const regex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return regex.test(email);
}

const showError = (element, error) => {
    element.innerHTML = error;
    element.style.display = "block";
}

const showData = (data) => {
    console.log(JSON.stringify(data));
}



/*************** Check name errors ***************/
nameInput.addEventListener("input", (e) => {
    let nameError;
    const name = nameInput.value;
    if (isEmpty(name)) {
        nameError = "El campo nombre está vacío";
        showError(nameErrorDiv, nameError)
    } else if (lessThan5(name)) {
        nameError = "El campo nombre tiene menos de 5 caracteres"
        showError(nameErrorDiv, nameError)
    } else {
        nameErrorDiv.style.display = "none";
    }
});


/*************** Check email errors ***************/
emailInput.addEventListener("input", (e) => {
    let emailError;
    const email = emailInput.value;
    if (isEmpty(email)) {
        emailError = "El campo email está vacío";
        showError(emailErrorDiv, emailError)
    } else if (!isEmail(email)) {
        emailError = "El email no es un email válido"
        showError(emailErrorDiv, emailError)
    } else {
        emailErrorDiv.style.display = "none";
    }
});

/*************** Form ***************/
button.addEventListener('click', (e) => {
    e.preventDefault();
    showData({
        name: nameInput.value,
        email: emailInput.value
    })
})