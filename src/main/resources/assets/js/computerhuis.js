'use strict';

document.addEventListener('DOMContentLoaded', (event) => {
    document.querySelectorAll('.clickable').forEach(function (element) {
        element.addEventListener('click', function () {
            const currentPath = window.location.pathname;
            const newPath = element.getAttribute('data-href');
            window.location.href = currentPath + newPath;
        });
    });
});

