'use strict';

window.computerhuis = window.computerhuis || {};

computerhuis.workshop_search_person = function (firstName, lastName) {

}

$(document).ready(function () {
    let table = $('#dashboard-table').DataTable({
        pageLength: 20,
        layout: {
            topStart: null
        },
        columns: [
            {
                render: function (data, type, row, meta) {
                    return '<a class="link-opacity-25-hover" href="./ticket/' + row['id'] + '">' + row['id'] + '</a>';
                }
            },
            {
                render: function (data, type, row, meta) {
                    return row['firstName'] + ' ' + row['infix'] + ' ' + row['lastName'];
                }
            },
            {
                render: function (data, type, row, meta) {
                    return '<a class="link-opacity-25-hover" href="./apparatuur/' + row['equipmentId'] + '">' + row['equipmentId'] + '</a>';
                }
            },
            {
                render: function (data, type, row, meta) {
                    switch (row['status']) {
                        case 'IN_PROGRESS':
                            return '<span class="badge text-bg-danger">' + row['statusName'] + '</span>';
                        case 'OPEN':
                            return '<span class="badge text-bg-success">' + row['statusName'] + '</span>';
                        case 'READY':
                            return '<span class="badge text-bg-primary">' + row['statusName'] + '</span>';
                        case 'CUSTOMER_INFORMED':
                            return '<span class="badge text-bg-warning">' + row['statusName'] + '</span>';
                        case 'CLOSED':
                            return '<span class="badge text-bg-secondary">' + row['statusName'] + '</span>';
                    }
                }
            },
            {
                render: function (data, type, row, meta) {
                    return new Date(row['registered']).toLocaleDateString();
                }
            },
            {
                render: function (data, type, row, meta) {
                    return row['categoryName'];
                }
            },
            {
                render: function (data, type, row, meta) {
                    if (row['model'] == '') {
                        return row['manufacturer'];
                    }
                    return row['manufacturer'] + ' / ' + row['model'];
                }
            },
            {
                render: function (data, type, row, meta) {
                    let json = JSON.parse(row['description'])
                    return json['probleem'];
                }
            },
            {
                render: function (data, type, row, meta) {
                    return "";
                }
            }
        ],
        language: {
            url: data_table_language()
        },
        ajax: './api/werkplaats'
    }).column('3:visible')
        .order('desc')
        .draw();

    setInterval(function () {
        table.ajax.reload();
    }, 120_000);
});
