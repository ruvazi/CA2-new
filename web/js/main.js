$(document).ready(function () {

    var curID;

    ////////////////////////////////////////////////////////////////////////////
    ////////    GET PERSONS ON LOAD

    apiGET('http://localhost:8084/api/person/complete/', personsLoaded200, personsLoaded404, personsLoaded500);


    ////////////////////////////////////////////////////////////////////////////
    ////////    EVENT HANDLERS
    $("#get-person").on('click', function () {
        apiGET('http://localhost:8084/api/person/complete/' + $("#get-person-field").val(),
                singlePerson200, singlePerson404, singlePerson500);
    });

    $("#create-person").on('click', function () {
        var generatedJSON = {
            firstname: $("#create-person-fname").val(),
            lastname: $("#create-person-lname").val(),
            email: $("#create-person-email").val()
        };

        apiPOST('http://localhost:8084/api/person/', generatedJSON, personCreated200, personCreated404, personCreated500);
    });






    ////////////////////////////////////////////////////////////////////////////
    ////////    API FUNCTIONS

    function apiGET(url, resp200, resp404, resp500) {
        $.ajax(url, {
            type: 'GET',
            statusCode: {
                200: resp200,
                404: resp404,
                500: resp500
            }
        });
    }

    function apiPOST(url, obj, resp200, resp404, resp500) {
        $.ajax(url, {
            data: JSON.stringify(obj),
            contentType: 'application/json',
            type: 'POST',
            async: true,
            statusCode: {
                200: resp200,
                404: resp404,
                500: resp500
            }
        });
    }

    function apiUPDATE(url, obj, resp200, resp404, resp500) {
        $.ajax(url, {
            data: JSON.stringify(obj),
            contentType: 'application/json',
            type: 'UPDATE',
            async: true,
            statusCode: {
                200: resp200,
                404: resp404,
                505: resp500
            }
        });
    }


    ////////////////////////////////////////////////////////////////////////////
    ////////    CALLBACK FUNCTIONS - GET SINGLE PERSON

    function singlePerson200(data) {
        console.log(data);
        $("#person").html("");
        $("#person").html(
                '<br><p>'
                + '<b>First Name:</b>' + data.firstname + '<br>'
                + '<b>Last Name:</b>' + data.lastname + '<br>'
                + '</p>'
                );
    }

    function singlePerson404() {
        $("#person").html("");
        $("#person").html('<p class="text-danger">Could not connect to host. Please try again later</p>');
    }

    function singlePerson500() {
        $("#person").html("");
        $("#person").html('<p class="text-danger">The person could not be found. Please make sure you are providing a valid ID.</p>');
    }



    ////////////////////////////////////////////////////////////////////////////
    ////////    CALLBACK FUNCTIONS - CREATE PERSON

    function personCreated200(data) {
        $("#person-created").html("");
        $("#person-created").html('<br><p class="text-success">' + data.firstname + ' was succesfully created!' + '</p>');
        apiGET('http://localhost:8084/api/person/complete/', personsLoaded200, personsLoaded404, personsLoaded500);
    }

    function personCreated404() {
        $("#person-created").html("");
        $("#person-created").html('<br><p class="text-danger">Could not connet to host. Please try again later.</p>');
    }

    function personCreated500() {
        $("#person-created").html("");
        $("#person-created").html('<br><p class="text-danger">Your person was not created. Please recheck your input.</p>');
    }

    ////////////////////////////////////////////////////////////////////////////
    ////////    CALLBACK FUNCTIONS - LOAD ALL PERSONS

    function personsLoaded200(data) {



        $("#person-table tbody").html("");
        for (var i = 0, max = data.length; i < max; i++) {
            $("#person-table tbody")
                    .append(
                            '<tr id="person-' + data[i].id + '">'
                            + '<td>' + data[i].id + '</td>'
                            + '<td>' + data[i].firstname + '</td>'
                            + '<td>' + data[i].lastname + '</td>'
                            + '<td class="text-center">'
                            + '<button class="delete label label-danger" id="delete-' + data[i].id + '">Delete</button>'
                            + '<button class="edit label label-default" value="' + data[i].id + '" data-toggle="modal" data-target="#edit-person-modal">Edit</button>'
                            + '</td>'
                            + '</tr>'
                            );
        }

        $(".edit").on('click', function () {
            curID = this.value;
            console.log(curID);
        });


        $(".update").on('click', function () {
            var obj = {
                firstname: '',
                lastname: ''
            };
            apiUPDATE('http://localhost:8084/api/person/complete' + this.value, obj, personUpdated200, personUpdated404, personUpdated500);
        });

        $(".modal").on('show.bs.modal', function () {
            apiGET('http://localhost:8084/api/person/complete/' + curID, modalOpened200);
        });
    }

    function personsLoaded404(data) {
        alert('No connection to the server. Please try again later.');
    }

    function personsLoaded500(data) {
        alert('There was an error in the server. Please try again later.');
    }

    ////////////////////////////////////////////////////////////////////////////
    ////////    CALLBACK FUNCTIONS - UPDATE PERSON

    function personUpdated200(data) {
        console.log("Person successfully updated");
    }

    function personUpdated404(data) {

    }

    function personUpdated500(data) {

    }
    
    function modalOpened200(data) {
        $('.modal-header').html("Edit user " + data.id);
        $('#edit-firstname').val(data.firstname);
        $('#edit-lastname').val(data.lastname);
    }
});

