console.log("scripts.js loaded");

window.openEditModal = function(button) {
    var id = button.getAttribute('data-id');
    var titulo = button.getAttribute('data-titulo');
    var autor = button.getAttribute('data-autor');
    var categoria = button.getAttribute('data-categoria');
    var preco = button.getAttribute('data-preco');
    var isbn = button.getAttribute('data-isbn');

    document.getElementById('editId').value = id;
    document.getElementById('editTitulo').value = titulo;
    document.getElementById('editAutor').value = autor;
    document.getElementById('editCategoria').value = categoria;
    document.getElementById('editPreco').value = preco;
    document.getElementById('editIsbn').value = isbn;

    document.getElementById('editModal').classList.add('active');
    document.getElementById('modalOverlay').classList.add('active');
};

window.closeEditModal = function() {
    document.getElementById('editModal').classList.remove('active');
    document.getElementById('modalOverlay').classList.remove('active');
};

window.openDeleteModal = function(button) {
    var id = button.getAttribute('data-id');
    var titulo = button.getAttribute('data-titulo');

    document.getElementById('deleteMensagem').innerText = "Deseja excluir o livro: " + titulo + "?";
    document.getElementById('confirmDeleteButton').setAttribute('data-id', id);

    document.getElementById('deleteModal').classList.add('active');
    document.getElementById('modalOverlay').classList.add('active');
};

window.closeDeleteModal = function() {
    document.getElementById('deleteModal').classList.remove('active');
    document.getElementById('modalOverlay').classList.remove('active');
};

window.closeAllModals = function() {
    window.closeEditModal();
    window.closeDeleteModal();
};

document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('confirmDeleteButton').addEventListener('click', function() {
        var id = this.getAttribute('data-id');
        window.location.href = '/livro/deletar/' + id;
    });
});

