'use strict';

$(document).ready(function () {
    $('#person-table').DataTable({
        pageLength: 20,
        layout: {
            topStart: null
        },
        columns: [
            {
                render: function (data, type, row, meta) {
                    return '<a class="link-opacity-25-hover" href="./persoon/' + row['id'] + '">' + row['id'] + '</a>';
                }
            },
            {
                render: function (data, type, row, meta) {
                    return row['initials'];
                }
            },
            {
                render: function (data, type, row, meta) {
                    return row['infix'];
                }
            },
            {
                render: function (data, type, row, meta) {
                    return row['lastName'];
                }
            },
            {
                render: function (data, type, row, meta) {
                    if (row['email'] != null) {
                        return '<a class="link-opacity-25-hover" href="mailto:' + row['email'] + '">' + row['email'] + '</a>';
                    }
                    return '';
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
        ajax: './api/persoon'
    }).column('0:visible')
        .order('desc')
        .draw();
});
