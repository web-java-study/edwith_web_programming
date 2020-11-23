/*var btnNew = document.getElementById('btnAdd');
btnNew.onclick = addNewItem;

function addNewItem() {
	var listItem = document.createElement('li');
	listItem.innerText = "Hello";
	
	var list = document.getElementById('todolist');
	list.appendChild(listItem); 
}
*/

var table = document.createElement("table");
table.border = 1;
table.width = "100%"

var td = document.createElement( "TD" ); 
     td.innerHTML = string; 
     td.style.border = "1px solid #92acbb"; 
     td.style.padding = "3px"; 

var tr = document.createElement( "TR" ); 
    tr.appendChild( td ); 

var table = document.createElement( "TABLE" ); 
    table.appendChild( tr ); 

setTable.appendChild( table ); 
