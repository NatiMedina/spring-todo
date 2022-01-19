// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarUsuarios();
  $('#Todos').DataTable();
});

async function cargarUsuarios(){

    const request = await fetch('todos', {
    method: 'GET',
    headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
        }
    });
    const todos = await request.json();
    console.log(todos);

    let todo = '<tr><td>0</td> <td>todo</td><td>hay que regar las plantas</td><td>2022/01/12</td><td><a href="#" class="btn btn-warning btn-circle"><i class="fas fa-exclamation-triangle"></i></a><a href="#" class="btn btn-danger btn-circle"><i class="fas fa-trash"></i></a></td></tr>';

    document.querySelector('#todos tbody').outerHTML = todo;
}
