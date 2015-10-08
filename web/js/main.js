$(document).ready(function() {

  // EVENT HANDLERS

  $("#get-person").on('click', function() {
    var id = $("#get-person-field").val();
    personGET('http://localhost:8080/api/person/complete/'+id, personReceived);
  });

  $("#create-person").on('click', function() {
    var fname = $("#create-person-fname").val();
    var lname = $("#create-person-lname").val();
    var mail = $("#create-person-email").val();

    var newPerson = {
      firstname: fname,
      lastname: lname,
      email: mail
    }

    personPOST('http://localhost:8080/api/person/', newPerson);
  });


  // REST API ACCESSORS

  function personGET(url, callback) {
      $.getJSON(url, function (data) {
        callback(data);
      });
  }

  function personPOST(url, obj) {
      $.ajax(url, {
        data: JSON.stringify(obj),
        contentType: 'application/json',
        type: 'POST',
        async: true,
        success: personCreated
      })
  }

  // CALLBACK FUNCTIONS

  function personReceived(data) {
      $("#person").html("");
      $("#person").html(data.firstname + " " + data.lastname);
  }

  function personCreated(data) {
      $("#person-created").html("");
      $("#person-created").html(data.firstname + " succesfully created!");
  }

});

