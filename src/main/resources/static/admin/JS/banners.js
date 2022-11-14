function uploadImageUp(id) {
    let reader = new FileReader();
    let image = $('#banners-block-file-up-'+ id).prop('files')[0];

    reader.onload = function(){
        $("#banners-block-image-up-" + id).attr("src", reader.result);
    }

    reader.readAsDataURL(image);
}

function createBannerBlockUp() {
    let block_id = $("#banners-blocks-up").children().length;

    $("#banners-block-add-up").before(
        '     <div id="banners-block-up-' + block_id + '" name="banners-blocks-up" class="col-auto my-3">\n' +
        '        <div class="card" style="width: 15rem;">\n' +
        '          <button type="button" onclick="deleteBannerBlockUp(' + block_id + ')" class="position-absolute top-0 start-100 translate-middle btn" style="border-radius: 50%; background: rgba(192, 192, 192, 0.5);">\n' +
        '            <img id="banners-block-image-id-' + block_id + '" src="/admin/icons/cancel.svg" height="15" width="15">\n' +
        '          </button>\n' +
        '          <label class="file">' +
        '           <img id="banners-block-image-up-' + block_id + '" src="/user/icons/default.png" class="card-img-top" alt="...">\n' +
        '           <input id="banners-block-file-up-' + block_id + '" type="file" name="image-up" onChange="uploadImageUp(' + block_id + ')" multiple="" accept="image/*"\n' +
        '             style="display:none">' +
        '          </label>' +
        '          <div class="card-body">\n' +
        '            <div class="row my-2">\n' +
        '              <label for="seo-link" class="col-auto col-form-label">URL</label>\n' +
        '              <div class="col">\n' +
        '                <input type="text" id="banners-block-link-up-' + block_id + '" name="banners-block-link-up" class="form-control">\n' +
        '              </div>\n' +
        '            </div>\n' +
        '            <div class="row my-2">\n' +
        '              <label for="seo-link" class="col-auto col-form-label">Text</label>\n' +
        '              <div class="col">\n' +
        '                <input type="text" id="banners-block-text-up-' + block_id + '" name="banners-block-text-up" class="form-control">\n' +
        '              </div>\n' +
        '            </div>\n' +
        '          </div>\n' +
        '        </div>\n' +
        '      </div>'
    )
}

function deleteBannerBlockUp(id) {
    $("#banners-block-up-" + id).remove();

    $("[name='banners-blocks-up']").each( function (index, value) {
        value.id = value.id.replace(/[0-9]/g, index + 1);
        $(value).find('button').attr("onclick", "deleteBannerBlockUp(" + (index + 1) +")");
        $(value).find('.file').find('img').attr("id", "banners-block-image-up-" + (index + 1));
        $(value).find('.file').find('input').attr("id", "banners-block-file-up-" + (index + 1));
        $(value).find('.file').find('input').attr("onchange", "uploadImageUp(" + (index + 1) + ")");
        $(value).find("[name='banners-block-link-up']").attr("id", "banners-block-link-up-" + (index + 1));
        $(value).find("[name='banners-block-text-up']").attr("id", "banners-block-text-up-" + (index + 1));
    });

}

function uploadImageNews(id) {
    let reader = new FileReader();
    let image = $('#banners-block-file-news-'+ id).prop('files')[0];

    reader.onload = function(){
        $("#banners-block-image-news-" + id).attr("src", reader.result);
    }

    reader.readAsDataURL(image);
}

function createBannerBlockNews() {
    let block_id = $("#banners-blocks-news").children().length;

    $("#banners-block-add-news").before(
        '      <div id="banners-block-news-' + block_id + '" name="banners-blocks-news" class="col-auto my-3">\n' +
        '        <div class="card" style="width: 15rem;">\n' +
        '          <button type="button" onclick="deleteBannerBlockNews('+ block_id +')" class="position-absolute top-0 start-100 translate-middle btn" style="border-radius: 50%; background: rgba(192, 192, 192, 0.5);">\n' +
        '            <img id="image-block-2" src="/admin/icons/cancel.svg" height="15" width="15">\n' +
        '          </button>\n' +
        '          <label class="file">' +
        '           <img id="banners-block-image-news-' + block_id + '" src="/user/icons/default.png" class="card-img-top" alt="...">\n' +
        '           <input id="banners-block-file-news-' + block_id + '" type="file" name="image-up" onChange="uploadImageNews(' + block_id + ')" multiple="" accept="image/*"\n' +
        '             style="display:none">' +
        '          </label>' +
        '          <div class="card-body">\n' +
        '            <div class="row my-2">\n' +
        '              <label for="seo-link" class="col-auto col-form-label">URL</label>\n' +
        '              <div class="col">\n' +
        '                <input type="text" id="banners-block-link-news-' + block_id + '" name="banners-block-link-news" class="form-control">\n' +
        '              </div>\n' +
        '            </div>\n' +
        '\n' +
        '          </div>\n' +
        '\n' +
        '        </div>\n' +
        '      </div>'
    )
}

function deleteBannerBlockNews(id) {
    $("#banners-block-news-" + id).remove();

    $("[name='banners-blocks-news']").each( function (index, value) {
        value.id = value.id.replace(/[0-9]/g, index + 1);
        $(value).find('button').attr("onclick", "deleteBannerBlockNews(" + (index + 1) +")");
        $(value).find('.file').find('img').attr("id", "banners-block-image-news-" + (index + 1));
        $(value).find('.file').find('input').attr("id", "banners-block-file-news-" + (index + 1));
        $(value).find('.file').find('input').attr("onchange", "uploadImageNews(" + (index + 1) + ")");
        $(value).find("[name='banners-block-link-up']").attr("id", "banners-block-link-news-" + (index + 1));
    });

}