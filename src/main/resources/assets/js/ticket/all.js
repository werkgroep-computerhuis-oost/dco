'use strict';

$(document).ready(function () {
    $('#ticket-table').DataTable({
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
                    return row['ticketTypeName'];
                }
            },
            {
                render: function (data, type, row, meta) {
                    return row['categoryName'];
                }
            },
            {
                render: function (data, type, row, meta) {
                    return row['statusName'];
                }
            },
            {
                render: function (data, type, row, meta) {
                    return '<a class="link-opacity-25-hover" href="./apparatuur/' + row['equipmentId'] + '">' + row['equipmentId'] + '</a>';
                }
            },
            {
                render: function (data, type, row, meta) {
                    return new Date(row['registered']).toLocaleDateString();
                }
            },
            {
                render: function (data, type, row, meta) {
                    if (row['unregistered'] != null) {
                        return new Date(row['unregistered']).toLocaleDateString();
                    }
                    return '';
                }
            }
        ],
        language: {
            url: data_table_language()
        },
        ajax: './api/ticket'
    }).column('0:visible')
        .order('desc')
        .draw();
});
