/**
 * @name getTableData
 * @description - Retrieves the data that will be inserted into the tables
 * @param urlData - URL that will make request to retrieve data for tables
 * @param table_name - name of the table that receives the data
 * @param func - Function used to prepare data for data entry
 */
function getTableData(urlData, table_name, func) {
  //Creating employee`s table
  fetch(urlData, {
    method: "GET",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
  }).then((response) =>
    response
      .json()
      .then((data) => ({
        data: data,
        status: response.status,
      }))
      .then((res) => {
        if (res.status === 200) {
          populateTable(res.data, table_name, func);
        }
      })
  );
}

/**
 * @name prepareTablePage
 * @description - Retrieves the screen that will be displayed
 * @param urlPage - URL that will make the request to retrieve the web page
 * @param urlData - URL that will make request to retrieve data for tables
 * @param table_name - name of the table that receives the data
 * @param func - Function used to prepare data for data entry
 */
function prepareTablePage(urlPage, urlData, table_name, func) {
  let ajax = new XMLHttpRequest();
  ajax.onreadystatechange = () => {
    if (ajax.readyState === 4 && ajax.status === 200) {
      document.getElementById("content-new").innerHTML = ajax.responseText;
      getTableData(urlData, table_name, func);
    }
  };
  ajax.open("GET", urlPage);
  ajax.send();
}

function prepareView(urlPage) {
    let ajax = new XMLHttpRequest();
    ajax.onreadystatechange = () => {
      if (ajax.readyState === 4 && ajax.status === 200) {
        document.getElementById("content-new").innerHTML = ajax.responseText;
      }
    };
    ajax.open("GET", urlPage);
    ajax.send();
}

function chargeRoles() {
  fetch("/persons/roles", {
    method: "GET",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
  }).then((response) =>
    response
      .json()
      .then((data) => ({
        data: data,
        status: response.status,
      }))
      .then((res) => {
        if (res.status === 200) {
          document.getElementById(
            "role"
          ).innerHTML = `<option value="" selected disabled>Select a role</option>`;
          res.data.forEach((role) => {
            document.getElementById(
              "role"
            ).innerHTML += `<option value="${role.name}">${role.name}</option>`;
          });
        }
      })
  );
}

function chargeRolesUpdate(role) {
  fetch("/persons/roles", {
    method: "GET",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
  }).then((response) =>
    response
      .json()
      .then((data) => ({
        data: data,
        status: response.status,
      }))
      .then((res) => {
        if (res.status === 200) {
          document.getElementById(
            "role-update"
          ).innerHTML = `<option value="" selected disabled>Select a role</option>`;
          res.data.forEach((role) => {
            document.getElementById(
              "role-update"
            ).innerHTML += `<option value="${role.name}">${role.name}</option>`;
          });
          document.getElementById("role-update").value = role;
        }
      })
  );
}

function sendData() {
  event.preventDefault();

  let url = document.getElementById("form").dataset.url;

  let type;
  if (url === "/persons/createPerson") {
    type = "person";
  } else if (url === "/persons/createEmployee") {
    type = "employee";
  } else if (url === "/persons/createPlayer") {
    type = "player";
  }

  let name = document.getElementById("name");
  let username = document.getElementById("username");
  let email = document.getElementById("email");
  let password = document.getElementById("password");
  let role = document.getElementById("role");

  let data = {
    username: username.value,
    email: email.value,
    password: password.value,
  };

  if (name) {
    data["name"] = name.value;
    data["role"] = role.value;
  }

  let ajax = new XMLHttpRequest();
  ajax.open("POST", url, true);
  ajax.setRequestHeader("Content-Type", "application/json");
  ajax.onreadystatechange = () => {
    if (ajax.readyState === 4 && ajax.status === 200) {
      if (type === "person") {
        reloadScreen(
          content,
          "/persons/personsPage",
          "/persons/",
          table,
          personTableTemplate
        );
      } else if (type === "employee") {
        reloadScreen(
          content,
          "/persons/employeesPage",
          "/persons/employees",
          table,
          employeeTableTemplate
        );
      } else if (type === "player") {
        reloadScreen(
          content,
          "/persons/playersPage",
          "/persons/players",
          table,
          playerTableTemplate
        );
      }
      document.body.removeChild(
        document.getElementsByClassName("modal-backdrop")[0]
      );
    }
  };
  ajax.send(JSON.stringify(data));
}

function putDataConfirmation(id, name) {
  document.getElementById("name-delete").innerHTML = name;
  document.getElementById("id-delete").innerHTML = id;
  document.getElementById(
    "text-delete"
  ).innerHTML = `Really want to delete: ${name}`;
}

function deleteRow() {
  let url = document.getElementById("delete-btn").dataset.url;

  let id = document.getElementById("id-delete").innerHTML;

  let type;
  if (url === "/persons/deletePerson") {
    type = "person";
  } else if (url === "/persons/deleteEmployee") {
    type = "employee";
  } else if (url === "/persons/deletePlayer") {
    type = "player";
  }

  url += `/${id}`;

  let ajax = new XMLHttpRequest();
  ajax.open("DELETE", url, true);
  ajax.setRequestHeader("Content-Type", "application/json");
  ajax.onreadystatechange = () => {
    if (ajax.readyState === 4 && ajax.status === 200) {
      if (type === "person") {
        reloadScreen(
          "table-body",
          "/persons/home",
          "/persons/",
          table,
          personTableTemplate
        );
      } else if (type === "employee") {
        reloadScreen(
          content,
          "/persons/employeesPage",
          "/persons/employees",
          table,
          employeeTableTemplate
        );
      } else if (type === "player") {
        reloadScreen(
          content,
          "/persons/playersPage",
          "/persons/players",
          table,
          playerTableTemplate
        );
      }
      document.body.removeChild(
        document.getElementsByClassName("modal-backdrop")[0]
      );
    }
  };
  ajax.send();
}

function putDateForm(id, username, email, name, role) {
  if (name) {
    chargeRolesUpdate(role);
  }
  document.getElementById("id-update").innerHTML = id;
  document.getElementById("username-update").value = username;
  document.getElementById("email-update").value = email;
  if (name) {
    document.getElementById("name-update").value = name;
    document.getElementById("role-update").value = role.toString();
  }
}

function updateRow() {
  event.preventDefault();

  let url = document.getElementById("form-update").dataset.url;

  let type;
  if (url === "/persons/updatePerson") {
    type = "person";
  } else if (url === "/persons/updateEmployee") {
    type = "employee";
  } else if (url === "/persons/updatePlayer") {
    type = "player";
  }

  let id = document.getElementById("id-update");
  let name = document.getElementById("name-update");
  let username = document.getElementById("username-update");
  let email = document.getElementById("email-update");
  let password = document.getElementById("password-update");
  let role = document.getElementById("role-update");

  let data = {
    id: id.innerHTML,
    username: username.value,
    email: email.value,
    password: password.value,
  };

  if (name) {
    data["name"] = name.value;
    data["role"] = role.value;
  }

  let ajax = new XMLHttpRequest();
  ajax.open("POST", url, true);
  ajax.setRequestHeader("Content-Type", "application/json");
  ajax.onreadystatechange = () => {
    if (ajax.readyState === 4 && ajax.status === 200) {
      if (type === "person") {
        reloadScreen(
          content,
          "/persons/personsPage",
          "/persons/",
          table,
          personTableTemplate
        );
      } else if (type === "employee") {
        reloadScreen(
          content,
          "/persons/employeesPage",
          "/persons/employees",
          table,
          employeeTableTemplate
        );
      } else if (type === "player") {
        reloadScreen(
          content,
          "/persons/playersPage",
          "/persons/players",
          table,
          playerTableTemplate
        );
      }
      document.body.removeChild(
        document.getElementsByClassName("modal-backdrop")[0]
      );
    }
  };
  ajax.send(JSON.stringify(data));
}

function welcomePage() {
  let ajax = new XMLHttpRequest();
  ajax.onreadystatechange = () => {
    if (ajax.readyState === 4 && ajax.status === 200) {
      document.getElementById("content-new").innerHTML = ajax.responseText;
    }
  };
  ajax.open("GET", "/persons/welcome");
  ajax.send();
}
