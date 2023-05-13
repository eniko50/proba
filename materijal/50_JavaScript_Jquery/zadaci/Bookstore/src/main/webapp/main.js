function getHeader() {
    return "<tr><th>Naslov</th><th>Autor</th><th>Godina izdanja</th><th>Cena</th></tr>";
}

function getRows(result) {
    var text = "";

    for (var i = 0; i < result.length; i++) {
        var book = result[i];
        text += "</tr>";
        text += "<td>" + book.name + "</td>";
        text += "<td>" + book.author + "</td>";
        text += "<td>" + book.publicationDate + "</td>";
        text += "<td>" + book.cost + "</td>";
        text += '<td><button class="delete-book" data-id="' + book.id + '">Obrisi</button></td>';
        text += "</tr>";
    }

    return text;
}

function showResult(result) {
    $('#table').html(getHeader() + getRows(result));
}

function showAll() {
    $.ajax({
        url: "/api/books",
        success: showResult
    });
}

function showForAuthor(authorName) {
    $.ajax({
        url: "/api/books?author=" + authorName,
        success: showResult
    });
}

function showByBookName(bookName) {
    $.ajax({
        url: "/api/books?name=" + bookName,
        success: showResult
    });
}

function deleteBook(bookId) {
    $.ajax({
        url: "/api/books/" + bookId,
        method: 'DELETE',
        success: showAll
    });
}

function showByPrice(from, to) {
    $.ajax({
        url: "/api/books?from=" + from + "&to=" + to,
        success: showResult
    })
}

function addNewBook(newBook) {
    $.ajax({
        url: "/api/books",
        method: "POST",
        contentType: 'application/json',
        data: JSON.stringify(newBook),
        success: showAll
    });
}

$(document).ready(function () {
    $('#show-all').click(function () {
        showAll();
    });

    $('#show-author').click(function () {
        var authorName = $('#author-name').val();
        showForAuthor(authorName);
    });

    $('#show-by-name').click(function () {
        var bookName = $('#book-name').val();
        showByBookName(bookName);
    });

    // Mora ovako posto se redovi tabele dodaju dinamicki.
    // JQuery ne moze onda direktno da koristi klik listener na .delete-book
    // nego se na tabelu zakaci ovaj listener koji osluskuje na dogadjaje potomaka
    // tabele koji su u ovom slucaju definisani kao button.delete-book.
    $('table').on('click', 'button.delete-book', function () {
        var id = $(this).data("id");
        deleteBook(id);
    });

    $('#show-by-price').click(function () {
        var from = $('#cost-from').val();
        var to = $('#cost-to').val();

        showByPrice(from, to);
    });

    $('#create').click(function () {
        var name = $('#new-book-name').val();
        var author = $('#new-book-author').val();
        var year = $('#new-book-year').val();
        var cost = $('#new-book-cost').val();

        var newBook = {
            name: name,
            author: author,
            publicationDate: year,
            cost: cost
        };

        addNewBook(newBook);
    });

    showAll();

});