/**
 * Created by asamoilov on 10.04.2017.
 */
function show() {
    var val = $("input[name='optradio']:checked").val();
    localStorage.setItem("cityId", val);

    if (val == '16') {
        jQuery("#city").text('Казань');
    }
    if (val == '77') {
        jQuery("#city").text('Москва');
    }

    getContent(val);
    $('#cityModal').modal('hide');
}

function getContent(cityId) {
    $.get("/getShowCaseList/" + cityId, function (x) {
        var t = '';
        for (var i in x) {
            t += '<div class="jumbotron" style="padding-bottom: 5px; padding-top: 8px;"><div class="row">' +
                '<img src="' + x[i].avatar + '" class="img-rounded pull-left" style="height: 50px; width: 50px;margin-right: 5px;"/>' +
                '<h4 style="margin-bottom: 0px;"><a href="/profile/' + x[i].id + '" style = "color: #222222; margin-bottom: 0px;">' + x[i].name +'</a></h4><br>' +
                '<span style="height: 50px;">' + x[i].note + '</span></div><div class="row" style="margin-top: 5px;">';
            for (var a in x[i].imageList) {
                t += '<div class= "col-xs-5 col-sm-3" ><a rel = "lightbox" href = "' + x[i].imageList[a].image + '">' +
                    '<img src = "' + x[i].imageList[a].image + '" class = "img-rounded" style = "height: 150px; width: 150px; display: block;">' +
                    '</a > </div >';
            }
            t += '<div class="row pull-left" style="margin-top:10px;"><p>' +
                '<span class="glyphicon glyphicon-rub" aria-hidden="true">' + x[i].minSum + '</span>' +
                '<span class="glyphicon glyphicon-thumbs-up" aria-hidden="true">' + x[i].like + '</span>' +
                '</p> </div> </div> </div>';
        }
        $('#showCase').html(t);
    });
}
function reloadPage(){
    var cityFilter = localStorage.getItem("cityId");

    if (cityFilter == "undefined" || cityFilter == null) {
        var cityLocation = ymaps.geolocation.city;
        var val;
        if (cityLocation == "Казань") {
            jQuery("#city").text('Казань');
            val = '16';
        } else {
            jQuery("#city").text('Москва');
            val = '77';
        }
        localStorage.setItem("cityId", val);

    } else {
        if (localStorage.getItem("cityId") == '16') {
            jQuery("#city").text('Казань');
        }
        if (localStorage.getItem("cityId") == '77') {
            jQuery("#city").text('Москва');
        }
    }
    $('input:radio[name="optradio"]').filter('[value=' + cityFilter + ']').prop("checked", true);
    getContent(cityFilter);
}