'use strict';

window.computerhuis = window.computerhuis || {};

computerhuis.isBlank = function (value) {
    return typeof value == 'string' && !value.trim() || typeof value == 'undefined' || value === null;
}

computerhuis.csrf = function (headers) {
    headers[$("meta[name='_csrf_header']").attr("content")] = $("meta[name='_csrf']").attr("content");
    return headers;
}

computerhuis.button = {};
computerhuis.button.nav = {};

computerhuis.button.nav.aan = function () {
    $('#verder').removeAttr('disabled');
    $('#verder-spinner').addClass('visually-hidden');

    $('#terug').removeAttr('disabled');
    $('#terug-spinner').addClass('visually-hidden');
    $('#terug').on("click", function () {
        computerhuis.button.nav.uit();
        computerhuis.button.nav.vorige();
    });
}

computerhuis.button.nav.uit = function () {
    $('#verder').attr('disabled', true);
    $('#verder-spinner').removeClass('visually-hidden');

    $('#terug').attr('disabled', true);
    $('#terug-spinner').removeClass('visually-hidden');
}

computerhuis.button.nav.volgende = function () {
    $(location).attr('href', $('#verder').attr('data-href'));
}

computerhuis.button.nav.vorige = function () {
    $(location).attr('href', $('#terug').attr('data-href'));
}

computerhuis.button.toevoegen = {}
computerhuis.button.toevoegen.aan = function () {
    $('#toevoegen').removeAttr('disabled');
    $('#toevoegen-spinner').addClass('visually-hidden');
};

computerhuis.button.toevoegen.uit = function () {
    $('#toevoegen').attr('disabled', true);
    $('#toevoegen-spinner').removeClass('visually-hidden');
};

computerhuis.api = {};

computerhuis.api.get = function (url, successCallback, data = null) {
    $.get({
        url: url,
        data: data,
        contentType: 'application/json',
        statusCode: computerhuis.api.statusCode(successCallback)
    });
}

computerhuis.api.put = function (url, data, successCallback) {
    computerhuis.api.ajax('PUT', url, data, successCallback);
}

computerhuis.api.post = function (url, data, successCallback) {
    computerhuis.api.ajax('POST', url, data, successCallback);
}

computerhuis.api.delete = function (url, data, successCallback) {
    computerhuis.api.ajax('DELETE', url, data, successCallback);
}

computerhuis.api.ajax = function (method, url, data, successCallback) {
    $.ajax({
        type: method,
        url: url,
        contentType: 'application/json',
        headers: computerhuis.csrf({}),
        dataType: 'json',
        data: JSON.stringify(data),
        statusCode: computerhuis.api.statusCode(successCallback)
    });
}

computerhuis.api.statusCode = function (successCallback) {
    return {
        200: successCallback,
        403: function (response) {
            computerhuis.button.toevoegen.aan();
            alert(response.responseJSON.error + ":\n\n" + response.responseJSON.message)
            return false;
        },
        406: function (response) {
            computerhuis.button.toevoegen.aan();
            alert(response.responseJSON.error + ":\n\n" + response.responseJSON.message)
            return false;
        },
        413: function (response) {
            computerhuis.button.toevoegen.aan();
            alert(response.responseJSON.error + ":\n\n" + response.responseJSON.message)
            return false;
        },
        415: function (response) {
            computerhuis.button.toevoegen.aan();
            alert(response.responseJSON.error + ":\n\n" + response.responseJSON.message)
            return false;
        },
        500: function (response) {
            computerhuis.button.toevoegen.aan();
            alert(response.responseJSON.error + ":\n\n" + response.responseJSON.message)
            return false;
        }
    }
}

computerhuis.bijlage = {}
computerhuis.bijlage.send = function (url, data, successCallback) {
    $.ajax({
        type: 'PUT',
        url: url,
        contentType: false,
        headers: computerhuis.csrf({}),
        processData: false,
        cache: false,
        data: data,
        statusCode: computerhuis.api.statusCode(successCallback)
    });
}
