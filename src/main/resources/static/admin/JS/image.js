function uploadMainImage(image_id) {
    let reader = new FileReader();
    let image = $('#main-file-'+ image_id).prop('files')[0];

    reader.onload = function(){
        $("#main-image-" + image_id).attr("src", reader.result);
    }

    reader.readAsDataURL(image);
}

$(document).on("click", "#add-main-image", function () {
    let image_id = $("#main-images").children().length;

    $("#add-block-main-image").before(
        '                        <div class="main-image-block position-relative d-inline-block img-width me-4 my-2">\n' +
        '                            <label class="" for="main-file-'+(image_id)+'">\n' +
        '                                <img id="main-image-'+(image_id)+'" class="rounded" src="/user/icons/default.png" width="160" height="100">\n' +
        '                                <input id="main-file-'+(image_id)+'" type="file" name="main-image" onchange="uploadMainImage('+(image_id)+')" multiple accept="image/*" style="display:none">\n' +
        '                            </label>\n' +
        '                        </div>').remove();
});

function uploadGalleryImage(image_id) {
    let reader = new FileReader();
    let image = $('#gallery-file-'+ image_id).prop('files')[0];

    reader.onload = function(){
        $("#gallery-image-" + image_id).attr("src", reader.result);
    }

    reader.readAsDataURL(image);
}

$(document).on("click", "#add-gallery-image", function () {
    let image_id = $("#gallery-images").children().length;

    $("#add-block-gallery-image").before(
        '                        <div id="gallery-image-block-'+ image_id +'" name="gallery-image-block" class="image-block position-relative d-inline-block img-width me-4 my-2">\n' +
        '                            <button type="button" id="deleteImage"  class="position-absolute top-0 start-100 translate-middle btn" style="border-radius: 50%; background: rgba(192, 192, 192, 0.5);" >\n' +
        '                               <img src="/admin/icons/cancel.svg" height="15" width="15">' +
        '                            </button>\n' +
        '\n' +
        '                            <label class="" for="gallery-file-'+(image_id)+'">\n' +
        '                                <img id="gallery-image-'+(image_id)+'" class="rounded" src="/user/icons/default.png" width="160" height="100">\n' +
        '                                <input id="gallery-file-'+(image_id)+'" type="file" name="gallery-image" onchange="uploadGalleryImage('+(image_id)+')" multiple accept="image/*" style="display:none">\n' +
        '                            </label>\n' +
        '                        </div>');

});

$(document).on("click", "#deleteImage" , function() {
    $(this).parent().remove();

    $.each($("[name='gallery-image-block']"), function (index, value) {
        value.id = value.id.replace(/[0-9]/g, index + 1);

    });
});