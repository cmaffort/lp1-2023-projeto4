const tables = document.getElementsByTagName('table');

function setThWidth(table) {
    const thArr = table.getElementsByTagName('th');

    for (const th of thArr)
        th.style.width = (100 / thArr.length) + '%';
}

document.addEventListener('DOMContentLoaded', () => {
    for (const table of tables)
        setThWidth(table);
});