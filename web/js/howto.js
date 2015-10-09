$(document).ready(function () {

    $(".howto").css('display', 'none');
    $("#howtolist-getall").addClass('active');
    $(".howto").css('display', 'none');
    $(".howto-getall").fadeIn(200);

    $("#howtolist-getall").on('click', function () {
        $(".list-group-item").removeClass('active');
        $("#howtolist-getall").addClass('active');
        $(".howto").css('display', 'none');
        $(".howto-getall").fadeIn(200);
    });

    $("#howtolist-getspecific").on('click', function () {
        $(".list-group-item").removeClass('active');
        $("#howtolist-getspecific").addClass('active');
        $(".howto").css('display', 'none');
        $(".howto-getspecific").fadeIn(200);
    });

    $("#howtolist-postperson").on('click', function () {
        $(".list-group-item").removeClass('active');
        $("#howtolist-postperson").addClass('active');
        $(".howto").css('display', 'none');
        $(".howto-postperson").fadeIn(200);
    });

    $("#howtolist-delete").on('click', function () {
        $(".list-group-item").removeClass('active');
        $("#howtolist-delete").addClass('active');
        $(".howto").css('display', 'none');
        $(".howto-delete").fadeIn(200);
    });

});