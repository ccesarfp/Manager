let table = 'table-body';
let content = 'content';
document.addEventListener("DOMContentLoaded", function(event) {
    document.getElementById('pomo-logo').addEventListener('click', () => {
        cleanContent(content);
        cleanMenuButton();
    })
    document.getElementById('persons-btn').addEventListener('click', () => {
        accessPage(content, 'persons-btn', '/persons/personsPage', '/persons/', table, personTableTemplate);
    })
    document.getElementById('employees-btn').addEventListener('click', () => {
        accessPage(content, 'employees-btn', '/persons/employeesPage', '/persons/employees', table, employeeTableTemplate);
    })
    document.getElementById('players-btn').addEventListener('click', () => {
        accessPage(content, 'players-btn', '/persons/playersPage', '/persons/players', table, playerTableTemplate);
    })
});

function cleanContent(element) {
    document.getElementById(element).innerHTML = '';
}

function cleanMenuButton() {
    let t = document.getElementsByClassName('menu-button btn btn-outline-danger mx-2 active');
    for (let i = 0; i < t.length; i++) {
        t[i].classList.remove('active');
    }
}

function activeButton(button) {
    document.getElementById(button).classList.add('active');
}

function accessPage(el, btn, urlPage, urlData, table_name, func) {
    cleanContent(el);
    cleanMenuButton();
    activeButton(btn);
    prepareTablePage(urlPage, urlData ,table_name, func);
}

function reloadScreen(el, urlPage, urlData, table_name, func) {
    cleanContent(el);
    prepareTablePage(urlPage, urlData ,table_name, func);
}

