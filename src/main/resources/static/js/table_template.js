function personTableTemplate(obj) {
    return `
                    <tr>
                      <td>${obj.username}</td>
                      <td>
                        <button class="btn" data-bs-toggle="modal" data-bs-target="#updateRegister" onclick="putDateForm(${obj.id}, '${obj.username}', '${obj.email}')">
                            <i class="fa fa-pencil" style="color: #e1b317; font-size:1.25em;"></i>
                        </button>
                      </td>
                      <td>
                        <button class="btn" data-bs-toggle="modal" data-bs-target="#deleteRegister" onclick="putDataConfirmation(${obj.id}, '${obj.username}')">
                            <i class="fa fa-trash" style="color: #d41616; font-size:1.25em;"></i>
                        </button>
                      </td>
                    </tr>
                `;
}

function employeeTableTemplate(obj) {
    return `
                    <tr>
                      <th scope="row">${obj.id}</th>
                      <td>${obj.name}</td>
                      <td>${obj.username}</td>
                      <td>${obj.email}</td>
                      <td>${obj.role_name}</td>
                      <td>
                        <button class="btn" data-bs-toggle="modal" data-bs-target="#updateRegister" onclick="putDateForm(${obj.id}, '${obj.username}', '${obj.email}', '${obj.name}', '${obj.role_name}')">
                            <i class="fa fa-pencil" style="color: #e1b317; font-size:1.25em;"></i>
                        </button>
                      </td>
                      <td>
                        <button class="btn" data-bs-toggle="modal" data-bs-target="#deleteRegister" onclick="putDataConfirmation(${obj.id}, '${obj.name}')">
                            <i class="fa fa-trash" style="color: #d41616; font-size:1.25em;"></i>
                        </button>
                      </td>
                    </tr>
                `;
}
function playerTableTemplate(obj) {
    return `
                    <tr>
                      <th scope="row">${obj.id}</th>
                      <td>${obj.username}</td>
                      <td>${obj.email}</td>
                      <td>${obj.coins}</td>
                      <td>${obj.money}</td>
                      <td>
                        <button class="btn" data-bs-toggle="modal" data-bs-target="#updateRegister" onclick="putDateForm(${obj.id}, '${obj.username}', '${obj.email}')">
                            <i class="fa fa-pencil" style="color: #e1b317; font-size:1.25em;"></i>
                        </button>
                      </td>
                      <td>
                        <button class="btn" data-bs-toggle="modal" data-bs-target="#deleteRegister" onclick="putDataConfirmation(${obj.id}, '${obj.username}')">
                            <i class="fa fa-trash" style="color: #d41616; font-size:1.25em;"></i>
                        </button>
                      </td>
                    </tr>
                `;
}

function populateTable(data, table_name, func) {
    data.forEach(obj => {
        document.getElementById(table_name).innerHTML += func(obj);
    })
}