const main = document.getElementById('feedbackBox');
const estrelas = document.getElementsByClassName('star');
const estrelasRadio = document.getElementsByName('rating');
const rating = document.getElementById('rating');
const comments = document.querySelector('textarea[name="comments"]');
const submit = document.querySelector('#submit input');

for (let i = 0; i < 5; i++)
    estrelas[i].addEventListener('click', () => {
        for (let j = 0; j <= i; j++)
            estrelas[j].classList.add('selected');
        for (let j = i + 1; j < 5; j++)
            estrelas[j].classList.remove('selected');
    });

main.addEventListener('click', e => {
    const target = e.target;

    if (target !== submit && target !== comments && target !== rating && !rating.contains(target)) {
        for (let i = 0; i < 5; i++) {
            estrelas[i].classList.remove('selected');
            estrelasRadio[i].checked = false;
        }

        estrelasRadio[0].checked = true;
    }
});