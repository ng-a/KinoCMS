let modal;

modal = new bootstrap.Modal($('#modal-window'), {
    keyboard: false
});

function modalShow() {
    modal.show();
}

function modalHide() {
    modal.hide();
}

document.getElementById('modal-window').addEventListener('hidden.bs.modal', function (event) {
    $("#modal-body").empty();
})