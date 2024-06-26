'use strict';

$(document).ready(function () {
    $('#postal-table').DataTable({
        pageLength: 20,
        layout: {
            topStart: null
        },
        columns: [
            {
                render: function (data, type, row) {
                    return '<a class="link-opacity-25-hover" href="./postcode/' + row['code'] + '">' + row['code'] + '</a>';
                }
            },
            {
                render: function (data, type, row) {
                    let number = ''
                    if (row['houseNumberMin'] !== null) {
                        number += row['houseNumberMin'];
                    }
                    if (row['houseNumberMin'] !== null && row['houseNumberMax'] !== null) {
                        number += ' - ';
                    }
                    if (row['houseNumberMax'] !== null) {
                        number += row['houseNumberMax'];
                    }
                    return number.trim();
                }
            },
            {
                render: function (data, type, row) {
                    return row['street'];
                }
            },
            {
                render: function (data, type, row) {
                    return row['neighbourhood'];
                }
            },
            {
                render: function (data, type, row) {
                    return row['district'];
                }
            }
        ],
        language: {
            url: data_table_language()
        },
        ajax: './api/postcode'
    }).column('0:visible')
        .order('asc')
        .draw();
});
