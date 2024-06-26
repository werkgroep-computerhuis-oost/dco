'use strict';

$(document).ready(function () {
    $('#timesheet-table').DataTable({
        pageLength: 20,
        layout: {
            topStart: null
        },
        columns: [
            {
                render: function (data, type, row, meta) {
                    let name = '';
                    if (row['firstName'] !== null) {
                        name += row['firstName'];
                    }
                    if (row['infix'] !== null) {
                        name += ' ' + row['infix'];
                    }
                    if (row['lastName'] !== null) {
                        name += ' ' + row['lastName'];
                    }
                    return '<a class="link-opacity-25-hover" href="./persoon/' + row['personId'] + '">' + name.trim() + '</a>';
                }
            },
            {
                render: function (data, type, row, meta) {
                    return '<a class="link-opacity-25-hover" href="./activiteit/' + row['activityId'] + '">' + row['activityName'] + '</a>';
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
        ajax: './api/tijdregistratie'
    }).column('0:visible')
        .order('desc')
        .draw();
});
