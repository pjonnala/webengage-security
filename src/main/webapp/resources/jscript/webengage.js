/**
 * All the buttons clicks are handled here.
 */

$( document ).ready(function() {
  //style buttons
    $( "button" ).button();
    //this is a hack! for action being appended coming right from delete. Need to figure out.
    $('#employeeSearch').attr('action', '/webengage-security');
  
});


function loadAddPage(){
	location.href='displayAddUser';
}

function loadHomePage(){
	location.href='/webengage-security';
}

function deleteUser(){
	$('#updateEmployee').attr('action', 'deleteUser');
	$("#updateEmployee").submit();

}



