const form = document.getElementById('update');
const foto = document.getElementById('foto');
const popup = document.getElementById('popup');
const popupContent = document.getElementById('popup-content');
const submit = document.querySelector('#submit input');
const preview = document.getElementById('crop-preview');
let cropper;

function hidePopup() {
    popup.style.display = 'none';
    if (cropper) {
        cropper.destroy();
        cropper = null;
    }
}

function showPopup() {
    popup.style.display = 'flex';
}

function handleInput() {
    const file = foto.files[0];

    if (file) {
        if (cropper) {
            cropper.destroy();
        }

        cropper = new Cropper(preview, {
            aspectRatio: 1,
            viewMode: 1,
        });

        const reader = new FileReader();

        reader.onload = function (e) {
            cropper.replace(e.target.result);
        };

        reader.readAsDataURL(file);

        foto.value = "";
    }
}

foto.addEventListener('change', () => {
    showPopup();
    handleInput();
});

popup.addEventListener('click', (e) => {
    const target = e.target;

    if (!popupContent.contains(target)) 
        hidePopup();
});

submit.addEventListener('click', (e) => {
    e.preventDefault();

    if (cropper) {
        const canvas = cropper.getCroppedCanvas();

        canvas.toBlob((blob) => {
            const croppedFile = new File([blob], 'cropped-image.png', { type: 'image/*' });
            const formData = new FormData(form);
            formData.set('foto', croppedFile);

            fetch(form.action, {
                method: form.method,
                body: formData,
            })
            .then(response => {
                if (response.redirected)
                    window.location.href = response.url;
            })
            .catch(error => {
                console.error(error);
            })
            .finally(() => {
                hidePopup();
            });
        });
    }
});