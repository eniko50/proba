function loadBooks() {
    $.get('api/books', function(data) {
        var fullHtml = '<table border="1">';
        fullHtml += '<tr><th>id</th><th>Name</th><th>Author</th><th>Price</th><th>Published</th></tr>';
        for (var book of data) {
            fullHtml += '<tr>';

            fullHtml += `<td>${book.id}</td>`;
            fullHtml += `<td>${book.name}</td>`;
            fullHtml += `<td>${book.author}</td>`;
            fullHtml += `<td>${book.price}</td>`;
            fullHtml += `<td>${book.publicationYear}</td>`;
            fullHtml += `<td><button id="delete_${book.id}">Obrisi</button></td>`;

            fullHtml += '</tr>';
        }
        fullHtml += '</table>';

        $('#book-list').html(fullHtml)
            .promise()
            .done(() => {
                for (let book of data) {
                    $(`#delete_${book.id}`).click(() => {
                        $.ajax({
                            url: `api/books/${book.id}`,
                            method: 'DELETE'
                        })
                        .done(() => {
                            console.log('deleted')
                        });
                    })
                }
            });
    });
}

$(document).ready(function() {
    loadBooks();
});
