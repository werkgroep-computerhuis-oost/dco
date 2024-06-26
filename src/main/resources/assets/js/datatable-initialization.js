'use strict';

function data_table_language() {
    let lang = $('html').attr('lang');
    if (lang === 'en') {
        return './assets/js/datatable/en-GB.json';
    }
    return './assets/js/datatable/nl-NL.json';
}
