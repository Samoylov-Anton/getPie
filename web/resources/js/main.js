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
                '<h5 style="margin-bottom: 0px;"><a href="/showCase/' + x[i].id + '" style = "color: #34495e; margin-bottom: 0px;">' + x[i].name +'</a></h5><br>' +
                '<p style="height: 50px;font-size: 86%; line-height: 2.067;">' + x[i].note + '</p></div><div class="row" style="margin-top: 5px;">';
            for (var a in x[i].imageList) {
                t += '<div class= "col-xs-5 col-sm-3" style="height: 120px; width: 120px; padding: 0px; margin-right: 10px;margin-left: 10px;">' +
                    '<a rel = "lightbox" href = "/images/' + x[i].imageList[a].largePath + '">' +
                    '<img src = "/images/' + x[i].imageList[a].litePath + '" class = "img-rounded" style = "width: 100%; height: 100%; object-fit: cover;">' +
                    '</a > </div >';
            }
            t += '<div class="pull-right" style="margin-top:10px;"><h4>' +
                '<span class="glyphicon glyphicon-rub" aria-hidden="true" style="margin-right:10px;">' + x[i].minSum + '</span>' +
                '<span class="glyphicon glyphicon-thumbs-up" aria-hidden="true">' + x[i].like + '</span>' +
                '</h4> </div> </div> </div>';
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