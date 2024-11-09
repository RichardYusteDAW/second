/********* DOM ELEMENTS **********/
const siderbar = document.querySelector(".c-sidebar");
const siderbarItem = document.querySelector(".c-sidebar__item");

/********* FUNCTIONS **********/
let content = "";
for (let index = 0; index < 8; index++) {
    content += siderbarItem.outerHTML;
}
siderbar.innerHTML = content;