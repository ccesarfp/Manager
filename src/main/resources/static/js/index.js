let table = 'table-body';
let content = 'content-new';
document.addEventListener("DOMContentLoaded", function(event) {
    welcomePage();

    //document.getElementById('pomo-logo').addEventListener('click', () => {
        //cleanContent(content);
        //cleanMenuButton();
        //welcomePage();
    //})
    // document.getElementById('persons-btn').addEventListener('click', () => {
    //     accessPage(content, 'persons-btn', '/persons/personsPage', '/persons/', table, personTableTemplate);
    // })
    // document.getElementById('employees-btn').addEventListener('click', () => {
    //     accessPage(content, 'employees-btn', '/persons/employeesPage', '/persons/employees', table, employeeTableTemplate);
    // })
    // document.getElementById('players-btn').addEventListener('click', () => {
    //     accessPage(content, 'players-btn', '/persons/playersPage', '/persons/players', table, playerTableTemplate);
    // })
    //document.getElementById('acessLogin2').addEventListener('click', () => {
    //    accessPage(content, 'acessLogin2', '/persons/loginPage', '/persons/players', table, playerTableTemplate);
    //})
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

// function activeButton(button) {
//     // document.getElementById(button).classList.add('active');
//     console.log("active")
// }

function accessPage(el, btn, urlPage, urlData, table_name, func) {
    cleanContent(el);
    cleanMenuButton();
    prepareTablePage(urlPage, urlData ,table_name, func);
}

function accessView(el, urlPage, data = false) {
    cleanContent(el);
    cleanMenuButton();
    prepareView(urlPage);
    if (data == true) accessPage("content-home", 'persons-btn', '/persons/personsPage', '/persons/', table, personTableTemplate);
}

function acessAccount(){
    event.preventDefault()

    let email = document.getElementById('email');
    let password = document.getElementById('password');

    let data = {
        "email" : email.value,
        "password" : password.value
    }
    
    let ajax = new XMLHttpRequest();
    ajax.open('POST', '/access/login', true);
    ajax.setRequestHeader("Content-Type", "application/json");
    ajax.onreadystatechange = () => {
        if (ajax.readyState === 4 && ajax.status === 200){
            accessPage('content-new', 'persons-btn', '/persons/home', '/persons/', table, personTableTemplate);
        }
    }
    ajax.send(JSON.stringify(data));
}

function createAccount(){
    event.preventDefault()

    let username = document.getElementById('name');
    let name = document.getElementById('name');
    let email = document.getElementById('email');
    let role = "Developer";
    let password = document.getElementById('password');

    let data = {
        "name": name.value,
        "username": username.value,
        "email" : email.value,
        "password" : password.value,
        "role": role
    }
    
    let ajax = new XMLHttpRequest();
    ajax.open('POST', '/access/register', true);
    ajax.setRequestHeader("Content-Type", "application/json");
    ajax.onreadystatechange = () => {
        if (ajax.readyState === 4 && ajax.status === 200){
            accessView("content-new", "/persons/home");
            accessPage("content-home", 'persons-btn', '/persons/personsPage', '/persons/', table, personTableTemplate);
        }
    }
    ajax.send(JSON.stringify(data));
}

function reloadScreen(el, urlPage, urlData, table_name, func) {
    cleanContent(el);
    prepareTablePage(urlPage, urlData ,table_name, func);
}
