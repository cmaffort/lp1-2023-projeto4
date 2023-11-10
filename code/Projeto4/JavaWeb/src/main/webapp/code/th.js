const tables = document.getElementsByTagName('table');

function setThWidth(table) {
    const thArr = table.getElementsByTagName('th');

    for (const th of thArr)
        th.style.width = (100 / thArr.length) + '%';
}

function fixTables() {
    for (const table of tables)
        setThWidth(table);
}

document.addEventListener('DOMContentLoaded', fixTables);